package com.websitenhaccu.util;

public class Constant {
	public static final String PHUONG = "Phường";
	public static final String XA = "Xã";
	public static final String THITRAN = "Thị trấn";
	public static final String QUAN = "Quận";
	public static final String HUYEN = "Huyện";
	public static final String THIXA = "Thị xã";
	public static final String TINH = "Tỉnh";
	public static final String THANHPHO = "Thành phố";

	public static final String DANG_CHO_XU_LY = "Đang chờ xử lý";
	public static final String DA_TIEP_NHAN = "Đã tiếp nhận đơn hàng";
	public static final String DANG_DONG_GOI = "Đang lấy hàng và đóng gói";
	public static final String BAN_GIAO_VAN_CHUYEN = "Đã giao cho đơn vị vận chuyển";
	public static final String GIAO_THANH_CONG = "Giao hàng thành công";
	public static final String DA_HUY = "Đã hủy";

	public static final String QUERY_DANH_SACH_XUAT_XU = "SELECT DISTINCT xuat_xu FROM SanPhams";
//	public static final String QUERY_DANH_SACH_SAN_PHAM_BAN_CHAY = "SELECT TOP(15) * FROM SanPhams WHERE san_pham_id IN ( SELECT san_pham_id FROM (SELECT san_pham_id, COUNT(*) AS numberProduct FROM ChiTietHoaDons GROUP BY san_pham_id) AS newTable WHERE numberProduct > 0 );";
//	public static final String QUERY_DANH_SACH_SAN_PHAM_BAN_CHAY = "SELECT * FROM SanPhams WHERE san_pham_id IN (SELECT san_pham_id FROM ChiTietHoaDons GROUP BY san_pham_id);";
	public static final String QUERY_DANH_SACH_SAN_PHAM_BAN_CHAY = "SELECT san_pham_id FROM ChiTietHoaDons GROUP BY san_pham_id ORDER BY SUM(so_luong) DESC";

}
