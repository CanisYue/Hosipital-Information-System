package com.canis.his.controller;
/**
 * 负责发药页面的前后端数据交互
 */

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.canis.his.VO.FundInfo;
import com.canis.his.service.FundService;
import com.canis.his.service.PharmacyService;
import com.canis.his.useful.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@RestController
public class PharmacyController {
    @Autowired
    PharmacyService pharmacyService;

    @RequestMapping(value = "/searchPharmacy")
    public String searchFund(@RequestBody Map<String, String> param){
        List<FundInfo> fundInfos = new LinkedList<>();
        try {
            int id = Integer.parseInt(param.get("book_id"));
            fundInfos = pharmacyService.search(id);
            System.out.println(JSON.toJSONString(new Response(fundInfos)));
        }catch (Exception ex){
            return JSON.toJSONString(new Response(0, null));
        }
        return JSON.toJSONString(new Response(fundInfos));
    }

    @RequestMapping(value = "/giveaway")
    public String giveaway(@RequestBody Map<String, String> param){
        int id = Integer.parseInt(param.get("operator_id"));
        String medicineList = param.get("medicineList");
        JSONArray jsonArray = JSONArray.parseArray(medicineList);

        pharmacyService.giveaway(jsonArray);
        return "success_giveaway";
    }
}
