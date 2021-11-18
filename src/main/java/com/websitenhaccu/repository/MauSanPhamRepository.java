package com.websitenhaccu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.websitenhaccu.entity.Mau;
import com.websitenhaccu.entity.MauSanPham;
import com.websitenhaccu.entity.MauSanPham_PK;

public interface MauSanPhamRepository extends JpaRepository<MauSanPham, MauSanPham_PK> {

	public List<MauSanPham> findBySanPhamId(String id);
	
	public List<MauSanPham> findByMauId(int id);

	public Mau findByMauTenMau(String tenMau);

	public MauSanPham findBySanPhamIdAndMauId(String maSanPham, int maMau);
	
//	@Query(value = "delete from Mau_SanPhams where san_pham_id = ?1 and mau_id = ?2", nativeQuery = true)
//	public void customXoaMauSanPhamBySanPhamId(String id, int idMau);
	
}
