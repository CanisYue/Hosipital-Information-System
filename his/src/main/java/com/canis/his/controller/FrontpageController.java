package com.canis.his.controller;
/**
 * 负责病例首页的前后端数据交互
 */

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.canis.his.VO.Patient;
import com.canis.his.dao.RegistrationPaperRepository;
import com.canis.his.entity.Disease;
import com.canis.his.service.FrontpageService;
import com.canis.his.useful.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class FrontpageController {
    @Autowired
    FrontpageService frontpageService;

    @RequestMapping(value = "/loadCheck")
    public String loadCheck(@RequestBody Map<String, String> param){
        int id = Integer.parseInt(param.get("doctor"));
        List<Patient> patientList = frontpageService.load(id);

        return JSON.toJSONString(new Response(patientList));
    }

    @RequestMapping(value = "/loadUnCheck")
    public String loadUnCheck(@RequestBody Map<String, String> param){
        int id = Integer.parseInt(param.get("doctor"));
        List<Patient> patientList = frontpageService.loadUncheck(id);

        return JSON.toJSONString(new Response(patientList));
    }


    @RequestMapping(value="/getAllDiseases")
    public String getAllDisease(@RequestBody Map<String, String> param){
        List<Disease> diseases = frontpageService.getAllDisease();
        return JSON.toJSONString(new Response(diseases));
    }

    @RequestMapping(value="/submitFrontpage")
    public String submitFrontpage(@RequestBody Map<String, String> param){
        String main_problem = param.get("main_problem");
        int paper_id = Integer.parseInt(param.get("in_paper_id"));
        String disease_for_now = param.get("disease_for_now");
        String treatment_for_now = param.get("treatment_for_now");
        String disease_for_past = param.get("disease_for_past");
        String allergic_history = param.get("allergic_history");
        String body_check = param.get("body_check");
        String result_estimate = param.get("result_estimate");
        System.out.println(result_estimate);
        JSONArray jsonArray = JSONArray.parseArray(result_estimate);

        frontpageService.submitFrontpage(main_problem, paper_id, disease_for_now, treatment_for_now,
                disease_for_past, allergic_history, body_check, jsonArray);

        return "success";
    }
}
