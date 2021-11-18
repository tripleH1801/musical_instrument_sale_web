package com.websitenhaccu.service;

import java.util.List;

import com.websitenhaccu.dto.MauSanPhamDTO;
import com.websitenhaccu.entity.Mau;
import com.websitenhaccu.entity.MauSanPham;

public interface MauSanPhamService {

	public List<MauSanPham> getMauSanPhamTheoMaSanPham(String id);

	public List<MauSanPhamDTO> getMauSanPhamDTOTheoMaSanPham(String id);

	public Mau getMauSanPhamTheoTenMau(String tenMau);

	public MauSanPham getMauSanPhamTheoMaSanPhamVaMaMau(String maSanPham, int maMau);

	public void themMauSanPham(MauSanPham mauSanPham);

	public void xoaMauSanPham(String id, int idMau);

	public void capNhatMauSanPham(MauSanPham mauSanPham);

	public List<MauSanPham> getDanhSachSoLuongIdMauTheoMaSanPham(String id);

	public List<MauSanPham> getDanhSachTheoMaMau(int id);
}
