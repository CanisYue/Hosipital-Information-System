package com.canis.his.service;

import com.canis.his.VO.Record;
import com.canis.his.dao.*;
import com.canis.his.database.MySQL;
import com.canis.his.entity.Department;
import com.canis.his.entity.Doctor;
import com.canis.his.entity.Registrationpaper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Service
@Transactional(rollbackFor = Exception.class)
public class UndoRegistrationService {
    @Autowired
    RegistrationService registrationService;
    @Autowired
    RegistrationBookRepository registrationBookRepository;
    @Autowired
    RegistrationPaperRepository registrationPaperRepository;
    @Autowired
    ConstantRepository constantRepository;
    @Autowired
    DoctorRepository doctorRepository;
    @Autowired
    DepartmentRepository departmentRepository;

   public List<Record> searchRecord(int id){
       List<Registrationpaper> registrationpapers = registrationPaperRepository.findByRegistrationBookId(id);
       Registrationpaper tmp;
       List<Record> records = new LinkedList<>();
       Date dNow = new Date( );
       SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
       String today = ft.format(dNow);
       for(int i=0; i<registrationpapers.size(); i++){
           tmp = registrationpapers.get(i);
           int tmp_paper_id = tmp.getRegistrationPaperId();
           String tmpDep = departmentRepository.findById(tmp.getDepartmentId()).get().getDepartment_name();
           String tmpDoc = doctorRepository.findById(tmp.getDoctorId()).get().getRealname();
           String status = constantRepository.findById(tmp.getStatus()).get().getConstant_name();
           String name = tmp.getName();
           String id_number = tmp.getIdNumber();
           System.out.println(tmp.getRegistrationDateTime());
           String date = tmp.getRegistrationDateTime();
//            System.out.println(date);
           String tmpDate = date.split(" ")[0];
           if(tmpDate.equals(today)) {
               records.add(new Record(tmp.getRegistrationDateTime(), tmp.getMorningAfternoon(),
                       tmpDep, tmpDoc, status, tmp_paper_id, id_number, name));
           }
       }
        return records;

   }

   public Record undoRegistration(String id){
       String operator_id=9+"";
       try {
           MySQL.backregistration(id, operator_id);
           Registrationpaper tmp = registrationPaperRepository.findById(Integer.parseInt(id)).get();
           int tmp_paper_id = tmp.getRegistrationPaperId();
           String tmpDep = departmentRepository.findById(tmp.getDepartmentId()).get().getDepartment_name();
           String tmpDoc = doctorRepository.findById(tmp.getDoctorId()).get().getRealname();
           String status = constantRepository.findById(tmp.getStatus()).get().getConstant_name();
           String name = tmp.getName();
           String id_number = tmp.getIdNumber();

           return new Record(tmp.getRegistrationDateTime(), tmp.getMorningAfternoon(),
                   tmpDep, tmpDoc, status, tmp_paper_id, id_number, name);
       } catch (Exception e) {
           e.printStackTrace();
           return null;
       }
   }
}
