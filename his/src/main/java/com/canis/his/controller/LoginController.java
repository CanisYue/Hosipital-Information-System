package com.canis.his.controller;
/**
 * 负责登录页面的前后端数据交互
 */

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.canis.his.entity.Operator;
import com.canis.his.service.OperatorService;
import com.canis.his.useful.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@RestController
public class LoginController {
    @Autowired
    OperatorService operatorService;

    @RequestMapping(value = "/login")
    public String login(@RequestBody Map<String, String> param){
        System.out.println("login ");
        String account = param.get("account");
        String password = param.get("password");
        System.out.println("account: " + account);
        System.out.println("password " + password);

        List<Object> response = new LinkedList<>();
        Operator op = operatorService.findByUserName(account);

        System.out.println(op.getRealname());
        JSONObject jsonObject = (JSONObject) JSON.toJSON(op);
        if(!op.getPassword().equals(password)){
            return JSON.toJSONString(new Response(null));
        }
        response.add(op);

        System.out.println(JSON.toJSONString(op));
        return JSON.toJSONString(new Response(response));
    }


}
