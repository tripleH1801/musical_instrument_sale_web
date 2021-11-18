package com.websitenhaccu.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.websitenhaccu.entity.SanPham;
import com.websitenhaccu.util.Constant;

public interface SanPhamRepository extends JpaRepository<SanPham, String>, JpaSpecificationExecutor<SanPham> {

	public List<SanPham> findByTenSanPhamContainingAndDongSanPhamTenDongSanPhamAndXuatXuAndDongSanPhamThuongHieuTenThuongHieu(
			String tenSanPham, String tenDongSanPham, String xuatXu, String tenThuongHieu);

	public SanPham findByTenSanPhamAndDongSanPhamTenDongSanPhamAndXuatXuAndDongSanPhamThuongHieuTenThuongHieu(
			String tenSanPham, String tenDongSanPham, String xuatXu, String tenThuongHieu);

	public List<SanPham> findByTenSanPhamContainingAndXuatXuContainingAndDongSanPhamThuongHieuIdContainingAndDongSanPhamLoaiSanPhamIdContaining(
			String tenSanPham, String xuatXu, String idThuongHieu, String idLoaiSanPham, Pageable pageable);
//			String tenSanPham, String xuatXu, String idThuongHieu, String idLoaiSanPham);

	public List<SanPham> findByDongSanPhamLoaiSanPhamIdOrDongSanPhamIdOrDongSanPhamThuongHieuId(String maLoai,
			String maDong, String maThuongHieu, Pageable pageable);

	public List<SanPham> findByDongSanPhamLoaiSanPhamIdAndDongSanPhamThuongHieuId(String maLoai, String maThuongHieu,
			Pageable pageable);

	public List<SanPham> findByNhaCungCapMaNhaCungCap(String id);

	@Query(value = Constant.QUERY_DANH_SACH_XUAT_XU, nativeQuery = true)
	public Set<String> getDanhSachXuatXu();

//	@Query(value = Constant.QUERY_DANH_SACH_SAN_PHAM_BAN_CHAY, nativeQuery = true)
//	public List<SanPham> getDanhSachSanPhamBanChay(Pageable pageable);
	@Query(value = Constant.QUERY_DANH_SACH_SAN_PHAM_BAN_CHAY, nativeQuery = true)
	public List<String> getDanhSachSanPhamBanChay(Pageable pageable);
}
