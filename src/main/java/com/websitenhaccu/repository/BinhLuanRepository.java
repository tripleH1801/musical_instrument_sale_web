package com.websitenhaccu.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.websitenhaccu.entity.BinhLuan;
import com.websitenhaccu.entity.BinhLuan_PK;

public interface BinhLuanRepository extends JpaRepository<BinhLuan, BinhLuan_PK> {

	public List<BinhLuan> findBySanPhamId(String id, Sort sort);
	
}
