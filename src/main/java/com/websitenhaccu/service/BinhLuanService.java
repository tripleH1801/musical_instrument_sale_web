package com.websitenhaccu.service;

import java.util.List;

import com.websitenhaccu.entity.BinhLuan;

public interface BinhLuanService {
	public List<BinhLuan> getBinhLuanTheoMaSanPham(String id);

	public void themBinhLuan(BinhLuan binhLuan);

}
