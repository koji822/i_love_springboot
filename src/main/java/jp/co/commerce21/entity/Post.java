package jp.co.commerce21.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="tjapanpost")
public class Post {

	@Id
	@Column(name="zip_code", length=7, nullable=false)
	private String zipCode;
	
	@Column(name="zip_code_old", length=5)
	private String zipCodeOld;

	@Column(name="pref_code", length=5, nullable=false)
	private String prefCode;
	
	@Column(name="pref_name_kana", length=64, nullable=false)
	private String prefNameKana;
	
	@Column(name="city_name_kana", length=64, nullable=false)
	private String cityNameKana;
	
	@Column(name="townarea_name_kana", length=128, nullable=false)
	private String townareaNameKana;
	
	@Column(name="pref_name", length=32, nullable=false)
	private String prefName;
	
	@Column(name="city_name", length=32, nullable=false)
	private String cityName;
	
	@Column(name="townarea_name", length=128, nullable=false)
	private String townareaName;
	
	@Column(name="remarks_01", columnDefinition="tinyint(1)")
	private String remarks01;
	
	@Column(name="remarks_02", columnDefinition="tinyint(1)")
	private String remarks02;
	
	@Column(name="remarks_03", columnDefinition="tinyint(1)")
	private String remarks03;
	
	@Column(name="remarks_04", columnDefinition="tinyint(1)")
	private String remarks04;
	
	@Column(name="remarks_05", columnDefinition="tinyint(1)")
	private String remarks05;
	
	@Column(name="remarks_06", columnDefinition="tinyint(1)")
	private String remarks06;
}
