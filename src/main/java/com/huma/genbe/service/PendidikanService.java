package com.huma.genbe.service;

import com.huma.genbe.model.dto.ErrorDtoInput;
import com.huma.genbe.model.dto.PendidikanDtoInput;

public interface PendidikanService {
	ErrorDtoInput cekError(PendidikanDtoInput pendDto, Integer idPerson);
}
