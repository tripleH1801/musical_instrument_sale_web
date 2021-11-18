package com.websitenhaccu.service;

import java.util.List;

import com.websitenhaccu.entity.Mau;

public interface MauService {
	public List<Mau> getTatCamau();

	public Mau getMauTheoTenMau(String tenMau);
	
	public Mau getMauTheoId(int id);

	public void themMau(Mau mau);

	public void xoaMau(int id);

	public void capNhatMau(Mau mau);
}
