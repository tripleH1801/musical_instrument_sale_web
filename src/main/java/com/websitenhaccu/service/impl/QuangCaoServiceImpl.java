package com.websitenhaccu.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.websitenhaccu.converter.QuangCaoConverter;
import com.websitenhaccu.dto.QuangCaoDTO;
import com.websitenhaccu.entity.QuangCao;
import com.websitenhaccu.repository.QuangCaoRepository;
import com.websitenhaccu.service.QuangCaoService;

@Service
public class QuangCaoServiceImpl implements QuangCaoService {

	@Autowired
	private QuangCaoRepository quangCaoRepository;
	@Autowired
	private QuangCaoConverter quangCaoConverter;

	@Override
	public List<QuangCaoDTO> get6QuangCao() {

		List<QuangCaoDTO> quangCaoDTOs = new ArrayList<QuangCaoDTO>();
		
		quangCaoRepository.findTop6QuangCao().forEach(quangCao -> {
			QuangCaoDTO quangCaoDTO = quangCaoConverter.toQuangCaoDTO(quangCao);
			quangCaoDTOs.add(quangCaoDTO);
		});
		
		return quangCaoDTOs;
	}

	@Override
	public List<QuangCaoDTO> getTatCaQuangCao() {

		List<QuangCaoDTO> quangCaoDTOs = new ArrayList<QuangCaoDTO>();

		quangCaoRepository.findAllOrderByNgayThemDesc().forEach(quangCao -> {
			QuangCaoDTO quangCaoDTO = quangCaoConverter.toQuangCaoDTO(quangCao);
			quangCaoDTOs.add(quangCaoDTO);
		});
		
		return quangCaoDTOs;
	}

	@Override
	public QuangCaoDTO getQuangCaoDTOTheoId(int id) {
		QuangCao quangCao = quangCaoRepository.findById(id).get();
		return quangCaoConverter.toQuangCaoDTO(quangCao);
	}

	@Override
	public void themQuangCao(QuangCao quangCao) {
		quangCaoRepository.save(quangCao);
	}

	@Override
	public void xoaQuangCao(int id) {
		quangCaoRepository.deleteById(id);
	}

	@Override
	public void capNhatQuangCao(QuangCao quangCao) {
		quangCaoRepository.save(quangCao);
	}


	@Override
	public QuangCao getQuangCaoTheoId(int id) {
		return quangCaoRepository.findById(id).get();
	}

}
