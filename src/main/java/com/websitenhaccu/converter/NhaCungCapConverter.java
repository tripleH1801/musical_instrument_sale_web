package com.websitenhaccu.converter;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.websitenhaccu.dto.NhaCungCapDTO;
import com.websitenhaccu.entity.NhaCungCap;
import com.websitenhaccu.util.Constant;

@Component
public class NhaCungCapConverter {

	public NhaCungCap toNhaCungCap(NhaCungCapDTO nhaCungCapDTO) {

		if (nhaCungCapDTO == null)
			return null;

		String id = nhaCungCapDTO.getMaNhaCungCap();
		String tenNhaCungCap = nhaCungCapDTO.getTenNhaCungCap();

		String soDienThoai = nhaCungCapDTO.getSoDienThoai();

		String email = nhaCungCapDTO.getEmail();
		String website = nhaCungCapDTO.getWebsite();

		String diaChiDTO = nhaCungCapDTO.getDiaChi();
		String phuongXa = nhaCungCapDTO.getPhuongXa();
		String quanHuyen = nhaCungCapDTO.getQuanHuyen();
		String tinhThanh = nhaCungCapDTO.getTinhThanhPho();

		String diaChi = "";

		StringBuffer buffer = new StringBuffer(diaChiDTO);

//		Kiểm tra và lưu vào biến diaChi theo thứ tự cấp hành chính  <Số nhà, tên đường>, <Phường/ Xã/ Thị trấn>, <Quận/ Thị xã/ Huyện>, <Thành phố/ Tỉnh>
		if (phuongXa.contains(Constant.PHUONG) || phuongXa.contains(Constant.XA) || phuongXa.contains(Constant.THITRAN)) {
			buffer.append(", " + phuongXa);
		}
		if (quanHuyen.contains(Constant.QUAN) || quanHuyen.contains(Constant.HUYEN) || quanHuyen.contains(Constant.THIXA)) {
			buffer.append(", " + quanHuyen);
		}
		if (tinhThanh.contains(Constant.TINH) || tinhThanh.contains(Constant.THANHPHO)) {
			buffer.append(", " + tinhThanh);
		}

		String temp = buffer.toString();
		Optional<String> tempOptional = Optional.ofNullable(temp);

//		Kiểm tra xem địa chỉ có null không
		if (tempOptional.isPresent()) {
//			Xóa các kí tự "," dư ở đầu chuỗi
			while (temp.startsWith(", ")) {
				temp = temp.substring(2, temp.length());
			}
		}

		diaChi = temp;

		NhaCungCap nhaCungCap = new NhaCungCap(id, tenNhaCungCap, diaChi, soDienThoai, email, website);
		return nhaCungCap;
	}

//	public NhaCungCap toThemNhaCungCap(NhaCungCapDTO nhaCungCapDTO) {
//
//		if (nhaCungCapDTO == null)
//			return null;
//
//		String tenNhaCungCap = nhaCungCapDTO.getTenNhaCungCap();
//
//		String soDienThoai = nhaCungCapDTO.getSoDienThoai();
//
//		String email = nhaCungCapDTO.getEmail();
//		String website = nhaCungCapDTO.getWebsite();
//
//		String diaChiDTO = nhaCungCapDTO.getDiaChi();
//		String phuongXa = nhaCungCapDTO.getPhuongXa();
//		String quanHuyen = nhaCungCapDTO.getQuanHuyen();
//		String tinhThanh = nhaCungCapDTO.getTinhThanhPho();
//
//		String diaChi = "";
//
//		StringBuffer buffer = new StringBuffer(diaChiDTO);
//
////		Kiểm tra và lưu vào biến diaChi theo thứ tự cấp hành chính  <Số nhà, tên đường>, <Phường/ Xã/ Thị trấn>, <Quận/ Thị xã/ Huyện>, <Thành phố/ Tỉnh>
//		if (phuongXa.contains(DiaChiConstant.PHUONG) || phuongXa.contains(DiaChiConstant.XA) || phuongXa.contains(DiaChiConstant.THITRAN)) {
//			buffer.append(", " + phuongXa);
//		}
//		if (quanHuyen.contains(DiaChiConstant.QUAN) || quanHuyen.contains(DiaChiConstant.HUYEN) || quanHuyen.contains(DiaChiConstant.THIXA)) {
//			buffer.append(", " + quanHuyen);
//		}
//		if (tinhThanh.contains(DiaChiConstant.TINH) || tinhThanh.contains(DiaChiConstant.THANHPHO)) {
//			buffer.append(", " + tinhThanh);
//		}
//
//		String temp = buffer.toString();
//		Optional<String> tempOptional = Optional.ofNullable(temp);
//
////		Kiểm tra xem địa chỉ có null không
//		if (tempOptional.isPresent()) {
////			Xóa các kí tự "," dư ở đầu chuỗi
//			while (temp.startsWith(", ")) {
//				temp = temp.substring(2, temp.length());
//			}
//		}
//
//		diaChi = temp;
//
//		NhaCungCap nhaCungCap = new NhaCungCap(tenNhaCungCap, diaChi, soDienThoai, email, website);
//		return nhaCungCap;
//	}

