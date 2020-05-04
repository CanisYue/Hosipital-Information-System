package com.canis.his.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.canis.his.VO.FundInfo;
import com.canis.his.dao.*;
import com.canis.his.entity.Complete;
import com.canis.his.entity.Completedetail;
import com.canis.his.entity.RegistrationBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class PharmacyService {
    @Autowired
    CompleteRepository completeRepository;
    @Autowired
    CompletedetailRepository completedetailRepository;
    @Autowired
    RegistrationBookRepository registrationBookRepository;
    @Autowired
    MedicineRepository medicineRepository;
    @Autowired
    InvoiceRepository invoiceRepository;


    public List<FundInfo> search(int book_id){
        List<Complete> completes = completeRepository.findByRegistrationBookId(book_id);
        List<FundInfo> res = new LinkedList<>();
        RegistrationBook registrationBook = registrationBookRepository.findById(book_id).get();
        String name = registrationBook.getName();
        String id_number = registrationBook.getRegistration_book_id_number();
//        System.out.println(book_id);
        System.out.println(completes.get(0).getCompleteName());

        for(int i=0; i<completes.size(); i++){
            Complete complete = completes.get(i);
            int complete_id = complete.getCompleteId();
            List<Completedetail> completedetails = completedetailRepository.findByCompleteId(complete_id);
            int paper_id = complete.getRegistrationPaperId();
            for(int j=0; j<completedetails.size(); j++){
                Completedetail completedetail = completedetails.get(j);
                String medicine_name = medicineRepository.findById(completedetail.getMedicineId()).get().getMedicineName();
                float price = medicineRepository.findById(completedetail.getMedicineId()).get().getPrice();
                int number = completedetail.getNumber();
                String time = complete.getCreatedTime();
                int detail_id = completedetail.getCompleteDetailId();
                if(completedetail.getStatus()==171){
                    res.add(new FundInfo(book_id, paper_id, name, medicine_name, number, price, time, "已缴费", id_number, detail_id));
                }
            }
        }
        return res;
    }

    public void giveaway(JSONArray jsonArray){
        for(int i=0; i<jsonArray.size(); i++){
            JSONObject obj = jsonArray.getJSONObject(i);
            int detail_id = Integer.parseInt(obj.getString("detail_id"));

            Completedetail completedetail = completedetailRepository.findById(detail_id).get();
            completedetail.setStatus(172);

        }
        return;
    }
}
