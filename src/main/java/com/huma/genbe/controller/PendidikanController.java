package com.huma.genbe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.huma.genbe.model.dto.ErrorDtoInput;
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
	public ErrorDtoInput insert(@RequestBody List<PendidikanDtoInput> dto, @RequestParam Integer idPerson) {
		ErrorDtoInput errorDto = new ErrorDtoInput();
		try {
			if (perRep.findById(idPerson).isPresent()) {
				List<PendidikanEntity> pendidikanEntity = dto.stream().map(x -> convertToEntity(x, idPerson))
						.collect(Collectors.toList());
				pendRep.saveAll(pendidikanEntity);
			}
			errorDto.setStatus("true");
			errorDto.setMessage("data berhasil masuk");
		} catch (Exception e) {
			errorDto.setStatus("false");
			errorDto.setMessage("data gagal masuk");
		}

		return errorDto;
	}

	// Convert to Entity
	private PendidikanEntity convertToEntity(PendidikanDtoInput dto, Integer idPerson) {
		PendidikanEntity pendidikanEntity = new PendidikanEntity();
		pendidikanEntity.setJenjangEnt(dto.getJenjang());
		pendidikanEntity.setInstitusiEnt(dto.getInstitusi());
		pendidikanEntity.setTahunMasukEnt(dto.getTahunMasuk());
		pendidikanEntity.setTahunLulusEnt(dto.getTahunLulus());
		if (perRep.findById(idPerson).isPresent()) {
			PersonEntity personEntity = perRep.findById(idPerson).get();
			pendidikanEntity.setPerson(personEntity);
		}

		return pendidikanEntity;
	}

}