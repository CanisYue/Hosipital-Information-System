package com.canis.his.controller;
/**
 * 负责缴费部分的前后端数据交互
 */

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.canis.his.VO.FundInfo;
import com.canis.his.database.MySQL;
import com.canis.his.entity.Disease;
import com.canis.his.service.FundService;
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
public class FundController {
    @Autowired
    FundService fundService;

    @RequestMapping(value = "/searchFund")
    public String searchFund(@RequestBody Map<String, String> param){

        List<FundInfo> fundInfos = new LinkedList<>();
        try {
            int id = Integer.parseInt(param.get("book_id"));
            fundInfos = fundService.search(id);
            System.out.println(JSON.toJSONString(new Response(fundInfos)));
        }catch (Exception ex){
            return JSON.toJSONString(new Response(0, null));
        }
        return JSON.toJSONString(new Response(fundInfos));
    }

    @RequestMapping(value = "/fund")
    public String fund(@RequestBody Map<String, String> param){
        System.out.println();
        System.out.println(JSON.toJSONString(param));

        String fundItem = param.get("fundingList");
        int operator = Integer.parseInt(param.get("operator_id"));
        float fund = Float.parseFloat(param.get("fund"));
        JSONArray jsonArray = JSONArray.parseArray(fundItem);
        int res = fundService.fund(jsonArray, fund, operator);
        List<Integer> response = new LinkedList<>();
        response.add(res);
        return JSON.toJSONString(new Response(response));
    }
}
