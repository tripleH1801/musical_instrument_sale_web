package com.websitenhaccu.service;

import java.util.List;

import com.websitenhaccu.dto.QuangCaoDTO;
import com.websitenhaccu.entity.QuangCao;

public interface QuangCaoService {

	public List<QuangCaoDTO> get6QuangCao();

	public List<QuangCaoDTO> getTatCaQuangCao();

	public QuangCaoDTO getQuangCaoDTOTheoId(int id);

	public QuangCao getQuangCaoTheoId(int id);

	public void themQuangCao(QuangCao quangCao);

	public void xoaQuangCao(int id);

	public void capNhatQuangCao(QuangCao quangCao);

}
