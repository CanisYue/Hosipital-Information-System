package com.canis.his.dao;


import com.canis.his.entity.Doctor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import javax.print.Doc;
import java.util.List;

@Component
public interface DoctorRepository extends CrudRepository<Doctor, Integer> {
//    List<Doctor> findByDepartment_idAndRegistration_level_id(int id1, int id2);
    List<Doctor> findByDepartmentIdAndRegistrationLevelId(int department_id, int registration_level_id);
//    List<Doctor> findByRegistrationLevelId(int id);
}
