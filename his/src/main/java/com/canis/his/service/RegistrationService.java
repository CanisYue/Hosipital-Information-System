package com.canis.his.service;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.canis.his.VO.DepartmentName;
import com.canis.his.VO.RegistrationReturn;
import com.canis.his.dao.DepartmentRepository;
import com.canis.his.dao.DoctorRepository;
import com.canis.his.dao.RegistrationBookRepository;
import com.canis.his.database.MySQL;
import com.canis.his.entity.Department;
import com.canis.his.entity.Doctor;
import com.canis.his.entity.RegistrationBook;
import com.canis.his.useful.MyMethod;
import com.canis.his.useful.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.*;

@Service
@Transactional(rollbackFor = Exception.class)
public class RegistrationService {
    @Autowired
    RegistrationBookRepository registrationBookRepository;
    @Autowired
    DepartmentRepository departmentRepository;
    @Autowired
    DoctorRepository doctorRepository;

    public RegistrationBook getBasicInfo(int number){
        RegistrationBook registrationBook = registrationBookRepository.findById(number).get();
        return registrationBook;
    }

    @Autowired
    public List<Department> getDepartmentList(){
        Iterable<Department> departments = departmentRepository.findAll();
        List<Department> departments1 = MyMethod.copyIterator(departments);
        return departments1;
    }

    @Autowired
    public List<DepartmentName> getDepartmentName(){
        Iterable<Department> departments = departmentRepository.findAll();
        List<Department> departments1 = MyMethod.copyIterator(departments);
        return DepartmentName.toDepartmentName(departments1);
    }


    public List<Doctor> getDoctorList(int departID, int levelId){
        List<Doctor> doctorList = doctorRepository.findByDepartmentIdAndRegistrationLevelId(departID, levelId);

        return doctorList;
    }

    public String generate(Map<String, String> param){

        String id_number = param.get("id_number");
        String name = param.get("name");
        String gender = param.get("gender");
        String birth = param.get("birth");
        String age=null;
//        String age = param.get("age");
        String address = param.get("address");
        String morning_afternoon;
//        String morning_afternoon = param.get("morning_afternoon");
        String doctor_id = param.get("doctor_id");
        String settlement_type_id = param.get("settlement_type_id");
        String request_book = param.get("request_book");
        String operator_id = param.get("operator_id");

        //判断上下午
        GregorianCalendar ca = new GregorianCalendar();
        System.out.println(ca.get(GregorianCalendar.AM_PM));
        if(ca.get(GregorianCalendar.AM_PM)==0){
            morning_afternoon = "上午";
        }
        else{
            morning_afternoon = "下午";
        }

        //计算年龄
        try {
            age = MyMethod.getAge(MyMethod.parse(birth))+"";           //由出生日期获得年龄***
        } catch (Exception e) {
            e.printStackTrace();
        }


        System.out.println(birth);
        if(gender.equals("男")){gender=71+"";}
        else {gender=72+"";}
        String res = null;
        try {
            res = MySQL.registration(id_number, name, gender, birth, age, address, morning_afternoon, doctor_id,
                    settlement_type_id, request_book, operator_id);
        } catch (Exception e) {
            e.printStackTrace();
        }
//        List<Object> response = new LinkedList<>();
//        response.add(new RegistrationReturn(paper_id, invoice_id, fund));
//        System.out.println(paper_id);
//        System.out.println(invoice_id);
//        System.out.println(fund);
        return res;

    }


}
