package com.websitenhaccu.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.websitenhaccu.util.MyGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "LienHes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LienHe {

	@Id
	@Column(name = "lien_he_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "lienHe_generator")
	@GenericGenerator(name = "lienHe_generator", strategy = "com.websitenhaccu.util.MyGenerator", parameters = {
			@Parameter(name = MyGenerator.INCREMENT_PARAM, value = "1"),
			@Parameter(name = MyGenerator.VALUE_PREFIX_PARAMETER, value = "TTLH"),
			@Parameter(name = MyGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d") })
	private String id;

	@Column(name = "dia_chi", columnDefinition = "NVARCHAR(MAX)")
	private String diaChi;

	@Column(name = "email")
	private String email;

	@Column(name = "so_dien_thoai")
	private String soDienThoai;

	public LienHe(String diaChi, String email, String soDienThoai) {
		super();
		this.diaChi = diaChi;
		this.email = email;
		this.soDienThoai = soDienThoai;
	}

}
