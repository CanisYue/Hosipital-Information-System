package com.canis.his.controller;
/**
 * 处方控制类，负责处方页面前后端数据交互
 */

import com.alibaba.fastjson.JSON;
import com.canis.his.VO.CompleteBasic;
import com.canis.his.VO.CompleteDetailInfo;
import com.canis.his.VO.Patient;
import com.canis.his.entity.Complete;
import com.canis.his.entity.Completedetail;
import com.canis.his.entity.Completemodel;
import com.canis.his.entity.Medicine;
import com.canis.his.service.CompleteService;
import com.canis.his.useful.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@RestController
public class CompleteController {
    @Autowired
    CompleteService completeService;

    @RequestMapping(value = "/loadPatient")
    public String loadCheck(@RequestBody Map<String, String> param){
        int id = Integer.parseInt(param.get("doctor"));
        System.out.println("Doctor_id: "+id);
        List<Patient> patientList = completeService.load(id);

        return JSON.toJSONString(new Response(patientList));
    }

    @RequestMapping(value = "/getCompletes")
    public String getComplete(@RequestBody Map<String, String> param){
        int id = Integer.parseInt(param.get("paper_id"));
        List<CompleteBasic> completes = completeService.getCompletes(id);
        return JSON.toJSONString(new Response(completes));
    }

    @RequestMapping(value = "/getCompleteDetail")
    public String getCompleteDetail(@RequestBody Map<String, String> param){
        int id = Integer.parseInt(param.get("complete_id"));
        List<CompleteDetailInfo> completeDetailInfos = completeService.getCompleteDetail(id);
        return JSON.toJSONString(new Response(completeDetailInfos));
    }

    @RequestMapping(value = "/addMedicine")
    public String addMedicine(@RequestBody Map<String, String> param){
        int paper_id = Integer.parseInt(param.get("paper_id"));
        String name = param.get("medicine_name");
        String frequency = param.get("frequency");
        String total = param.get("total");
        String way = param.get("way");
        int number = Integer.parseInt(param.get("number"));
        int complete_id = Integer.parseInt(param.get("complete_id"));
        int res = completeService.addCompleteDetail(complete_id, name, frequency, total, way, number);
        List<Integer> ids = new LinkedList<>();
        ids.add(res);
        return JSON .toJSONString(new Response(ids));
    }

    @RequestMapping(value = "destroyMedicine")
    public void destroyMedicine(@RequestBody Map<String, String> param){
        try {
            int id = Integer.parseInt(param.get("complete_detail_id"));
            completeService.destroyMedicine(id);
        }catch (Exception ex){
            return;
        }
    }

    @RequestMapping(value = "/addComplete")
    public String addComplete(@RequestBody Map<String, String> param){
        int id = Integer.parseInt(param.get("paper_id"));
        String name = param.get("complete_name");
        int doctor_id = Integer.parseInt(param.get("doctor_id"));
        int status = Integer.parseInt(param.get("status"));

        int complete_id = completeService.addComplete(id, doctor_id, name, status);
        List<Integer> ids = new LinkedList<>();
        ids.add(complete_id);
        return JSON.toJSONString(new Response(ids));
    }

    @RequestMapping(value = "/destroyComplete")
    public void destroyComplete(@RequestBody Map<String, String> param){
        int id = Integer.parseInt(param.get("complete_id"));
        completeService.destroyComplete(id);
    }

    @RequestMapping(value = "/getMedicines")
    public String getMedicine(@RequestBody Map<String, String> param){
        List<Medicine> medicines = completeService.getMedicine();
        return JSON.toJSONString(new Response(medicines));
    }

    @RequestMapping(value = "/confirmComplete")
    public String confirmComplete(@RequestBody Map<String, String> param){
        int complete_id = Integer.parseInt(param.get("complete_id"));
        completeService.confirmComplete(complete_id);
        return "Hhhaa";
    }

    @RequestMapping(value = "/loadModel")
    public String getModel(@RequestBody Map<String, String> param){
        int id = Integer.parseInt(param.get("doctor_id"));
        List<Completemodel> completemodels = completeService.getmodel(id);
        return JSON.toJSONString(new Response(completemodels));

    }

    @RequestMapping(value = "/getModelDetail")
    public String getModelDetail(@RequestBody Map<String, String> param){
        int id = Integer.parseInt(param.get("model_id"));
        List<CompleteDetailInfo> completeDetailInfos = completeService.getCompleteModelDetail(id);
        return JSON.toJSONString(new Response(completeDetailInfos));
    }

    @RequestMapping(value = "/useModel")
    public String useModel(@RequestBody Map<String, String> param){
        int id_model = Integer.parseInt(param.get("model_id"));
        int id_complete = Integer.parseInt(param.get("complete_id"));
        completeService.useModel(id_model, id_complete);
        return "useModel";
    }
}
