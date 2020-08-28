package com.huma.genbe.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t_pendidikan")
public class PendidikanEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pendidikan")
	private Integer idPendEnt;

	@ManyToOne
	@JoinColumn(name = "idperson", referencedColumnName = "id_person")
	private PersonEntity person;

	@Column(name = "jenjang", nullable = false)
	private String jenjangEnt;

	@Column(name = "institusi", nullable = false)
	private String institusiEnt;

	@Column(name = "tahunmasuk", nullable = false)
	private String tahunMasukEnt;

	@Column(name = "tahunlulus", nullable = false)
	private String tahunLulusEnt;

	public Integer getIdPendEnt() {
		return idPendEnt;
	}

	public void setIdPendEnt(Integer idPerEnt) {
		this.idPendEnt = idPerEnt;
	}

	public PersonEntity getPerson() {
		return person;
	}

	public void setPerson(PersonEntity person) {
		this.person = person;
	}

	public String getJenjangEnt() {
		return jenjangEnt;
	}

	public void setJenjangEnt(String jenjangEnt) {
		this.jenjangEnt = jenjangEnt;
	}

	public String getInstitusiEnt() {
		return institusiEnt;
	}

	public void setInstitusiEnt(String institusiEnt) {
		this.institusiEnt = institusiEnt;
	}

	public String getTahunMasukEnt() {
		return tahunMasukEnt;
	}

	public void setTahunMasukEnt(String tahunMasukEnt) {
		this.tahunMasukEnt = tahunMasukEnt;
	}

	public String getTahunLulusEnt() {
		return tahunLulusEnt;
	}

	public void setTahunLulusEnt(String tahunLulusEnt) {
		this.tahunLulusEnt = tahunLulusEnt;
	}

}
