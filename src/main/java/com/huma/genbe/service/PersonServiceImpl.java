package com.huma.genbe.service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;

import javax.transaction.Transactional;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huma.genbe.model.dto.ErrorDtoInput;
import com.huma.genbe.model.dto.PersonDtoInput;
import com.huma.genbe.model.dto.PersonDtoOutput;
//import com.huma.genbe.model.entity.BiodataEntity;
//import com.huma.genbe.model.entity.PersonEntity;
//import com.huma.genbe.repository.BiodataRepository;
//import com.huma.genbe.repository.PersonRepository;

@Service
@Transactional(dontRollbackOn = { NullPointerException.class })
public class PersonServiceImpl implements PersonService {
//	@Autowired
//	private PersonRepository perRep;
//	private BiodataRepository bioRep;

	@Override
	public PersonDtoOutput hitungUmur(Date biodataEntity, PersonDtoOutput personDto) {
		java.sql.Date dob = biodataEntity;
		LocalDate today = LocalDate.now();
		LocalDate birthDate = dob.toLocalDate();
		Period p = Period.between(birthDate, today);
		// p.getYears();
		// PersonDtoOutput personDto = new PersonDtoOutput();
		personDto.setUmur(p.getYears());
		return personDto;
	}

	@Override
	public ErrorDtoInput error(PersonDtoInput dto) {
		// PersonEntity entity = perRep.save(personEntity);
		ErrorDtoInput errorDto = new ErrorDtoInput();
		java.sql.Date dob = dto.getTgl();
		LocalDate today = LocalDate.now();
		LocalDate birthDate = dob.toLocalDate();
		Period p = Period.between(birthDate, today);
		if (((p.getYears() >= 30)) && (dto.getNik().length() == 16)) {
			errorDto.setStatus("true");
			errorDto.setMessage("data berhasil masuk");
			return errorDto;
		} else if (((p.getYears() <= 30)) && (dto.getNik().length() == 16)) {
			errorDto.setStatus("false");
			errorDto.setMessage("data gagal masuk, umur kurang dari 30");
			// perRep.deleteById(dto.getNik());
			// bioRep.deleteById(dto.get);
			return errorDto;
		} else if (((p.getYears() <= 30)) && (dto.getNik().length() != 16)) {
			errorDto.setStatus("false");
			errorDto.setMessage("data gagal masuk, nik tidak 16digit");
			// perRep.deleteById(dto.getNik());
//			bioRep.deleteById(personEntity.getBiodataEnt().getIdBioEnt());
			return errorDto;
		} else {
			errorDto.setStatus("false");
			errorDto.setMessage("data gagal masuk, nik tidak 16digit dan umur kurang dari 30");
			// perRep.deleteById(dto.getNik());
//			bioRep.deleteById(personEntity.getBiodataEnt().getIdBioEnt());
			return errorDto;
		}
	}

//	@Override
//	public ItemDtoOutput insertTambahItem(ItemDtoOutput dto, ItemDtoOutput tambah) {
//		dto.setJumlahItem(dto.getJumlahItem() + tambah.getJumlahItem());
//		return dto;
//	}
}