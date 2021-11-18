package com.websitenhaccu.converter;

import java.sql.Blob;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Base64;
import java.util.Optional;

import javax.sql.rowset.serial.SerialBlob;

import org.springframework.stereotype.Component;

import com.websitenhaccu.dto.QuangCaoDTO;
import com.websitenhaccu.entity.QuangCao;

@Component
public class QuangCaoConverter {

	public QuangCao toQuangCao(QuangCaoDTO quangCaoDTO, byte[] bytes) {

		if (quangCaoDTO == null)
			return null;

		int id = quangCaoDTO.getId();
		Date ngayThem = quangCaoDTO.getNgayThem();
		String link = quangCaoDTO.getLink();

		Blob hinhAnh = null;
		try {
			hinhAnh = new SerialBlob(bytes);
		} catch (Exception e) {
			e.printStackTrace();
		}

		QuangCao quangCao = new QuangCao(id, hinhAnh, ngayThem, link);

		return quangCao;
	}

	public QuangCaoDTO toQuangCaoDTO(QuangCao quangCao) {

		if (quangCao == null)
			return null;

		int id = quangCao.getId();
		Date ngayThem = quangCao.getNgayThem();
		String link = quangCao.getLink();

		Blob blob = quangCao.getHinhAnh();
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

		QuangCaoDTO quangCaoDTO = new QuangCaoDTO(id, ngayThem, link, hinhAnhBase64);
		return quangCaoDTO;
	}
}
