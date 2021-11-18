package com.websitenhaccu.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.websitenhaccu.entity.LoaiSanPham;

public interface LoaiSanPhamRepository extends JpaRepository<LoaiSanPham, String>{
	
	public List<LoaiSanPham> findAll();
	
	public LoaiSanPham findByTenLoaiSanPham(String tenLoaiSanPham);

	public List<LoaiSanPham> findByTenLoaiSanPhamContaining(String tenLoaiSanPham, Pageable pageable);
}
