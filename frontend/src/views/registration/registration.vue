<template>
    <div>
        
    <el-form ref="form" :model="form" label-width="90px">
        <el-row>
        <el-col :span=7>
            <el-form-item label="发票号">
                <el-input v-model="form.invoice_id" :disabled="true"></el-input>
            </el-form-item>
        </el-col>
        <el-col :span=2>.</el-col>
        <el-col :span=3>
             <el-button type="primary" @click="onFast">快速填写</el-button>
        </el-col>
        </el-row>

      <el-row>
      <el-col :span=7>
          <el-form-item label="病历号">
            <el-input v-model="form.registration_book_id"></el-input>
          </el-form-item>
      </el-col>

      <el-col :span=7>
          <el-form-item label="姓名">
              <el-input v-model="form.name"></el-input>
        </el-form-item>
      </el-col>
      <el-col :span=7>
          <el-form-item label="性别">
                <el-select v-model="form.gender" placeholder="选择性别">
                <el-option label="男" value="71"></el-option>
                <el-option label="女" value="72"></el-option>
                </el-select>
         </el-form-item>
      </el-col>
      </el-row>
      
  
  <el-row>
  <el-form-item label="出生日期">
    <el-col :span=7>
      <el-date-picker type="date" placeholder="出生日期" v-model="form.birth" value-format=" yyyy-MM-dd" style="width: 100%;"></el-date-picker>
    </el-col>
    <el-col :span=13>
        <el-form-item label="身份证号"> 
        <el-input v-model="form.id_number" placeholder="身份证号"></el-input>
        </el-form-item>
    </el-col>
</el-form-item>
  </el-row>



        <el-row>
        <el-col :span=19>
            <el-form-item label="家庭住址">
                <el-input v-model="form.address"></el-input>
            </el-form-item>
        </el-col>
        </el-row>

        <el-row>
            <el-col :span=7>
                <el-form-item label="结算类别">
                <el-select v-model="form.settlement_type_id" placeholder="结算类别">
                <el-option label="自费" value="1"></el-option>
                <el-option label="医保" value="2"></el-option>
                </el-select>
                </el-form-item>
            </el-col>
            <el-col :span=7>
                 <el-form-item label="号别">
                <el-select v-model="form.doctor_type" placeholder="号别" @change="doctorTriggerLevel(form.doctor_type)">
                <el-option label="普通号" value="1"></el-option>
                <el-option label="专家号" value="2"></el-option>
                </el-select>
                </el-form-item>
            </el-col>
        </el-row>

        <el-row>
            <el-col :span=7>
                <el-form-item label="看诊医生">
                <el-select v-model="form.doctor" placeholder="医生">
                <el-option
                    v-for="doc in docs"
                    :key="doc.label"
                    :label="doc.label"
                    :value="doc.value">
                 </el-option>
                </el-select>
                </el-form-item>
             </el-col>
             <el-col :span=7>
                 <el-form-item label="挂号科室">
                <el-select v-model="form.department" placeholder="科室" @change="doctorTriggerDepartment(form.department)">
                  <el-option
                    v-for="item in options"
                    :key="item.label"
                    :label="item.label"
                    :value="item.value">
                    </el-option>
                </el-select>
                </el-form-item>
             </el-col>

        </el-row>
        <el-row>
            <el-col :span=7>
                <el-form-item label="需要病历本">
                    <el-switch v-model="form.request_book"></el-switch>
                </el-form-item>
            </el-col>
            
        </el-row>
        <el-row>
        <el-col :span=7>
            <el-form-item label="金额">
                <el-input v-model="form.total" :disabled="true"></el-input>
            </el-form-item>
        </el-col>
        <el-col :span=7>
          <el-form-item label="挂号单号">
            <el-input v-model="form.registration_paper_id" :disabled="true"></el-input>
          </el-form-item>
        </el-col>

        </el-row>


  <el-form-item>
    <el-button type="primary" @click="generate">生成挂号单</el-button>
    <el-button type="primary" @click="confirm">刷新</el-button>
  </el-form-item>
</el-form>
    </div>
</template>

