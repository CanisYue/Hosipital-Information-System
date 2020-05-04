package com.canis.his.dao;

import com.canis.his.entity.Completedetail;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CompletedetailRepository extends CrudRepository<Completedetail, Integer> {
    List<Completedetail> findByCompleteId(int id);
    void deleteByCompleteId(int id);
    void deleteByCompleteDetailId(int id);
}
