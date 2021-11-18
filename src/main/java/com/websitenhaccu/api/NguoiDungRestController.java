package com.websitenhaccu.api;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.websitenhaccu.converter.NguoiDungConverter;
import com.websitenhaccu.dto.NguoiDungDTO;
import com.websitenhaccu.entity.HoaDon;
import com.websitenhaccu.entity.NguoiDung;
import com.websitenhaccu.service.HoaDonService;
import com.websitenhaccu.service.NguoiDungService;

@RestController
@RequestMapping("/register/api/email")
public class NguoiDungRestController {

	@Autowired
	private NguoiDungService nguoiDungService;
	@Autowired
	private HoaDonService hoaDonService;
	
	@Autowired
	private NguoiDungConverter nguoiDungConverter;

	@GetMapping
	public int getEmailExist(@RequestParam("email") String email) {
		NguoiDungDTO userDTO = nguoiDungService.getByEmail(email);

		return userDTO == null ? -1 : 1;
	}
	
	@GetMapping("/tim-kiem")
	public List<NguoiDungDTO> getTimKiem(@RequestParam("hoTen") String hoTen, @RequestParam("soDienThoai") String soDienThoai, @RequestParam("email") String email, @RequestParam(value = "page", defaultValue = "0") int page) {
		List<NguoiDung> nguoiDungs = nguoiDungService.timKiemNguoiDung(hoTen, soDienThoai, email, page, 10);
		List<NguoiDungDTO> nguoiDungDTOs = new ArrayList<NguoiDungDTO>();
		nguoiDungs.forEach(ng ->{
			NguoiDungDTO nguoiDungDTO = nguoiDungConverter.toNguoiDungDTO(ng);
			nguoiDungDTOs.add(nguoiDungDTO);
		});
		return nguoiDungDTOs;
	}
	
	@DeleteMapping("/xoa")
	private int xoaNguoiDung(@RequestParam("id") String id) {
		
		List<HoaDon> hoaDons = hoaDonService.getHoaDonTheoNguoiDung(id);
		if(hoaDons.size() > 0)
			return -1;
		nguoiDungService.XoaNguoiDung(id);
		return 1;
	}
	
	@GetMapping("/doi-mat-khau")
	public HttpStatus doiMatKhau(HttpServletRequest request,
			@RequestParam(value = "email", required = true) String email) {

		String baseUrl = "http://" + request.getHeader("host");
		nguoiDungService.sendEmailForgotPassword(email, baseUrl);
		
		return HttpStatus.OK;
	}
}
