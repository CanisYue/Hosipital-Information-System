package com.canis.his.service;

import com.canis.his.dao.OperatorRepository;
import com.canis.his.entity.Operator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class OperatorService {
    @Autowired
    OperatorRepository op;

    public Operator findByUserName(String name){
        try {
            Operator operator = op.findByUsername(name).get(0);
            return operator;
        }catch (ArrayIndexOutOfBoundsException ex){
            return null;
        }


    }
}
