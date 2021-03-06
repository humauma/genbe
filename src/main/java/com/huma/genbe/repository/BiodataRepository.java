package com.huma.genbe.repository;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.huma.genbe.model.entity.BiodataEntity;
//import com.huma.genbe.model.entity.PersonEntity;


@Repository
public interface BiodataRepository extends JpaRepository<BiodataEntity, Integer> {
	BiodataEntity findAllByPersonIdPerEnt(Integer idperson);
}
