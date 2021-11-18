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

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.websitenhaccu.util.MyGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "LoaiSanPhams")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoaiSanPham {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "loaiSanPham_generator")
	@GenericGenerator(name = "loaiSanPham_generator", strategy = "com.websitenhaccu.util.MyGenerator", parameters = {
			@Parameter(name = MyGenerator.INCREMENT_PARAM, value = "1"),
			@Parameter(name = MyGenerator.VALUE_PREFIX_PARAMETER, value = "LSP"),
			@Parameter(name = MyGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d") })
	@Column(name = "loai_san_pham_id")
	private String id;

	@Column(name = "ten_loai_san_pham", columnDefinition = "NVARCHAR(MAX)")
	private String tenLoaiSanPham;

//	@OneToMany(mappedBy = "danhMuc", fetch = FetchType.LAZY)
//	@ToString.Exclude
//	@EqualsAndHashCode.Exclude
//	private List<SanPham> sanPhams;

	@OneToMany(mappedBy = "loaiSanPham", fetch = FetchType.LAZY)
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	private List<DongSanPham> dongSanPhams;

	/**
	 * @param id
	 */
	public LoaiSanPham(String id) {
		super();
		this.id = id;
	}

}
