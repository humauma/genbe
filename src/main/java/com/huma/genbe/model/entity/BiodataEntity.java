package com.huma.genbe.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "t_biodata")
public class BiodataEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_bio")
	private Integer idBioEnt;

	@Column(name = "nohp", length = 16)
	private String noHpEnt;

	@Column(name = "tanggal_lahir", nullable = false)
	private java.sql.Date tanggalEnt;

	@Column(name = "tempat_lahir", length = 50)
	private String tempatEnt;

	@OneToOne
	@PrimaryKeyJoinColumn(name = "idperson", referencedColumnName = "id_person")
	private PersonEntity person;

	public Integer getIdBioEnt() {
		return idBioEnt;
	}

	public void setIdBioEnt(Integer idBioEnt) {
		this.idBioEnt = idBioEnt;
	}

	public String getNoHpEnt() {
		return noHpEnt;
	}

	public void setNoHpEnt(String noHpEnt) {
		this.noHpEnt = noHpEnt;
	}

	public java.sql.Date getTglEnt() {
		return tanggalEnt;
	}

	public void setTglEnt(java.sql.Date tanggalEnt) {
		this.tanggalEnt = tanggalEnt;
	}

	public String getTmptLahirEnt() {
		return tempatEnt;
	}

	public void setTmptLahirEnt(String tempatEnt) {
		this.tempatEnt = tempatEnt;
	}

	public PersonEntity getIdPersonEnt() {
		return person;
	}

	public void setIdPersonEnt(PersonEntity person) {
		this.person = person;
	}

}
