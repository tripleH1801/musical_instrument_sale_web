package com.websitenhaccu.controller.admin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.websitenhaccu.converter.ChiTietHoaDonConverter;
import com.websitenhaccu.converter.HoaDonConverter;
import com.websitenhaccu.dto.ChiTietHoaDonDTO;
import com.websitenhaccu.dto.HoaDonDTO;
import com.websitenhaccu.entity.ChiTietHoaDon;
import com.websitenhaccu.entity.HoaDon;
import com.websitenhaccu.service.ChiTietHoaDonService;
import com.websitenhaccu.service.HoaDonService;
import com.websitenhaccu.service.NguoiDungService;
import com.websitenhaccu.util.Constant;

@Controller
@RequestMapping("/admin")
public class QuanLyController {
	@Autowired
	private HoaDonService hoaDonService;

	@Autowired
	NguoiDungService userService;

	@Autowired
	private ChiTietHoaDonService chiTietHoaDonService;

	@Autowired
	private HoaDonConverter hoaDonConverter;

	@Autowired
	private ChiTietHoaDonConverter chiTietHoaDonConverter;


	@RequestMapping("/quan-ly")
	public String getUser(Model model) {

		List<HoaDon> hoaDons = hoaDonService.getDanhSachTheoTrangThai("", 0, 5);

		List<HoaDonDTO> hoaDonDTOs = new ArrayList<HoaDonDTO>();
		hoaDons.forEach(hd -> {
			HoaDonDTO hoaDonDTO = hoaDonConverter.toHoaDonDTO(hd);
			List<ChiTietHoaDonDTO> chiTietHoaDonDTOs = new ArrayList<ChiTietHoaDonDTO>();
			List<ChiTietHoaDon> chiTietHoaDons = chiTietHoaDonService.getChiTietHoaDonTheoMaHoaDon(hoaDonDTO.getId());

			chiTietHoaDons.forEach(cthd -> {
				ChiTietHoaDonDTO chiTietHoaDonDTO = chiTietHoaDonConverter.toChiTietHoaDonDTO(cthd);
				chiTietHoaDonDTOs.add(chiTietHoaDonDTO);
			});
			hoaDonDTO.setChiTietHoaDonDTOs(chiTietHoaDonDTOs);

			hoaDonDTOs.add(hoaDonDTO);
		});

		List<String> trangThais = new ArrayList<String>(Arrays.asList(Constant.DANG_CHO_XU_LY, Constant.DA_TIEP_NHAN,
				Constant.DANG_DONG_GOI, Constant.BAN_GIAO_VAN_CHUYEN, Constant.GIAO_THANH_CONG, Constant.DA_HUY));
		model.addAttribute("trangThais", trangThais);
		model.addAttribute("hoaDonDTOs", hoaDonDTOs);
		model.addAttribute("page", 0);

		return "admin/quanlydonhang/danhsachdonhang";

	}
}
