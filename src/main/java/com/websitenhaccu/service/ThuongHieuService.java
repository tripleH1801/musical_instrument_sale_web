package com.websitenhaccu.service;

import java.util.List;

import com.websitenhaccu.dto.ThuongHieuDTO;
import com.websitenhaccu.entity.ThuongHieu;

public interface ThuongHieuService {
	public List<ThuongHieu> getTatCaThuongHieu();

	public List<ThuongHieuDTO> getTatCaThuongHieuDTO();

	public ThuongHieu getThuonghieuBangTenThuonghieu(String tenThuongHieu);

	public ThuongHieu getThuonghieuBangMa(String maThuongHieu);

	public void ThemThuonghieu(ThuongHieu thuongHieu);

	public boolean XoaThuonghieu(String maThuongHieu);

	public void CapnhatThuonghieu(ThuongHieu thuongieu);

	public List<ThuongHieu> getDanhSachThuongHieuBangTenThuongHieu(String tenThuongHieu, int page, int size);
}
