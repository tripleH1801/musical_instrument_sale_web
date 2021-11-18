package com.websitenhaccu.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuangCaoDTO {
	private int id;
	
	private Date ngayThem;

	private String link;
	
	private String hinhAnhBase64;

}
