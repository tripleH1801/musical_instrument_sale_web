package com.websitenhaccu.converter;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.websitenhaccu.dto.NguoiDungDTO;
import com.websitenhaccu.entity.NguoiDung;
import com.websitenhaccu.entity.ROLE;
import com.websitenhaccu.service.NguoiDungService;
import com.websitenhaccu.util.Constant;

@Component
public class NguoiDungConverter {
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	NguoiDungService nguoiDungService;

	public NguoiDung toNguoiDung(NguoiDungDTO NguoiDungDTO, NguoiDung userOld) {

		if (NguoiDungDTO == null)
			return null;

		String id = NguoiDungDTO.getUserId();
		String email = NguoiDungDTO.getEmail();
		String fullName = NguoiDungDTO.getFullName();
		String phone = NguoiDungDTO.getPhone();

		ROLE role = NguoiDungDTO.getRole() == null ? userOld.getRole() : NguoiDungDTO.getRole();
		String password = passwordEncoder.encode(NguoiDungDTO.getPassword());
		boolean enabled = NguoiDungDTO.isEnabled();
		String verifyCode = userOld.getMaXacNhan();

		String diaChiDTO = NguoiDungDTO.getDiaChi();
		String phuongXa = NguoiDungDTO.getPhuongXa();
		String quanHuyen = NguoiDungDTO.getQuanHuyen();
		String tinhThanh = NguoiDungDTO.getTinhThanhPho();

		String diaChi = "";

		StringBuffer buffer = new StringBuffer(diaChiDTO);

//		Kiểm tra và lưu vào biến diaChi theo thứ tự cấp hành chính  <Số nhà, tên đường>, <Phường/ Xã/ Thị trấn>, <Quận/ Thị xã/ Huyện>, <Thành phố/ Tỉnh>
		if (phuongXa.contains(Constant.PHUONG) || phuongXa.contains(Constant.XA)
				|| phuongXa.contains(Constant.THITRAN)) {
			buffer.append(", " + phuongXa);
		}
		if (quanHuyen.contains(Constant.QUAN) || quanHuyen.contains(Constant.HUYEN)
				|| quanHuyen.contains(Constant.THIXA)) {
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

		NguoiDung nguoiDung = new NguoiDung(id, fullName, phone, email, password, role, verifyCode, enabled);
		nguoiDung.setDiaChi(diaChi);

		return nguoiDung;
	}

	public NguoiDung toUpdateUser(NguoiDungDTO NguoiDungDTO) {

		if (NguoiDungDTO == null)
			return null;

		String id = NguoiDungDTO.getUserId();
		String email = NguoiDungDTO.getEmail();
		String fullName = NguoiDungDTO.getFullName();
		String phone = NguoiDungDTO.getPhone();

		NguoiDung userOld = nguoiDungService.getNguoiDungById(id);

		ROLE role = NguoiDungDTO.getRole() == null ? userOld.getRole() : NguoiDungDTO.getRole();
		String password = userOld.getPassword();
		boolean enabled = userOld.isTrangThai();
		String verifyCode = userOld.getMaXacNhan();

		String diaChiDTO = NguoiDungDTO.getDiaChi();
		String phuongXa = NguoiDungDTO.getPhuongXa();
		String quanHuyen = NguoiDungDTO.getQuanHuyen();
		String tinhThanh = NguoiDungDTO.getTinhThanhPho();

		String diaChi = "";

		StringBuffer buffer = new StringBuffer(diaChiDTO);

//		Kiểm tra và lưu vào biến diaChi theo thứ tự cấp hành chính  <Số nhà, tên đường>, <Phường/ Xã/ Thị trấn>, <Quận/ Thị xã/ Huyện>, <Thành phố/ Tỉnh>
		if (phuongXa.contains(Constant.PHUONG) || phuongXa.contains(Constant.XA)
				|| phuongXa.contains(Constant.THITRAN)) {
			buffer.append(", " + phuongXa);
		}
		if (quanHuyen.contains(Constant.QUAN) || quanHuyen.contains(Constant.HUYEN)
				|| quanHuyen.contains(Constant.THIXA)) {
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

		NguoiDung user = new NguoiDung(id, fullName, phone, email, password, role, verifyCode, enabled);
		user.setDiaChi(diaChi);

		return user;
	}

	public NguoiDungDTO toNguoiDungDTO(NguoiDung nguoiDung) {

		if (nguoiDung == null)
			return null;

		String id = nguoiDung.getId();
		String email = nguoiDung.getEmail();
		String fullName = nguoiDung.getHoTen();
		String phone = nguoiDung.getSoDienThoai();

		ROLE role = nguoiDung.getRole();
		boolean enabled = nguoiDung.isTrangThai();

		String tinhThanhPho = "";
		String quanHuyen = "";
		String phuongXa = "";
		String diaChi = "";

		if (nguoiDung.getDiaChi().length() > 0) {
			String diaChiNCC = nguoiDung.getDiaChi();
			String[] temp = diaChiNCC.split(", ");
			StringBuffer buffer = new StringBuffer();

//			Kiểm tra xem địa chỉ có 1, hay nhiều thông tin
			if (temp.length > 1) {
//				Lưu thông tin địa chỉ theo cấp hành chính
				for (String string : temp) {
					if (string.contains(Constant.TINH) || string.contains(Constant.THANHPHO)) {
						tinhThanhPho = string;
					} else if (string.contains(Constant.QUAN) || string.contains(Constant.HUYEN)
							|| string.contains(Constant.THIXA)) {
						quanHuyen = string;
					} else if (string.contains(Constant.PHUONG) || string.contains(Constant.XA)
							|| string.contains(Constant.THITRAN)) {
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
				} else if (diaChiNCC.contains(Constant.QUAN) || diaChiNCC.contains(Constant.HUYEN)
						|| diaChiNCC.contains(Constant.THIXA)) {
					quanHuyen = diaChiNCC;
				} else if (diaChiNCC.contains(Constant.PHUONG) || diaChiNCC.contains(Constant.XA)
						|| diaChiNCC.contains(Constant.THITRAN)) {
					phuongXa = diaChiNCC;
				} else {
					diaChi = diaChiNCC;
				}

			}
		}

		NguoiDungDTO nguoiDungDTO = new NguoiDungDTO(id, fullName, phone, email, role, enabled);
		nguoiDungDTO.setTinhThanhPho(tinhThanhPho);
		nguoiDungDTO.setQuanHuyen(quanHuyen);
		nguoiDungDTO.setPhuongXa(phuongXa);
		nguoiDungDTO.setDiaChi(diaChi);

		return nguoiDungDTO;
	}
}
