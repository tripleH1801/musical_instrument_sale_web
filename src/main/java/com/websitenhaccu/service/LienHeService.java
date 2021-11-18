package com.websitenhaccu.service;

import java.util.List;

import com.websitenhaccu.entity.LienHe;

public interface LienHeService {
	public List<LienHe> getTatCaLienHe();

	public LienHe getLienHeTheoId(String id);

	public LienHe getLienHe();

	public void xoaLienHe(String id);

	public void themLienHe(LienHe lienHe);

}