<script>
import { getBasicInfo as basicInfoApi } from "../../api/registration";
import { getDepartmentList as departmentListApi} from "../../api/registration";
import { getDoctor as doctorApi} from "../../api/registration";
import { submit as generateApi} from "../../api/registration";
import {getToken} from '../../utils/dataStorage'

  export default {
    data() {
      return {
        form: {
          gender: '',
          invoice_id: '',
          registration_book_id: '',
          name: '',
          id_number: '',
          age: '',
          doctor_type: '',
          settlement_type_id: '',
          morning_afternoon: '',
          birth: '',
          date2: '',
          department: '',
          doctor: '',
          request_book: false,
          address: '',
          registration_paper_id:'',
          total:''
        },
        docs: [],
        options: [],
        confirmDisable: true
      };
    },
    methods: {
      doctorTriggerLevel(id){
        console.log("doctorTriggerLevel");
        this.form.doctor="";
        if(!(this.form.department=="")){
          doctorApi({
            department_id: this.form.department,
            registration_level_id: this.form.doctor_type
          })
          .then(res=>{
            var i=0;
            var b=[];
            for(i=0; i<res.length; i++){
              b[i]={value:res[i].doctor_id, label:res[i].realname};
            }
            this.docs=b;
          })
        }
      },
      doctorTriggerDepartment(id){
        console.log("doctorTriggerDepartment");
        if(!(this.form.doctor_type=="")){
          doctorApi({
            department_id: this.form.department,
            registration_level_id: this.form.doctor_type
          })
          .then(res=>{
            var i=0;
            var b=[];
            for(i=0; i<res.length; i++){
              b[i]={value:res[i].doctor_id, label:res[i].realname};
            }
            this.docs=b;
          })
        }
      },
      onFast() {
        console.log("onfast");
        basicInfoApi({
          id: this.form.registration_book_id
        })
        .then(res =>{
          this.form.name = '';
          this.form.id_number = '';
          this.form.birth = '';
          this.form.gender = '';
          this.form.age = '';
          this.form.date2 = '';
          this.form.settlement_type_id = '';
          this.form.department = '';
          this.form.doctor = '';
          this.form.doctor_type = '';
          this.form.address = '';
          this.form.total = '';
          this.form.registration_paper_id = '';
          this.form.registration_level_id = '';
          this.form.invoice_id = '';
          this.form.morning_afternoon = '';

          this.form.name = res[0].name;
          this.form.id_number = res[0].registration_book_id_number;
          this.form.birth = res[0].birth;
          if(res[0].gender == 71){this.form.gender = '男';}
          else if(res[0].gender == 72){this.form.gender = '女';}
        })
        .catch(res => {
            this.$message("请检查病历号是否正确");
            console.log("error");
        });
        console.log('submit!');

      },
      generate() {
         console.log("generate");
         console.log(this.form.birth)
        //  if((this.form.gender!="") && (this.form.name!="") && (this.form.id_number!="") && (this.form.age!="") && 
        //  (this.form.doctor_type!="") && (this.form.settlement_type_id!="") && (this.form.morning_afternoon!="") && (this.form.birth!="") && 
        //  (this.form.date2!="") && (this.form.department!="") && (this.form.doctor!="") && (this.form.address!=""))
        if((this.form.gender!="") && (this.form.name!="") && (this.form.id_number!="") && 
         (this.form.doctor_type!="") && (this.form.settlement_type_id!="") && (this.form.birth!="") && 
          (this.form.department!="") && (this.form.doctor!="") && (this.form.address!=""))
         {
            console.log("generateApi");
            var need_book;
            if(this.form.request_book){
              need_book=1;
            }
            else{
              need_book=0;
            }
            generateApi({
              id_number: this.form.id_number,
              name: this.form.name,
              gender: this.form.gender,
              birth: this.form.birth,
              age: this.form.age,
              address: this.form.address,
              morning_afternoon: this.form.morning_afternoon,
              doctor_id: this.form.doctor,
              settlement_type_id: this.form.settlement_type_id,
              request_book: need_book,
              operator_id: getToken().split(" ")[0],
            })
            .then(res=>{
                console.log(res[0]);
                this.form.total=res[0].fund;
                this.form.registration_paper_id=res[0].paper_id;
                this.form.invoice_id=res[0].invoice_id;
                this.form.registration_book_id=res[0].book_id;
                // confirmDisable=false;
            })
         } 
         else{
           this.$message("请将信息填写完整");
         }
        
      }, 
      confirm(){
          this.form.registration_book_id = '';
          this.form.name = '';
          this.form.id_number = '';
          this.form.birth = '';
          this.form.gender = '';
          this.form.age = '';
          this.form.date2 = '';
          this.form.settlement_type_id = '';
          this.form.department = '';
          this.form.doctor = '';
          this.form.doctor_type = '';
          this.form.address = '';
          this.form.total = '';
          this.form.registration_paper_id = '';
          this.form.registration_level_id = '';
          this.form.invoice_id = '';
          this.form.morning_afternoon = '';
      },
      loadDepartment(){
        console.log("loadDepartment");
        console.log(res[0].label)
      },
     
      },
      mounted: function(){
        departmentListApi({

        })
        .then(res=>{
          var i=0;
          var b=[];
          var c=getToken();
          console.log("c: "+c);
          for(i=0; i<res.length; i++){
           
            b[i]={value:res[i].department_id, label:res[i].department_name};

            console.log(b[i]);
           
          }
        
          this.options=b;
          
          
        })
        
        
      }

      
  }
</script>
