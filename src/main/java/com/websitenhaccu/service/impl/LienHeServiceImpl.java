package com.websitenhaccu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.websitenhaccu.entity.LienHe;
import com.websitenhaccu.repository.LienHeRepository;
import com.websitenhaccu.service.LienHeService;

@Service
public class LienHeServiceImpl implements LienHeService {

	@Autowired
	LienHeRepository lienHeRepository;

	@Override
	public List<LienHe> getTatCaLienHe() {
		List<LienHe> lienHes = lienHeRepository.findAll();
		return lienHes;
	}

	@Override
	public LienHe getLienHeTheoId(String id) {
		LienHe lienHe = lienHeRepository.findById(id).get();
		return lienHe;
	}

	@Override
	public void xoaLienHe(String id) {
		lienHeRepository.deleteById(id);

	}

	@Override
	public void themLienHe(LienHe lienHe) {
		lienHeRepository.save(lienHe);

	}

	@Override
	public LienHe getLienHe() {
		List<LienHe> lienHes = getTatCaLienHe();
		if (lienHes.size() > 0)
			return lienHes.get(0);
		else
			return null;
	}

}
