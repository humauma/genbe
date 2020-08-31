package com.huma.genbe.service;

import java.sql.Date;

import com.huma.genbe.model.dto.ErrorDtoInput;
//import com.huma.genbe.model.dto.ErrorDtoInput;
import com.huma.genbe.model.dto.PersonDtoInput;
import com.huma.genbe.model.dto.PersonDtoOutput;
//import com.huma.genbe.model.entity.PersonEntity;

public interface PersonService {
	PersonDtoOutput hitungUmur(Date biodataEntity, PersonDtoOutput personDto);

	ErrorDtoInput error(PersonDtoInput dto);
}
