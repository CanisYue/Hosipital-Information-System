package com.canis.his.controller;
/**
 * 负责取消挂号页面部分的前后端数据交互
 */

import com.alibaba.fastjson.JSON;
import com.canis.his.VO.Record;
import com.canis.his.entity.Registrationpaper;
import com.canis.his.service.UndoRegistrationService;
import com.canis.his.useful.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@RestController
public class UndoRegistrationController {
    @Autowired
    UndoRegistrationService undoRegistrationService;

    @RequestMapping("/searchRecord")
    public String searchRecord(@RequestBody Map<String, String> param){
        int id;
        try {
            id = Integer.parseInt(param.get("book_id"));
        }catch (Exception ex){
            return JSON.toJSONString(new Response(0, null));
        }

//        String response = undoRegistrationService.searchRecord(param);
        return JSON.toJSONString(new Response(undoRegistrationService.searchRecord(id)));
    }

    @RequestMapping("/undoRegistration")
    public String undoRegistration(@RequestBody Map<String, String> param){
        String  id = param.get("paper_id");
        Record record = undoRegistrationService.undoRegistration(id);
        List<Record> response = new LinkedList<>();
        response.add(record);
        return JSON.toJSONString(new Response(response));
    }
}
