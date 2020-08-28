package com.huma.genbe.model.dto;

public class PendidikanDtoInput {
	private String jenjang;
	private String institusi;
	private String masuk;
	private String lulus;

	public String getJenjang() {
		return jenjang;
	}

	public void setJenjang(String jenjang) {
		this.jenjang = jenjang;
	}

	public String getInstitusi() {
		return institusi;
	}

	public void setInstitusi(String institusi) {
		this.institusi = institusi;
	}

	public String getTahunMasuk() {
		return masuk;
	}

	public void setTahunMasuk(String tahunMasuk) {
		this.masuk = tahunMasuk;
	}

	public String getTahunLulus() {
		return lulus;
	}

	public void setTahunLulus(String tahunLulus) {
		this.lulus = tahunLulus;
	}

}
