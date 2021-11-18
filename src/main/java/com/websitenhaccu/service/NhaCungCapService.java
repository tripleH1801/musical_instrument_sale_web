package com.websitenhaccu.service;

import java.util.List;

import com.websitenhaccu.entity.NhaCungCap;

public interface NhaCungCapService {
	public List<NhaCungCap> getTatCaNhaCungCap();

	public NhaCungCap getNhaCungCapTheoMaNCC(String id);
	
	public void xoaNhaCungCap(String id);
	
	public void themNhaCungCap(NhaCungCap nhaCungCap);
	
	public List<NhaCungCap> timKiemNhaCungCap(String tenNhaCungCap, int page, int size);
	
}
