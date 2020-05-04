package com.canis.his.dao;

import com.canis.his.entity.Medicine;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MedicineRepository extends CrudRepository<Medicine, Integer> {
    List<Medicine> findByMedicineName(String name);

}
