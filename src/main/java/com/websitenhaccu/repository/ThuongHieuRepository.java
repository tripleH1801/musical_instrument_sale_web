package com.websitenhaccu.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.websitenhaccu.entity.ThuongHieu;

public interface ThuongHieuRepository extends JpaRepository<ThuongHieu, String>{
	
	public List<ThuongHieu> findAll();
	
	public ThuongHieu findByTenThuongHieu(String tenThuongHieu);
	
	public List<ThuongHieu> findByTenThuongHieuContaining(String tenThuongHieu, Pageable pageable);
}
