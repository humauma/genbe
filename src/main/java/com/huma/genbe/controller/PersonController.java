package com.huma.genbe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.huma.genbe.model.dto.ErrorDto;
import com.huma.genbe.model.dto.PersonDtoInput;
import com.huma.genbe.model.dto.PersonDtoOutput;
import com.huma.genbe.model.entity.BiodataEntity;
import com.huma.genbe.model.entity.PersonEntity;
import com.huma.genbe.repository.BiodataRepository;
import com.huma.genbe.repository.PersonRepository;
import com.huma.genbe.service.PersonService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/person")
public class PersonController {
	private final PersonRepository perRep;
	private final BiodataRepository bioRep;

	@Autowired
	public PersonController(PersonRepository perRep, BiodataRepository bioRep) {
		this.perRep = perRep;
		this.bioRep = bioRep;
	}

	@Autowired
	private PersonService perServ;

	@GetMapping("/{nik}")
	public List<PersonDtoOutput> get(@PathVariable String nik) {
		List<PersonEntity> personEntityList = perRep.findByNikEntContaining(nik);
		List<PersonDtoOutput> personDto = personEntityList.stream().map(this::convertToDtoOut)
				.collect(Collectors.toList());
		return personDto;
	}

	@PostMapping
	public ErrorDto insert(@RequestBody PersonDtoInput dto) {
		PersonEntity personEntity = convertToEntityPer(dto);
		perRep.save(personEntity);
		BiodataEntity biodataEntity = convertToEntityBio(dto);
		bioRep.save(biodataEntity);
		ErrorDto errorDto = new ErrorDto();
		perServ.error(personEntity);
		return errorDto;
	}

	// Convert to Entity
	private PersonEntity convertToEntityPer(PersonDtoInput dto) {
		PersonEntity personEntity = new PersonEntity();
		personEntity.setNikEnt(dto.getNik());
		personEntity.setNamaEnt(dto.getName());
		personEntity.setAlamatEnt(dto.getAdress());
		return personEntity;
	}

	private BiodataEntity convertToEntityBio(PersonDtoInput dto) {
		BiodataEntity biodataEntity = new BiodataEntity();
		biodataEntity.setNoHpEnt(dto.getHp());
		biodataEntity.setTglEnt(dto.getTgl());
		biodataEntity.setTmptLahirEnt(dto.getTmptLahir());
		return biodataEntity;
	}

	// Convert to Dto
	private PersonDtoOutput convertToDtoOut(PersonEntity personEntity) {
		PersonDtoOutput personDto = new PersonDtoOutput();
		personDto.setNik(personEntity.getNikEnt());
		personDto.setName(personEntity.getNamaEnt());
		personDto.setAdress(personEntity.getAlamatEnt());

		personDto.setHp(personEntity.getBiodataEnt().getNoHpEnt());
		personDto.setTgl(personEntity.getBiodataEnt().getTglEnt());
		personDto.setTmptLahir(personEntity.getBiodataEnt().getTmptLahirEnt());
		perServ.hitungUmur(personEntity.getBiodataEnt().getTglEnt(), personDto);
		return personDto;
	}

//	private PersonDtoInput convertToDtoIn(PersonEntity personEntity) {
//		PersonDtoInput personDto = new PersonDtoInput();
//		personDto.setNik(personEntity.getNikEnt());
//		personDto.setName(personEntity.getNamaEnt());
//		personDto.setAdress(personEntity.getAlamatEnt());
//
//		personDto.setHp(personEntity.getBiodataEnt().getNoHpEnt());
//		personDto.setTgl(personEntity.getBiodataEnt().getTglEnt());
//		personDto.setTmptLahir(personEntity.getBiodataEnt().getTmptLahirEnt());
//		return personDto;
//	}

}