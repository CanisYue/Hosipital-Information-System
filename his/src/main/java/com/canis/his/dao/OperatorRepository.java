package com.canis.his.dao;


import com.canis.his.entity.Operator;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public interface OperatorRepository extends CrudRepository<Operator, Integer>{
    List<Operator> findByRealname(String realName);
    List<Operator> findByUsername(String userName);
}


