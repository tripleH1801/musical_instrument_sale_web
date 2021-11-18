package com.websitenhaccu.api;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.websitenhaccu.converter.BinhLuanConverter;
import com.websitenhaccu.converter.ChiTietHoaDonConverter;
import com.websitenhaccu.converter.HoaDonConverter;
import com.websitenhaccu.dto.BinhLuanDTO;
import com.websitenhaccu.dto.ChiTietHoaDonDTO;
import com.websitenhaccu.dto.HoaDonDTO;
import com.websitenhaccu.entity.BinhLuan;
import com.websitenhaccu.entity.ChiTietHoaDon;
import com.websitenhaccu.entity.HoaDon;
import com.websitenhaccu.entity.MauSanPham;
import com.websitenhaccu.service.BinhLuanService;
import com.websitenhaccu.service.ChiTietHoaDonService;
import com.websitenhaccu.service.HoaDonService;
import com.websitenhaccu.service.MauSanPhamService;
import com.websitenhaccu.util.Constant;

@RestController
@RequestMapping("/api/hoa-don")
public class HoaDonRestController {

	@Autowired
	private HoaDonService hoaDonService;

	@Autowired
	private HoaDonConverter hoaDonConverter;

	@Autowired
	private ChiTietHoaDonService chiTietHoaDonService;
	@Autowired
	private MauSanPhamService mauSanPhamService;

	@Autowired
	private ChiTietHoaDonConverter chiTietHoaDonConverter;

	@Autowired
	private BinhLuanService binhLuanService;

	@Autowired
	private BinhLuanConverter binhLuanConverter;

	@GetMapping("/cap-nhat-trang-thai")
	public int capNhatTrangThai(@RequestParam("maDonHang") String maDonHang,
			@RequestParam("trangThai") int trangThai) {
		
		HoaDon hoaDonOld = hoaDonService.getHoaDonTheoId(maDonHang);
		String trangThaiOld = hoaDonOld.getTrangThai();
		List<ChiTietHoaDon> chiTietHoaDons = chiTietHoaDonService.getChiTietHoaDonTheoMaHoaDon(maDonHang);
		
		if(trangThaiOld.equals(Constant.DA_HUY) && trangThai == 6)
		{
			return 1;
		}
		else if(!trangThaiOld.equals(Constant.DA_HUY) && trangThai == 6) {
			
			chiTietHoaDons.forEach(cthd->{
				 int soluong = cthd.getSoLuong() + cthd.getMauSanPham().getSoLuong();
				 MauSanPham mauSanPham = cthd.getMauSanPham();
				 mauSanPham.setSoLuong(soluong);
				 mauSanPhamService.capNhatMauSanPham(mauSanPham);
			});
		}
		else if(trangThaiOld.equals(Constant.DA_HUY) && trangThai != 6) {
			for (ChiTietHoaDon chiTietHoaDon : chiTietHoaDons) {
				if(chiTietHoaDon.getSoLuong() > chiTietHoaDon.getMauSanPham().getSoLuong())
					return -1;
			}
			chiTietHoaDons.forEach(cthd->{
				 int soluong = cthd.getMauSanPham().getSoLuong() - cthd.getSoLuong();
				 MauSanPham mauSanPham = cthd.getMauSanPham();
				 mauSanPham.setSoLuong(soluong);
				 mauSanPhamService.capNhatMauSanPham(mauSanPham);
			});
		}
		
		hoaDonService.capNhatHoaDon(maDonHang, trangThai);
		
		return 1;
		
	}

	@GetMapping("/danh-sach-don-hang")
	public List<HoaDonDTO> DanhSachHoaDon(@RequestParam(value = "date", required = false) String date,
			@RequestParam("trangThai") String trangThai, @RequestParam("page") int page) {

		List<HoaDon> hoaDons = null;
		if (date != "" && date != null)
			hoaDons = hoaDonService.getDanhSachTheoNgayTrangThai(date, trangThai, page, 5);
		else
			hoaDons = hoaDonService.getDanhSachTheoTrangThai(trangThai, page, 5);

		List<HoaDonDTO> hoaDonDTOs = new ArrayList<HoaDonDTO>();
		hoaDons.forEach(hd -> {
			HoaDonDTO hoaDonDTO = hoaDonConverter.toHoaDonDTO(hd);
			List<ChiTietHoaDonDTO> chiTietHoaDonDTOs = new ArrayList<ChiTietHoaDonDTO>();
			List<ChiTietHoaDon> chiTietHoaDons = chiTietHoaDonService.getChiTietHoaDonTheoMaHoaDon(hoaDonDTO.getId());

			chiTietHoaDons.forEach(cthd -> {
				ChiTietHoaDonDTO chiTietHoaDonDTO = chiTietHoaDonConverter.toChiTietHoaDonDTO(cthd);
				chiTietHoaDonDTOs.add(chiTietHoaDonDTO);
			});
			hoaDonDTO.setChiTietHoaDonDTOs(chiTietHoaDonDTOs);

			hoaDonDTOs.add(hoaDonDTO);
		});

		return hoaDonDTOs;

	}

	@GetMapping
	public HoaDonDTO getHoaDonById(@RequestParam("id") String id) {
		HoaDon hoaDon = hoaDonService.getHoaDonTheoId(id);
		HoaDonDTO hoaDonDTO = hoaDonConverter.toHoaDonDTO(hoaDon);
		return hoaDonDTO;
	}

	@PostMapping("/danh-gia")
	public HttpStatus danhGiaSanPham(@RequestBody BinhLuanDTO binhLuanDTO) {
		Date temp = new Date(System.currentTimeMillis());
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date ngayHienTai = Date.valueOf(format.format(temp));

		binhLuanDTO.setNgayBinhLuan(ngayHienTai);
		BinhLuan binhLuan = binhLuanConverter.toBinhLuan(binhLuanDTO);

		binhLuanService.themBinhLuan(binhLuan);

		return HttpStatus.OK;
	}

}
