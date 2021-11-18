package com.websitenhaccu.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "Maus")
@Data
@AllArgsConstructor 
@NoArgsConstructor
public class Mau {

	@Id
	@Column(name = "mau_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "ten_mau", columnDefinition = "NVARCHAR(MAX)")
	private String tenMau;
	
	@OneToMany(mappedBy = "mau", fetch = FetchType.EAGER) /// đã doi tu lazy qua eager
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private List<MauSanPham> mauSanPhams;

	public Mau(int id, String tenMau) {
		super();
		this.id = id;
		this.tenMau = tenMau;
	} 
	
	
}
