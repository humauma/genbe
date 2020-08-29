package com.huma.genbe.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t_person")
public class PersonEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_person")
	private Integer idPerEnt;

	@Column(name = "nik", unique = true, length = 16, nullable = false)
	private String nikEnt;

	@Column(name = "nama", length = 50)
	private String namaEnt;

	@Column(name = "alamat", length = 255)
	private String alamatEnt;

	@OneToOne(mappedBy = "person")
	private BiodataEntity biodata;

	public Integer getIdPerEnt() {
		return idPerEnt;
	}

	public void setIdPerEnt(Integer idPerEnt) {
		this.idPerEnt = idPerEnt;
	}

	public String getNikEnt() {
		return nikEnt;
	}

	public void setNikEnt(String nikEnt) {
		this.nikEnt = nikEnt;
	}

	public String getNamaEnt() {
		return namaEnt;
	}

	public void setNamaEnt(String namaEnt) {
		this.namaEnt = namaEnt;
	}

	public String getAlamatEnt() {
		return alamatEnt;
	}

	public void setAlamatEnt(String alamatEnt) {
		this.alamatEnt = alamatEnt;
	}

	public BiodataEntity getBiodataEnt() {
		return biodata;
	}

	public void setBiodataEnt(BiodataEntity biodata) {
		this.biodata = biodata;
	}

}