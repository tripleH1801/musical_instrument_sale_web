package com.websitenhaccu.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.websitenhaccu.entity.MauSanPham;
import com.websitenhaccu.service.MauSanPhamService;
import com.websitenhaccu.service.MauService;

@RestController
@RequestMapping("/api/mau-san-pham")
public class MauSanPhamRestController {
	
	@Autowired
	private MauSanPhamService mauSanPhamService;
	@Autowired
	private MauService mauService;
	
	@GetMapping
	public int getAllMauSanPhamBySanPhamId(@RequestParam("id") String id){
		List<MauSanPham> list = mauSanPhamService.getMauSanPhamTheoMaSanPham(id);
		int total = 0;
		for(MauSanPham msp : list) {
			total += msp.getSoLuong();
		}
		return total;
	}
	
	@DeleteMapping("/xoa-mau")
	public int xoaMau(@RequestParam("id") int id) {
		List<MauSanPham> mauSanPhams = mauSanPhamService.getDanhSachTheoMaMau(id);
		if(mauSanPhams.size() > 0)
			return -1;
		mauService.xoaMau(id);
		return 1;
	}
	
}
