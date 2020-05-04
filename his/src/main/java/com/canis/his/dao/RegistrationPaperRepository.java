package com.canis.his.dao;

import com.canis.his.entity.Operator;
import com.canis.his.entity.Registrationpaper;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RegistrationPaperRepository extends CrudRepository<Registrationpaper, Integer> {
    List<Registrationpaper> findByRegistrationBookId(int id);
    List<Registrationpaper> findByDoctorId(int id);
}
