package com.websitenhaccu.controller.admin;

import java.io.IOException;
import java.sql.Blob;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.websitenhaccu.converter.QuangCaoConverter;
import com.websitenhaccu.dto.QuangCaoDTO;
import com.websitenhaccu.entity.QuangCao;
import com.websitenhaccu.service.QuangCaoService;
import com.websitenhaccu.validator.QuangCaoValidator;

@Controller
@RequestMapping("/admin/quang-cao")
public class QuangCaoController {
	@Autowired
	private QuangCaoService quangCaoService;

	@Autowired
	private QuangCaoConverter quangCaoConverter;
	
	@Autowired
	private QuangCaoValidator quangCaoValidator;

	@GetMapping()
	public ModelAndView getTatCaQuangCao() {
		List<QuangCaoDTO> quangCaoDTOs = quangCaoService.getTatCaQuangCao();
		return new ModelAndView("admin/quangcao/QuangCao", "quangCaoDTOs", quangCaoDTOs);
	}

	@GetMapping("/chi-tiet-quang-cao")
	public ModelAndView getChitietQuangCao(int id) {

		QuangCaoDTO quangCaoDTO = quangCaoService.getQuangCaoDTOTheoId(id);

		return new ModelAndView("admin/quangcao/ChiTietQuangCao", "quangCaoDTO", quangCaoDTO);
	}

	@GetMapping("/them-quang-cao")
	public String themQuangCao(Model model) {

		QuangCaoDTO quangCaoDTO = new QuangCaoDTO();
		model.addAttribute("quangCaoDTO", quangCaoDTO);
		model.addAttribute("formTitle", "Thêm quảng cáo");
		model.addAttribute("formButton", "Thêm");

		return "admin/quangcao/QuangCaoForm";
	}

	@PostMapping("/them-quang-cao")
	public String themQuangCao(@ModelAttribute("quangCaoDTO") QuangCaoDTO quangCaoDTO,
			@RequestParam("hinhAnh") MultipartFile multipartFile, BindingResult bindingResult, Model model) throws IOException {
		
		byte[] bytes = multipartFile.getBytes();
		if(bytes.length > 0)
			quangCaoDTO.setHinhAnhBase64("da co hinh anh");
		QuangCao quangCao = quangCaoConverter.toQuangCao(quangCaoDTO, bytes);
		
		Date temp = new Date(System.currentTimeMillis());
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date ngayHienTai = Date.valueOf(format.format(temp));
		quangCao.setNgayThem(ngayHienTai);
		
		quangCaoValidator.validate(quangCaoDTO, bindingResult);
		if (bindingResult.hasErrors()) {
			model.addAttribute("quangCaoDTO", quangCaoDTO);
			model.addAttribute("formTitle", "Thêm quảng cáo");
			model.addAttribute("formButton", "Thêm");
			return "admin/quangcao/QuangCaoForm";
		}
		
		quangCaoService.themQuangCao(quangCao);

		return "redirect:/admin/quang-cao";
	}

	
	@GetMapping(value = "/xoa-quang-cao")
	public String xoaQuangCao(@RequestParam("id") int id) {

		quangCaoService.xoaQuangCao(id);

		return "redirect:/admin/quang-cao";
	}

	@GetMapping("/cap-nhat-quang-cao")
	public String capNhatQuangCao(@RequestParam("id") int id, Model model) {
		
		QuangCaoDTO quangCaoDTO = quangCaoService.getQuangCaoDTOTheoId(id);
		model.addAttribute("quangCaoDTO", quangCaoDTO);
		model.addAttribute("formTitle", "Cập nhật quảng cáo");
		model.addAttribute("formButton", "Lưu");

		return "admin/quangcao/QuangCaoForm";
	}

	@PostMapping("/cap-nhat-quang-cao")
	public String capNhatQuangCao(@ModelAttribute("quangCaoDTO") QuangCaoDTO quangCaoDTO,
			@RequestParam("hinhAnh") MultipartFile multipartFile) throws IOException, SQLException {

		byte[] bytes = null;
		if (multipartFile.getSize() > 0) {
			bytes = multipartFile.getBytes();
		} else {
			QuangCao temp = quangCaoService.getQuangCaoTheoId(quangCaoDTO.getId());
			if (temp != null) {
				Blob blob = temp.getHinhAnh();
				int blobLength = (int) blob.length();
				bytes = blob.getBytes(1, blobLength);
			}
		}
		QuangCao quangCao = quangCaoConverter.toQuangCao(quangCaoDTO, bytes);
		
		Date temp = new Date(System.currentTimeMillis());
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date ngayHienTai = Date.valueOf(format.format(temp));
		quangCao.setNgayThem(ngayHienTai);
		
		quangCaoService.capNhatQuangCao(quangCao);
		return "redirect:/admin/quang-cao";
	}

}
