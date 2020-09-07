package com.huma.genbe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.huma.genbe.model.dto.ErrorDtoInput;
import com.huma.genbe.model.dto.ErrorDtoOutput;
import com.huma.genbe.model.dto.PersonDtoInput;
import com.huma.genbe.model.dto.PersonDtoOutput;
import com.huma.genbe.model.entity.BiodataEntity;
import com.huma.genbe.model.entity.PersonEntity;
import com.huma.genbe.repository.BiodataRepository;
import com.huma.genbe.repository.PendidikanRepository;
import com.huma.genbe.repository.PersonRepository;
import com.huma.genbe.service.PersonService;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/person")
public class PersonController {
	private final PersonRepository perRep;
	private final BiodataRepository bioRep;
	private final PendidikanRepository pendRep;

	@Autowired
	public PersonController(PersonRepository perRep, BiodataRepository bioRep, PendidikanRepository pendRep) {
		this.perRep = perRep;
		this.bioRep = bioRep;
		this.pendRep = pendRep;
	}

	@Autowired
	private PersonService perServ;

	@GetMapping("/all")
	public List<PersonDtoOutput> get() {
		List<PersonEntity> personEntity = perRep.findAll();
		List<PersonDtoOutput> personDto = personEntity.stream().map(this::convertToDtoOut).collect(Collectors.toList());
		return personDto;
	}
	
	
	
	@GetMapping("/{nik}")
	public List<Object> get(@PathVariable String nik) {
//	public PersonDtoOutput get(@PathVariable String nik) {
		List<Object> personOut = new ArrayList<>();
		ErrorDtoOutput errorDto = new ErrorDtoOutput();
		ErrorDtoInput errorDtoIn = new ErrorDtoInput();
		if (nik.length() == 16) {
			if (perRep.findByNikEntLike(nik).isEmpty() == false) {
				PersonEntity personEntityList = perRep.findByNikEntLike(nik).get(0);
				//int idPerson = personEntityList.getIdPerEnt();
				PersonDtoOutput personDto = convertToDtoOut(personEntityList);
				//personDto.setPddknTerakhir(pendRep.pendidikanTerakhir(idPerson));
				errorDto.setStatus("true");
				errorDto.setMessage("success");
				errorDto.setData(personDto);
				personOut.add(errorDto);
				// personOut.add(personDto);
			} else {
				errorDtoIn.setStatus("false");
				errorDtoIn.setMessage("data gagal masuk, data dengan " + nik + " tidak ditemukan");
				personOut.add(errorDtoIn);
			}
		} else {
			errorDtoIn.setStatus("false");
			errorDtoIn.setMessage("data gagal masuk, jumlah digit nik tidak sama dengan 16");
			personOut.add(errorDtoIn);
		}
		return personOut;
	}

	@PostMapping
	public ErrorDtoInput insert(@RequestBody PersonDtoInput dto) {
		ErrorDtoInput errorDto = new ErrorDtoInput();
		java.sql.Date dob = dto.getTgl();
		LocalDate today = LocalDate.now();
		LocalDate birthDate = dob.toLocalDate();
		Period p = Period.between(birthDate, today);
		if (((p.getYears() >= 30)) && (dto.getNik().length() == 16)) {
			errorDto.setStatus("true");
			errorDto.setMessage("data berhasil masuk");
			PersonEntity personEntity = convertToEntityPer(dto);
			perRep.save(personEntity);
			BiodataEntity biodataEntity = convertToEntityBio(dto);
			biodataEntity.setIdPersonEnt(personEntity);
			bioRep.save(biodataEntity);
			return errorDto;
		} else if (((p.getYears() <= 30)) && (dto.getNik().length() == 16)) {
			errorDto.setStatus("false");
			errorDto.setMessage("data gagal masuk, umur kurang dari 30");
			return errorDto;
		} else if (((p.getYears() <= 30)) && (dto.getNik().length() != 16)) {
			errorDto.setStatus("false");
			errorDto.setMessage("data gagal masuk, nik tidak 16digit");
			return errorDto;
		} // else {
		errorDto.setStatus("false");
		errorDto.setMessage("data gagal masuk, nik tidak 16digit dan umur kurang dari 30");
		return errorDto;
		// }
		// ErrorDtoInput errorDto = new ErrorDtoInput();
		// perServ.error(dto);
		// return dto;

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
		personDto.setPddknTerakhir(pendRep.pendidikanTerakhir(personEntity.getIdPerEnt()));
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