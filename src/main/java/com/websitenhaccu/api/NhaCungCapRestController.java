package com.websitenhaccu.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.websitenhaccu.converter.NhaCungCapConverter;
import com.websitenhaccu.dto.NhaCungCapDTO;
import com.websitenhaccu.entity.MauSanPham;
import com.websitenhaccu.entity.NhaCungCap;
import com.websitenhaccu.entity.SanPham;
import com.websitenhaccu.service.NhaCungCapService;
import com.websitenhaccu.service.SanPhamService;


@RestController
@RequestMapping("/api/nha-cung-cap")
public class NhaCungCapRestController {
	
	@Autowired
	private NhaCungCapService nhaCungCapService;
	@Autowired
	private SanPhamService sanPhamService;
	
	@Autowired
	private NhaCungCapConverter nhaCungCapConverter;
	
	@GetMapping("/danh-sach")
	public List<NhaCungCapDTO> getDanhSachNhaCungCapTheoTen(@RequestParam("tenNhaCungCap") String tenNhaCungCap,
			@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "size", defaultValue = "10") int size){
		List<NhaCungCap> nhaCungCaps = nhaCungCapService.timKiemNhaCungCap(tenNhaCungCap, page, size);
		List<NhaCungCapDTO> nhaCungCapDTOs = new ArrayList<NhaCungCapDTO>();
		for(NhaCungCap ncc : nhaCungCaps) {
			NhaCungCapDTO capDTO = nhaCungCapConverter.toNhaCungCapDTO(ncc);
			nhaCungCapDTOs.add(capDTO);
		}
		return nhaCungCapDTOs;
	}
	
	@DeleteMapping("/xoa")
	public int xoaMau(@RequestParam("id") String id) {
		List<SanPham> sanPhams = sanPhamService.getDanhSachSanPhamTheoNhaCungCap(id);
		if(sanPhams.size() > 0)
			return -1;
		nhaCungCapService.xoaNhaCungCap(id);
		return 1;
	}
	
}
