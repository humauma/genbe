package com.huma.genbe.model.dto;

//import java.util.*;

public class PersonDtoOutput extends ErrorDtoInput {
	private String nik;
	private String name;
	private String adress;
	private String hp;
	private java.sql.Date tgl;
	private String tempatLahir;
	private Integer umur;
	private String pendidikan_terakhir;

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

	public Integer getUmur() {
		return umur;
	}

	public void setUmur(Integer umur) {
		this.umur = umur;
	}

	public String getPddknTerakhir() {
		return pendidikan_terakhir;
	}

	public void setPddknTerakhir(String pendidikan_terakhir) {
		this.pendidikan_terakhir = pendidikan_terakhir;
	}

}
