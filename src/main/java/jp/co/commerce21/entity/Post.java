package jp.co.commerce21.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getZipCodeOld() {
		return zipCodeOld;
	}

	public void setZipCodeOld(String zipCodeOld) {
		this.zipCodeOld = zipCodeOld;
	}

	public String getPrefCode() {
		return prefCode;
	}

	public void setPrefCode(String prefCode) {
		this.prefCode = prefCode;
	}

	public String getPrefNameKana() {
		return prefNameKana;
	}

	public void setPrefNameKana(String prefNameKana) {
		this.prefNameKana = prefNameKana;
	}

	public String getCityNameKana() {
		return cityNameKana;
	}

	public void setCityNameKana(String cityNameKana) {
		this.cityNameKana = cityNameKana;
	}

	public String getTownareaNameKana() {
		return townareaNameKana;
	}

	public void setTownareaNameKana(String townareaNameKana) {
		this.townareaNameKana = townareaNameKana;
	}

	public String getPrefName() {
		return prefName;
	}

	public void setPrefName(String prefName) {
		this.prefName = prefName;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getTownareaName() {
		return townareaName;
	}

	public void setTownareaName(String townareaName) {
		this.townareaName = townareaName;
	}

	public String getRemarks01() {
		return remarks01;
	}

	public void setRemarks01(String remarks01) {
		this.remarks01 = remarks01;
	}

	public String getRemarks02() {
		return remarks02;
	}

	public void setRemarks02(String remarks02) {
		this.remarks02 = remarks02;
	}

	public String getRemarks03() {
		return remarks03;
	}

	public void setRemarks03(String remarks03) {
		this.remarks03 = remarks03;
	}

	public String getRemarks04() {
		return remarks04;
	}

	public void setRemarks04(String remarks04) {
		this.remarks04 = remarks04;
	}

	public String getRemarks05() {
		return remarks05;
	}

	public void setRemarks05(String remarks05) {
		this.remarks05 = remarks05;
	}

	public String getRemarks06() {
		return remarks06;
	}

	public void setRemarks06(String remarks06) {
		this.remarks06 = remarks06;
	}
}
