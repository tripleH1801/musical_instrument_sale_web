package com.websitenhaccu.converter;

import java.sql.Blob;
import java.sql.SQLException;
import java.util.Base64;
import java.util.List;

import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

import org.springframework.stereotype.Component;

import com.websitenhaccu.dto.ThuongHieuDTO;
import com.websitenhaccu.entity.DongSanPham;
import com.websitenhaccu.entity.ThuongHieu;

@Component
public class ThuongHieuConverter {
	/**
	 * 
	 * @param thuongHieuDTO khong co truyen biến String base 64
	 * @param inputStream
	 * @return
	 */
	public ThuongHieu toThuongHieu(ThuongHieuDTO thuongHieuDTO, byte[] bytes) {
		if(thuongHieuDTO == null)
			return null;
		
		ThuongHieu thuongHieu = new ThuongHieu();
		
		String id = thuongHieuDTO.getId();
		String tenThuongHieu = thuongHieuDTO.getTenThuongHieu();
		List<DongSanPham> dongSanPhams = thuongHieuDTO.getDongSanPhams();
			try {
				
	            Blob blob = new SerialBlob(bytes);
	            thuongHieu.setHinhAnh(blob);
			} catch (SerialException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		thuongHieu.setDongSanPhams(dongSanPhams);
		thuongHieu.setId(id);
		thuongHieu.setTenThuongHieu(tenThuongHieu);
		
		return thuongHieu;
	}
	
	public ThuongHieuDTO toThuongHieuDTO(ThuongHieu thuongHieu) {
		
		if(thuongHieu == null) {
			return null;
		}
		
		ThuongHieuDTO thuongHieuDTO = new ThuongHieuDTO();
		thuongHieuDTO.setId(thuongHieu.getId());
		thuongHieuDTO.setTenThuongHieu(thuongHieu.getTenThuongHieu());
		thuongHieuDTO.setDongSanPhams(thuongHieu.getDongSanPhams());
		
		Blob blob = thuongHieu.getHinhAnh();
		try {
			if (blob != null) {
				int blobLength = (int) blob.length();
				byte[] imageBytes = blob.getBytes(1, blobLength);
	            String base64Image = Base64.getEncoder().encodeToString(imageBytes);
	            thuongHieuDTO.setHinhAnhBase64(base64Image);
	        }
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return thuongHieuDTO;
	}
}