	public NhaCungCapDTO toNhaCungCapDTO(NhaCungCap nhaCungCap) {

		if (nhaCungCap == null)
			return null;

		String id = nhaCungCap.getMaNhaCungCap();
		String tenNhaCungCap = nhaCungCap.getTenNhaCungCap();
		String soDienThoai = nhaCungCap.getSoDienThoai();
		String email = nhaCungCap.getEmail();
		String website = nhaCungCap.getWebsite();

		String tinhThanhPho = "";
		String quanHuyen = "";
		String phuongXa = "";
		String diaChi = "";

//		Kiểm tra xem có địa chỉ nhà cung cấp không
		if (nhaCungCap.getDiaChi() != null || nhaCungCap.getDiaChi() != "") {
			String diaChiNCC = nhaCungCap.getDiaChi();
			String[] temp = diaChiNCC.split(", ");
			StringBuffer buffer = new StringBuffer();
			
//			Kiểm tra xem địa chỉ có 1, hay nhiều thông tin
			if (temp.length > 1) {
//				Lưu thông tin địa chỉ theo cấp hành chính
				for (String string : temp) {
					if (string.contains(Constant.TINH) || string.contains(Constant.THANHPHO)) {
						tinhThanhPho = string;
					} else if (string.contains(Constant.QUAN) || string.contains(Constant.HUYEN) || string.contains(Constant.THIXA)) {
						quanHuyen = string;
					} else if (string.contains(Constant.PHUONG) || string.contains(Constant.XA) || string.contains(Constant.THITRAN)) {
						phuongXa = string;
					} else {
						buffer.append(string + ", ");
					}
				}
				String tmp = buffer.toString();

//				Kiểm tra xem có thông tin số nhà, tên đường không
				if (!tmp.equals("")) {
//					Xóa kí tự "," dư ở cuối chuỗi
					diaChi = tmp.substring(0, tmp.length() - 2);
				}

			} else {

				if (diaChiNCC.contains(Constant.TINH) || diaChiNCC.contains(Constant.THANHPHO)) {
					tinhThanhPho = diaChiNCC;
				} else if (diaChiNCC.contains(Constant.QUAN) || diaChiNCC.contains(Constant.HUYEN) || diaChiNCC.contains(Constant.THIXA)) {
					quanHuyen = diaChiNCC;
				} else if (diaChiNCC.contains(Constant.PHUONG) || diaChiNCC.contains(Constant.XA) || diaChiNCC.contains(Constant.THITRAN)) {
					phuongXa = diaChiNCC;
				} else {
					diaChi = diaChiNCC;
				}

			}
		}

		NhaCungCapDTO nhaCungCapDTO = new NhaCungCapDTO(id, tenNhaCungCap, soDienThoai, email, website, tinhThanhPho,
				quanHuyen, phuongXa, diaChi);

		return nhaCungCapDTO;
	}
}
