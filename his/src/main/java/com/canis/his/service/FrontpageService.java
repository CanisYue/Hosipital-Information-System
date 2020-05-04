package com.canis.his.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.canis.his.VO.Patient;
import com.canis.his.VO.Record;
import com.canis.his.dao.DiseaseRepository;
import com.canis.his.dao.RegistrationPaperRepository;
import com.canis.his.database.MySQL;
import com.canis.his.entity.Disease;
import com.canis.his.entity.Registrationpaper;
import com.canis.his.useful.MyMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class FrontpageService {
    @Autowired
    RegistrationPaperRepository registrationPaperRepository;
    @Autowired
    DiseaseRepository diseaseRepository;

    public List<Patient> load(int id){
        List<Registrationpaper> registrationpapers = registrationPaperRepository.findByDoctorId(id);
        Registrationpaper tmp;
        List<Patient> patients = new LinkedList<>();
        Date dNow = new Date( );
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        String today = ft.format(dNow);
        for(int i=0; i<registrationpapers.size(); i++){
            tmp=registrationpapers.get(i);
            String name = tmp.getName();
            int book_id = tmp.getRegistrationBookId();
            int paper_id = tmp.getRegistrationPaperId();
            int status = tmp.getStatus();
            String date = tmp.getRegistrationDateTime();
//            System.out.println(date);
            String tmpDate = date.split(" ")[0];
            if(status==171 && tmpDate.equals(today)){
                patients.add(new Patient(book_id, paper_id, name));
            }
        }
        return patients;
    }

    public List<Patient> loadUncheck(int id){
        List<Registrationpaper> registrationpapers = registrationPaperRepository.findByDoctorId(id);
        Registrationpaper tmp;
        List<Patient> patients = new LinkedList<>();
        Date dNow = new Date( );
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        String today = ft.format(dNow);


        System.out.println("当前时间为: " + ft.format(dNow));
        for(int i=0; i<registrationpapers.size(); i++){
            tmp=registrationpapers.get(i);
            String name = tmp.getName();
            int book_id = tmp.getRegistrationBookId();
            int paper_id = tmp.getRegistrationPaperId();
            int status = tmp.getStatus();
            String date = tmp.getRegistrationDateTime();
//            System.out.println(date);
            String tmpDate = date.split(" ")[0];
//            System.out.println(tmpDate);

            if(status==178 && tmpDate.equals(today)){
                patients.add(new Patient(book_id, paper_id, name));
            }
        }
        return patients;
    }

    public List<Disease> getAllDisease(){
        List<Disease> diseases = MyMethod.copyIterator(diseaseRepository.findAll());
        List<Disease> res = new LinkedList<>();
        for(int i=0; i<30; i++){
            res.add(diseases.get(i));
        }
        return res;
    }

    public void submitFrontpage(String main_problem, int paper_id, String disease_for_now,
                                String treatment_for_now, String disease_for_past,
                                String allergic_history, String body_check, JSONArray result_estimate){
        try {
            MySQL.frontPage(paper_id+"", main_problem, disease_for_now, treatment_for_now, disease_for_past,
                    allergic_history, body_check);
        } catch (Exception e) {
            e.printStackTrace();
        }
        for(int i=0; i<result_estimate.size(); i++){
            JSONObject obj = result_estimate.getJSONObject(i);
            Disease tmp = diseaseRepository.findByDiseaseName(obj.getString("check_disease")).get(0);
            String disease_id = tmp.getDiseaseId()+"";
            String date = obj.getString("ill_date");
            try {
                MySQL.diagnose(paper_id+"", disease_id, date);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }
}
