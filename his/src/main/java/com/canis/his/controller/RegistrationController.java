package com.canis.his.controller;
/**
 * 负责挂号页面的前后端数据交互
 */

import com.alibaba.fastjson.JSON;
import com.canis.his.VO.DepartmentName;
import com.canis.his.entity.Department;
import com.canis.his.entity.Doctor;
import com.canis.his.entity.RegistrationBook;
import com.canis.his.service.OperatorService;
import com.canis.his.service.RegistrationService;
import com.canis.his.useful.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@RestController
public class RegistrationController {
    @Autowired
    RegistrationService rs;

    @Autowired
    OperatorService operatorService;



    @RequestMapping(value = "/basicInfo")
    public String login(@RequestBody Map<String, String> param){
        List<Object> response = new LinkedList<>();
        try {
            System.out.println("basicInfo ");
            System.out.println(param.get("id"));

            int id = Integer.parseInt(param.get("id"));
            System.out.println(id);

            RegistrationBook registrationBook = rs.getBasicInfo(id);

            System.out.println(registrationBook.getName());

            response.add(registrationBook);
            System.out.println(JSON.toJSONString(registrationBook));
        }catch (Exception ex){
            return JSON.toJSONString(new Response(0, null));
        }

        return JSON.toJSONString(new Response(response));
    }

    @RequestMapping(value = "/getDepartmentList")
    public String getDepartmentList(){
        System.out.println("getDepartmentList");

        List<Department> departments = rs.getDepartmentList();

        return JSON.toJSONString(new Response(departments));
    }

    @RequestMapping(value = "/getDoctor")
    public String getDoctor(@RequestBody Map<String, String> param){
        System.out.println("/getDoctor");
        System.out.println(param.get("department_id"));
        System.out.println(param.get("registration_level_id"));

        int department_id = Integer.parseInt(param.get("department_id"));
        int registration_id = Integer.parseInt(param.get("registration_level_id"));

        List<Doctor> doctorList = rs.getDoctorList(department_id, registration_id);

        return JSON.toJSONString(new Response(doctorList));
    }

    @RequestMapping(value = "/submitRegistration")
    public String generate(@RequestBody Map<String, String> param){
        String res = rs.generate(param);
        return res;
    }


}
