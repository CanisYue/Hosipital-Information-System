package com.canis.his.VO;

import com.alibaba.fastjson.JSON;
import com.canis.his.entity.Department;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public class DepartmentName {
    private int value;
    private String label;

    public DepartmentName(int value, String label) {
        this.value = value;
        this.label = label;
    }

    public static List<DepartmentName> toDepartmentName(List<Department> departments){
        List<DepartmentName> res = new LinkedList<>();
        for(int i=0; i<10; i++){
            Department tmp = departments.get(i);
//            System.out.println(tmp.getDepartment_name());
            res.add(new DepartmentName(tmp.getDepartment_id(), tmp.getDepartment_name()));
        }
        System.out.println(JSON.toJSONString(res));
        return res;
    }
}
