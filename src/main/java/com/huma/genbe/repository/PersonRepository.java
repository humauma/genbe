package com.huma.genbe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.huma.genbe.model.entity.PersonEntity;

@Repository
public interface PersonRepository extends JpaRepository<PersonEntity, String> {
	List<PersonEntity> findByNikEntContaining(String nik);

}
