package com.canis.his.dao;

import com.canis.his.entity.Complete;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CompleteRepository extends CrudRepository<Complete, Integer> {
    List<Complete> findByRegistrationPaperId(int id);
    List<Complete> findByRegistrationBookId(int id);

}
