package com.websitenhaccu.service;


import java.util.List;

import com.websitenhaccu.dto.NguoiDungDTO;
import com.websitenhaccu.entity.NguoiDung;

public interface NguoiDungService {
	public NguoiDungDTO getByEmail(String email);
	
	public NguoiDung getNguoiDungTheoEmail(String email);

	public boolean registrationVerifyUserByEmail(NguoiDungDTO userDTO, String host);
	
	public boolean verifyEmail(String email, String token);

	public NguoiDungDTO save(NguoiDungDTO userDTO);
	
	public boolean sendEmailForgotPassword(String email, String host);
	
	public boolean verifyPassword(String email, String token, String password);

	public String[] handleAddress(String diaChi);
	
	public boolean updateAddress(String userId);
	
	public List<NguoiDung> timKiemNguoiDung(String hoTen, String soDienThoai, String email, int page, int size);
	
	public boolean XoaNguoiDung(String id);
	
	public NguoiDung getNguoiDungById(String id);
	
	public void capNhatNguoiDung(NguoiDung nguoiDung);
	
}
