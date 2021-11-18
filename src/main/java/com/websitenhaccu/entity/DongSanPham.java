package com.websitenhaccu.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "DongSanPhams")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DongSanPham implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dongSanPham_generator")
    @GenericGenerator(
        name = "dongSanPham_generator",
        strategy = "com.websitenhaccu.util.MyGenerator", 
        parameters = {
            @Parameter(name = MyGenerator.INCREMENT_PARAM, value = "1"),
            @Parameter(name = MyGenerator.VALUE_PREFIX_PARAMETER, value = "DSP"),
            @Parameter(name = MyGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d") })
	@Column(name = "dong_san_pham_id")
	private String id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "thuong_hieu_id")
	ThuongHieu thuongHieu;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "loai_san_pham_id")
	LoaiSanPham loaiSanPham;

	@Column(name = "ten_dong_san_pham", columnDefinition = "NVARCHAR(MAX)")
	private String tenDongSanPham;

	@Column(name = "thue")
	private float thue;
	
	@OneToMany(mappedBy = "dongSanPham", fetch = FetchType.LAZY)
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	private List<SanPham> sanPhams;

}
