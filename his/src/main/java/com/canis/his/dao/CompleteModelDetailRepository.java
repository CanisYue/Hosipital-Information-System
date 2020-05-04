package com.canis.his.dao;

import com.canis.his.entity.Completemodeldetail;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CompleteModelDetailRepository extends CrudRepository<Completemodeldetail, Integer> {
    List<Completemodeldetail> findByCompleteModelId(int id);
}
