package com.websitenhaccu.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.websitenhaccu.entity.NguoiDung;
import com.websitenhaccu.entity.ROLE;

public interface NguoiDungRepository extends JpaRepository<NguoiDung, String> {
	public NguoiDung findByEmail(String email);

	public NguoiDung findByEmailAndTrangThai(String email, boolean trangThai);
	
	public List<NguoiDung> findByHoTenContainingAndSoDienThoaiContainingAndEmailContainingAndRole(String hoTen, String soDienThoai, String email, ROLE role, Pageable pageable);
	
	boolean existsByEmail(String email);
}
