package com.canis.his.service;


import com.canis.his.VO.CompleteBasic;
import com.canis.his.VO.CompleteDetailInfo;
import com.canis.his.VO.Patient;
import com.canis.his.dao.*;
import com.canis.his.entity.*;
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
public class CompleteService {
    @Autowired
    RegistrationPaperRepository registrationPaperRepository;
    @Autowired
    CompleteRepository completeRepository;
    @Autowired
    CompletedetailRepository completedetailRepository;
    @Autowired
    MedicineRepository medicineRepository;
    @Autowired
    CompleteModelRepository completeModelRepository;
    @Autowired
    CompleteModelDetailRepository completeModelDetailRepository;
    @Autowired
    DoctorRepository doctorRepository;

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
            if((status==178 || status == 179) && tmpDate.equals(today)){
                patients.add(new Patient(book_id, paper_id, name));
            }
        }
        return patients;
    }

    public List<CompleteBasic> getCompletes(int id){
        List<Complete> completes = completeRepository.findByRegistrationPaperId(id);
        List<CompleteBasic> res = new LinkedList<>();
        for(int i=0; i<completes.size(); i++){
            int status = completes.get(i).getStatus();
            Complete tmp = completes.get(i);

            if(status == 175) {
                res.add(new CompleteBasic(tmp.getCompleteId(), tmp.getCompleteName(), "暂存"));
            }
            else if(status == 176){
                res.add(new CompleteBasic(tmp.getCompleteId(), tmp.getCompleteName(), "开立"));
            }

        }
        return res;
    }

    public List<CompleteDetailInfo> getCompleteDetail(int id){
        List<Completedetail> completeDetails = completedetailRepository.findByCompleteId(id);
        List<CompleteDetailInfo> completeDetailInfos = new LinkedList<>();
        for(int i=0; i<completeDetails.size(); i++){
            Completedetail tmp = completeDetails.get(i);
            Medicine medicine = medicineRepository.findById(tmp.getMedicineId()).get();
            String name = medicine.getMedicineName();
            String unit = medicine.getUnit();
            float price = medicine.getPrice();
            String way = tmp.getWay();
            String frequency = tmp.getFrequency();
            int number = tmp.getNumber();
            String total = tmp.getTotal();
            int complete_detail_id = tmp.getCompleteDetailId();
            completeDetailInfos.add(new CompleteDetailInfo(complete_detail_id, name, unit, price, way, frequency, total, number));
            System.out.println("detail_id "+completeDetailInfos.get(0).getComplete_detail_id());
        }
        return completeDetailInfos;
    }

//    public void addCompleteDetail()

    public int addComplete(int paper_id, int doctor_id, String name, int status){
        Date dNow = new Date( );
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = ft.format(dNow);

        int book_id = registrationPaperRepository.findById(paper_id).get().getRegistrationBookId();

        Complete complete = new Complete(book_id, paper_id, doctor_id, name, time, status);
        completeRepository.save(complete);

        return complete.getCompleteId();
    }

    public int addCompleteDetail(int complete_id, String name, String frequency, String total, String way, int number){
        Medicine medicine = medicineRepository.findByMedicineName(name).get(0);
        int medicine_id = medicine.getMedicineId();

        Completedetail completeDetail = new Completedetail(complete_id, medicine_id, way, total, frequency, number, 175);
        completedetailRepository.save(completeDetail);
        int id = completeDetail.getCompleteDetailId();
        return id;
    }

    public void destroyComplete(int id){
        completedetailRepository.deleteByCompleteId(id);
        completeRepository.deleteById(id);
    }

    public void destroyMedicine(int id){
        completedetailRepository.deleteByCompleteDetailId(id);
    }

    public List<Medicine> getMedicine(){
        List<Medicine> medicines = MyMethod.copyIterator(medicineRepository.findAll());
        return medicines;
    }

    public void confirmComplete(int complete_id){
        Complete complete = completeRepository.findById(complete_id).get();
        complete.setStatus(176);
        List<Completedetail> completedetails = completedetailRepository.findByCompleteId(complete_id);
        for(int i=0; i<completedetails.size(); i++){
            Completedetail tmp = completedetails.get(i);
              tmp.setStatus(176);
        }
    }

    public List<Completemodel> getmodel(int id){
        List<Completemodel> completemodels = MyMethod.copyIterator(completeModelRepository.findAll());
        return completemodels;
    }

    public List<CompleteDetailInfo> getCompleteModelDetail(int id){
        List<Completemodeldetail> completemodeldetails = completeModelDetailRepository.findByCompleteModelId(id);
        List<CompleteDetailInfo> completeDetailInfos = new LinkedList<>();
        for(int i=0; i<completemodeldetails.size(); i++){
            Completemodeldetail tmp = completemodeldetails.get(i);
            Medicine medicine = medicineRepository.findById(tmp.getMedicineId()).get();
            String name = medicine.getMedicineName();
            String unit = medicine.getUnit();
            float price = medicine.getPrice();
            String way = tmp.getWay();
            String frequency = tmp.getFrequency();
            int number = tmp.getNumber();
            String total = tmp.getTotal();

            CompleteDetailInfo completeDetailInfo = new CompleteDetailInfo(name, unit, price, way, frequency, total, number);
            completeDetailInfos.add(new CompleteDetailInfo(name, unit, price, way, frequency, total, number));
            System.out.println("number: "+completeDetailInfo.getNumber());
        }
        return completeDetailInfos;
    }

    public void useModel(int id_model, int id_complete){
        List<Completemodeldetail> completemodeldetails = completeModelDetailRepository.findByCompleteModelId(id_model);
        for(int i=0; i<completemodeldetails.size(); i++){
            Completemodeldetail tmp = completemodeldetails.get(i);
            int medicine_id = tmp.getMedicineId();

            String way = tmp.getWay();
            String frequency = tmp.getFrequency();
            int number = tmp.getNumber();
            String total = tmp.getTotal();

            Completedetail completedetail = new Completedetail(id_complete, medicine_id, way, total, frequency, number, 175);
            completedetailRepository.save(completedetail);
        }
    }
}
