package com.huma.genbe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.huma.genbe.model.dto.PendidikanDtoInput;
import com.huma.genbe.model.entity.PendidikanEntity;
import com.huma.genbe.model.entity.PersonEntity;
import com.huma.genbe.repository.PendidikanRepository;
import com.huma.genbe.repository.PersonRepository;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pendidikan")
public class PendidikanController {
	private final PendidikanRepository pendRep;
	private final PersonRepository perRep;

	@Autowired
	public PendidikanController(PendidikanRepository pendRep, PersonRepository perRep) {
		this.pendRep = pendRep;
		this.perRep = perRep;
	}

	@PostMapping("/{idPerson}")
	public List<PendidikanDtoInput> insert(@RequestBody List<PendidikanDtoInput> dto, @PathVariable Integer idPerson) {
		//List<PendidikanDtoInput> personList = pendRep.findAllById(ids) //saya bingung gimana ngehubungin id nya kak

		List<PendidikanEntity> pendidikanEntity = dto.stream().map(this::convertToEntity).collect(Collectors.toList());
		
		pendRep.saveAll(pendidikanEntity);

		return dto;
	}

	// Convert to Entity
	private PendidikanEntity convertToEntity(PendidikanDtoInput dto) {
		PendidikanEntity pendidikanEntity = new PendidikanEntity();
		pendidikanEntity.setJenjangEnt(dto.getJenjang());
		pendidikanEntity.setInstitusiEnt(dto.getInstitusi());
		pendidikanEntity.setTahunMasukEnt(dto.getTahunMasuk());
		pendidikanEntity.setTahunLulusEnt(dto.getTahunLulus());
		return pendidikanEntity;
	}

}