package com.huma.genbe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.huma.genbe.model.entity.PendidikanEntity;

@Repository
public interface PendidikanRepository extends JpaRepository<PendidikanEntity, Integer> {
	List<PendidikanEntity> findByPersonIdPerEnt(Integer idPerEnt);

	@Query(value = "SELECT jenjang FROM public.t_pendidikan where idperson =?1 order by tahunlulus desc limit 1 ", nativeQuery = true)
	String pendidikanTerakhir(Integer idPerson);
}
