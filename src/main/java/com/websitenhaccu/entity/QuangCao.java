package com.websitenhaccu.entity;

import java.sql.Blob;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "QuangCaos")
@Data
@AllArgsConstructor 
@NoArgsConstructor
public class QuangCao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "quang_cao_id")
	private int id;
	
	@Lob
	@Column(name = "hinh_anh")
	private Blob hinhAnh;
	
	@Column(name = "ngay_them")
	private Date ngayThem;
	
	@Column(name = "link")
	private String link;

}
