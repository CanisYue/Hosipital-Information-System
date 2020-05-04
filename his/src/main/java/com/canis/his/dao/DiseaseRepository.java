package com.canis.his.dao;

import com.canis.his.entity.Disease;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DiseaseRepository extends CrudRepository<Disease, Integer> {
//    List<Disease> findByIdAndDiseaseName(String name);
    List<Disease> findByDiseaseName(String name);
}
