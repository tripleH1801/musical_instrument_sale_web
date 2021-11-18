package com.websitenhaccu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.websitenhaccu.entity.QuangCao;

public interface QuangCaoRepository extends JpaRepository<QuangCao, Integer> {
	
	@Query(value = "SELECT TOP(6) * FROM QuangCaos ORDER BY ngay_them DESC", nativeQuery = true)
	public List<QuangCao> findTop6QuangCao();
	
	@Query(value = "SELECT * FROM QuangCaos ORDER BY ngay_them DESC", nativeQuery = true)
	public List<QuangCao> findAllOrderByNgayThemDesc();

}
