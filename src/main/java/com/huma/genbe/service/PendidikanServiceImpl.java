//package com.huma.genbe.service;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//import javax.transaction.Transactional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.huma.genbe.model.dto.ErrorDtoInput;
//import com.huma.genbe.model.dto.PendidikanDtoInput;
//import com.huma.genbe.model.entity.PendidikanEntity;
//import com.huma.genbe.repository.PersonRepository;
//
//@Service
//@Transactional
//public class PendidikanServiceImpl {
//	@Autowired
//	private PersonRepository perRep;
//	
//	@Override
//	public ErrorDtoInput cekError(PendidikanDtoInput pendDto, Integer idPerson) {
//		ErrorDtoInput errorDto = new ErrorDtoInput();
//		try {
//			if (perRep.findById(idPerson).isPresent()) {
//				List<PendidikanEntity> pendidikanEntity = pendDto.stream().map(x -> convertToEntity(x, idPerson))
//						.collect(Collectors.toList());
//			}
//			errorDto.setStatus("true");
//			errorDto.setMessage("data berhasil masuk");
//		} catch (Exception e) {
//			errorDto.setStatus("false");
//			errorDto.setMessage("data gagal masuk");
//		}
//
//		
//		return errorDto;
//	}
//
//}
