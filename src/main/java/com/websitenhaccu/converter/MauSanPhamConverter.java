package com.websitenhaccu.converter;

import java.sql.Blob;
import java.sql.SQLException;
import java.util.Base64;
import java.util.Optional;

import javax.sql.rowset.serial.SerialBlob;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.websitenhaccu.dto.MauSanPhamDTO;
import com.websitenhaccu.entity.Mau;
import com.websitenhaccu.entity.MauSanPham;
import com.websitenhaccu.entity.SanPham;
import com.websitenhaccu.service.MauService;
import com.websitenhaccu.service.SanPhamService;

@Component
public class MauSanPhamConverter {

	@Autowired
	private MauService mauService;

	@Autowired
	private SanPhamService sanPhamService;

	public MauSanPham toMauSanPham(MauSanPhamDTO mauSanPhamDTO, byte[] bytes) {

		if (mauSanPhamDTO == null)
			return null;

		int maMau = mauSanPhamDTO.getMaMau();
		Mau mau = mauService.getMauTheoId(maMau);

		String maSanPham = mauSanPhamDTO.getMaSanPham();
		SanPham sanPham = null;

		Optional<String> optional = Optional.ofNullable(maSanPham);

		if (optional.isPresent()) {
			sanPham = sanPhamService.getSanPhamTheoID(maSanPham);
		}

		int soLuong = mauSanPhamDTO.getSoLuong();

//		String hinhAnhBase64 = mauSanPhamDTO.getHinhAnhBase64();
//		byte[] bytes = null;
		Blob hinhAnh = null;
		try {
//			bytes = hinhAnhBase64.getBytes();
//			bytes = hinhAnhBase64.getBytes("UTF-8");
			hinhAnh = new SerialBlob(bytes);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		MauSanPham mauSanPham = new MauSanPham(mau, sanPham, soLuong, hinhAnh);

		return mauSanPham;
	}

	public MauSanPhamDTO toMauSanPhamDTO(MauSanPham mauSanPham) {

		if (mauSanPham == null)
			return null;

		int maMau = mauSanPham.getMau().getId();
		String tenMau = mauSanPham.getMau().getTenMau();
		String maSanPham = mauSanPham.getSanPham().getId();
		int soLuong = mauSanPham.getSoLuong();

		Blob blob = mauSanPham.getHinhAnh();
		int blobLength;
		byte[] bytes = null;
		String hinhAnhBase64 = "";
		Optional<Blob> optional = Optional.ofNullable(blob);
		try {
			if (optional.isPresent()) {
				blobLength = (int) blob.length();
				bytes = blob.getBytes(1, blobLength);
				hinhAnhBase64 = Base64.getEncoder().encodeToString(bytes);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		String tenSanPham = mauSanPham.getSanPham().getTenSanPham();
		MauSanPhamDTO mauSanPhamDTO = new MauSanPhamDTO(maMau, tenMau, maSanPham, tenSanPham, soLuong, hinhAnhBase64);
		return mauSanPhamDTO;
	}
}
