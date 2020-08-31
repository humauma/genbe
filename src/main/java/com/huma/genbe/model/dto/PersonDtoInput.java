package com.huma.genbe.model.dto;

public class PersonDtoInput {
	// private Integer idPers;
	private String nik;
	private String name;
	private String adress;
	private String hp;
	private java.sql.Date tgl;
	private String tempatLahir;
//	private ErrorDtoInput errorDto;

//	public Integer getIdPers() {
//		return idPers;
//	}
//
//	public void setIdPers(Integer idPers) {
//		this.idPers = idPers;
//	}

	public String getNik() {
		return nik;
	}

	public void setNik(String nik) {
		this.nik = nik;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getHp() {
		return hp;
	}

	public void setHp(String hp) {
		this.hp = hp;
	}

	public java.sql.Date getTgl() {
		return tgl;
	}

	public void setTgl(java.sql.Date tgl) {
		this.tgl = tgl;
	}

	public String getTmptLahir() {
		return tempatLahir;
	}

	public void setTmptLahir(String tempatLahir) {
		this.tempatLahir = tempatLahir;
	}

//	public ErrorDtoInput getErrorDto() {
//		return errorDto;
//	}
//
//	public void setErrorDto(ErrorDtoInput errorDto) {
//		this.errorDto = errorDto;
//	}
}
