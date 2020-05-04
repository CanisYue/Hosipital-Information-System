<template>
<div>

<el-container>
  
  <el-container>
    <el-aside width="250px">
        <el-row>   
        已诊患者
        </el-row>
    <el-table
    :data="table_patient"
    height="600"
    
    :row-style="{height:'20px'}"
    :cell-style="{padding:'0px'}"
    >
    <el-table-column
      prop="paper_id"
      label="挂号单号"
      width="100">
    </el-table-column>
    <el-table-column
      prop="name"
      label="姓名"
      width="50"
      >
    </el-table-column>
    <el-table-column
    fixed="right"
      label="操作"
      width="100">
      <template slot-scope="scope">
        <el-button @click="handleClick(scope.row)" type="primary" size="small">门诊病历</el-button>
      </template>
    </el-table-column>
  </el-table>
    </el-aside>
    <el-container>
      <el-main>
        <el-container>
           <!-- <el-form ref="form" :model="form" label-width="80px" > -->
             <el-form label-width="80px" >
        <el-row>
      <el-form-item label="姓名">
        <el-col>
          <el-input v-model="up_name" :disabled="true"></el-input>  
        </el-col>
      </el-form-item>
      <el-form-item label="挂号单号">
        <el-col>
          <el-input v-model="up_paper_id" :disabled="true"></el-input>
        </el-col>
      </el-form-item>
      </el-row>
      </el-form>
      
        <el-col :span=9>
        <el-button type="primary" @click="create_complete">增方</el-button>
        </el-col>
        <el-col :span=9>
        <el-button type="text"> </el-button>
        </el-col>
        <el-col :span=9>
        <el-button type="text"> </el-button>
        </el-col>
        <el-col :span=9>
        <el-button type="text"> </el-button>
        </el-col>
        
        </el-container>
        <div>
        <el-container>
        <el-table
            :data="table_complete"
            style="width: 100%"
            height="250"
            :border=true>
            <el-table-column
            fixed
            prop="complete_name"
            label="处方名称"
            width="100">
            </el-table-column>
            <el-table-column
            fixed
            prop="complete_status"
            label="状态"
            width="100">
            </el-table-column> 
            <el-table-column
            fixed
            prop="complete_id"
            label="处方编码"
            width="100">
            </el-table-column>
             <el-table-column
      fixed right
      label="操作"
      width="100">
      <template slot-scope="scope">
        <el-row>
        <el-col :span=15>
        <el-button @click="seeComplete(scope.row)" type="text" size="small">查看</el-button>
        </el-col>
        <el-col :span=15>
        <el-button type="text" size="small"  @click="editComplete(scope.row)">加药</el-button>
        </el-col>
        </el-row>
        <el-row>
        <el-col :span=15>
        <el-button type="text" size="small" @click="confirmComplete(scope.row)">开立</el-button>
        </el-col>
        <el-col :span=15>
        <el-button type="text" size="small" @click.native.prevent="deleteRow(scope.row, scope.$index, table_complete)">删除</el-button>
        </el-col>
        </el-row>
      </template>
    </el-table-column>
        </el-table>

        <el-table
            :data="table_model"
            :border=true
            style="width: 100%"
            height="250">
            <el-table-column
            fixed
            prop="model_name"
            label="模板名称"
            width="200">
            </el-table-column>
            <el-table-column
            fixed
            prop="model_id"
            label="模板编号"
            width="200">
            </el-table-column>
            <el-table-column
              fixed="right"
                label="操作"
                width="100">
           <template slot-scope="scope">
           <el-button @click="seeModel(scope.row)"  type="text" size="small">查看</el-button>
           <el-button @click="chooseModel(scope.row)"  type="text" size="small">选择</el-button>
          </template>
    </el-table-column>
        </el-table>
        </el-container>
 

    </div>
    <el-table
    :data="table_medicine"
    style="width: 100%"
    height="250">
    <el-table-column
      fixed
      prop="medicine"
      label="药品名称"
      width="180">
    </el-table-column>
    <el-table-column
      prop="unit"
      label="药品规格"
      width="160">
    </el-table-column>  
    <el-table-column
      prop="unit_price"
      label="单价"
      width="70">
    </el-table-column>
    <el-table-column
      prop="way"
      label="用法"
      width="70">
    </el-table-column>
    <el-table-column
      prop="total"
      label="用量"
      width="70">
    </el-table-column>
    <el-table-column
      prop="frequency"
      label="频次"
      width="90">
    </el-table-column>
    <el-table-column
      prop="number"
      label="数量"
      width="60">
    </el-table-column>
    <el-table-column
      prop="detail_id"
      label="明细编码"
      width="60">
    </el-table-column>
    <el-table-column
        fixed="right"
          label="操作"
          width="40">
      <template slot-scope="scope">
      <el-button @click.native.prevent="deleteMedicine(scope.row, scope.$index, table_medicine)"
                  type="text" size="small">删药</el-button>
    </template>
    </el-table-column>
  </el-table>
      </el-main>     
    </el-container>
  </el-container>
</el-container>


<el-container>
  <el-aside width="250px">

   

  </el-aside>
  <el-container>
   
   
  </el-container>
</el-container>

<div>
<el-dialog title="增加处方" :visible.sync="dialogFormVisible">
  <!-- <el-form :model="form"> -->
    <el-form>
    <el-col :span=10>
    <el-form-item label="处方名称">
    <el-input v-model="complete_name" autocomplete="off"></el-input>
    </el-form-item>
    </el-col> 
  </el-form>


  <div slot="footer" class="dialog-footer">
    <el-button @click="dialogFormVisible = false">取 消</el-button>
    <el-button type="primary" @click="confirm_name">确 定</el-button>
  </div>
</el-dialog>
</div>

<div>
<el-dialog title="增药" :visible.sync="dialogFormMedicineVisible">
  <!-- <el-form :model="form"> -->
    <el-form>
    <el-row>
    <el-col :span=10>
    <el-form-item label="处方id">
    <el-input v-model="complete_id" autocomplete="off"></el-input>
    </el-form-item>
    </el-col> 
    <el-col :span=10>
       <!-- <el-input v-model="disease_name" placeholder="请输入疾病名称"></el-input> -->
       <el-form-item label="药品名称">
      <el-autocomplete
      class="inline-input"
      v-model="medicine_name"
      :fetch-suggestions="querySearch"
      placeholder="请输入内容"
      @select="handleSelect"
    ></el-autocomplete>
    </el-form-item>
     </el-col>
    </el-row>
    <el-row>
    <el-col :span=10>
    <el-form-item label="药品用法">
    <el-input v-model="way" autocomplete="off"></el-input>
    </el-form-item>
    </el-col> 
    <el-col :span="10">
    <el-form-item label="用量">
    <el-input v-model="total" autocomplete="off"></el-input>
    </el-form-item>
    </el-col> 
    </el-row>
    <el-row>
    <el-col :span="10">
    <el-form-item label="频次">
    <el-input v-model="frequency" autocomplete="off"></el-input>
    </el-form-item>
    </el-col> 
    <el-col :span="10">
    <el-form-item label="数量">
    <el-input v-model="number" autocomplete="off"></el-input>
    </el-form-item>
    </el-col> 
    </el-row>
  </el-form>

  <div slot="footer" class="dialog-footer">
    <el-button @click="dialogFormMedicineVisible = false">取 消</el-button>
    <el-button type="primary" @click="confirm_medicine">确 定</el-button>
  </div>
</el-dialog>
</div>






</div>
</template>


<style>
  .el-header, .el-footer {
    background-color: #B3C0D1;
    color: #333;
    text-align: center;
    line-height: 10px;
  }
  
  .el-aside {
    background-color: #D3DCE6;
    color: #333;
    text-align: center;
    line-height: 40px;
  }
  
  .el-main {
    background-color: #E9EEF3;
    color: #333;
    text-align: center;
    line-height: 40px;
  }
  
  body > .el-container {
    margin-bottom: 40px;
  }
  
  .el-container:nth-child(5) .el-aside,
  .el-container:nth-child(6) .el-aside {
    line-height: 260px;
  }
  
  .el-container:nth-child(7) .el-aside {
    line-height: 320px;
  }
</style>

<script>
import {load as loadApi} from "../../api/complete";
import {addComplete as addCompleteApi} from "../../api/complete";
import {getComplete as getCompleteApi} from "../../api/complete";
import {addMedicine as addMedicineApi} from "../../api/complete";
import {destroyComplete as destroyCompleteApi} from "../../api/complete";
import {getCompleteDetail as getCompleteDetailApi} from "../../api/complete";
import {getMedicines as getMedicinesApi} from "../../api/complete";
import {confirmComplete as confirmCompleteApi} from "../../api/complete";
import {loadModel as loadModelApi} from "../../api/complete";
import {getModelDetail as getModelDetailApi} from "../../api/complete";
import {useModel as useModelApi} from "../../api/complete";
import {destroyMedicine as destroyMedicineApi} from "../../api/complete";
import {getToken} from '../../utils/dataStorage'
export default {
  data(){
    return{
      up_paper_id: '',
      up_name: '',
      dialogFormVisible: false,
      dialogFormMedicineVisible: false,
      table_patient: [],
      table_complete: [],
      table_medicine: [],
      table_model: [],
      table_model_detail: [],
      complete_name: '',
      medicine_name: '',
      way: '',
      total: '',
      number: '',
      frequency: '',
      complete_id: '',
      medicines: [],
      detail_id: '',
      up_complete_status: '',
      up_complete_id: ''
    }
  },
  methods: {
    querySearch(queryString, cb) {
      var medicines = this.medicines;
      var results = queryString ? medicines.filter(this.createFilter(queryString)) : medicines;
      // 调用 callback 返回建议列表的数据
      cb(results);
    },
    createFilter(queryString) {
      return (medicine) => {
        return (medicine.value.toLowerCase().indexOf(queryString.toLowerCase()) === 0);
      };
    },
    handleSelect(item) {
      console.log(item);
    },

    confirmComplete(val){
      if(val.complete_status=="开立"){
        this.$message("处方已开立，不可进行该操作");
      }
      else{
        confirmCompleteApi({
          complete_id:val.complete_id
        })
        .then(res=>{
          this.up_complete_status = "开立";
          getCompleteApi({
            paper_id: this.up_paper_id
          })
          .then(res=>{
            this.table_complete=[];
            var b = 0;
            var c;
            for(b=0; b<res.length; b++){
                var a = {complete_name:res[b].name, complete_id: res[b].id, complete_status:res[b].status}

                this.table_complete.push(a);
            }
          
          })
        })
      }
     
    },

    deleteRow(val, index, rows) {
        destroyCompleteApi({
          complete_id: val.complete_id
        })
        .then(res=>{

        })
        this.table_medicine=[];
        rows.splice(index, 1);  

    },
    handleClick(val){
          console.log("handle_click");
          this.up_paper_id=val.paper_id;
          this.up_name=val.name;
          this.table_medicine = [];
          getCompleteApi({
            paper_id: this.up_paper_id
          })
          .then(res=>{
            this.table_complete=[];
            var b = 0;
            var c;
            for(b=0; b<res.length; b++){
               var a = {complete_name:res[b].name, complete_id: res[b].id, complete_status:res[b].status}

               this.table_complete.push(a);
            }
         
          })
      },

      deleteMedicine(val, index, rows){
        console.log("处方状态 "+this.up_complete_status);
        if(this.up_complete_status=="开立"){
          this.$message("处方已开立，不能进行该操作");
        }
        else{
          destroyMedicineApi({
            complete_detail_id: val.detail_id
          })
          .then(res=>{
              rows.splice(index, 1);  
          })
        }
      },

      editComplete(val){
        if(val.complete_status=="开立"){
          this.$message("处方已开立，不可进行该操作");
        }
        else{
          this.complete_id = val.complete_id;
          this.dialogFormMedicineVisible = true;
        }
      },

      seeComplete(val){
        this.complete_id = val.complete_id;
        console.log("seeComplete");
        getCompleteDetailApi({
          complete_id: val.complete_id,
        })
        .then(res=>{
          var i=0;
          var b=[];
          console.log(res);
          for(i=0; i<res.length; i++){
            
            b[i]={medicine:res[i].name, unit:res[i].unit, unit_price:res[i].price, way:res[i].way, total:res[i].total, 
                    frequency:res[i].frequency, number:res[i].number, detail_id:res[i].complete_detail_id};
          }
          this.up_complete_id = val.complete_id;
          this.up_complete_status = val.complete_status;
          this.table_medicine = b;
          console.log("处方状态 "+val.complete_status);
        })
      },


      confirm_medicine(){
          console.log("confirm_medicine");
          addMedicineApi({
            medicine_name: this.medicine_name,
            frequency: this.frequency,
            total: this.total,
            way: this.way,
            number: this.number,
            paper_id: this.up_paper_id,
            complete_id: this.complete_id,
          })
          .then(res=>{
              this.dialogFormMedicineVisible = false
          })
      },

      create_complete(){
        if(this.up_name==""){
          this.$message("请先选择患者，点击门诊病历");
        }
        else{
          console.log('create_complete');
          this.dialogFormVisible = true;
          console.log(this.dialogFormVisible)
        }
      },
      confirm_name(){
        if(this.complete_name==""){
          this.$message("处方名不能为空");
        }
        else{
          this.dialogFormVisible = false;
          addCompleteApi({
            doctor_id: getToken().split(" ")[0],
            paper_id: this.up_paper_id,
            complete_name: this.complete_name,
            status: 175
          })
          .then(res=>{
            console.log(res);
            var a = {complete_name:this.complete_name, complete_id: res[0], complete_status:"暂存"}
            this.table_complete.push(a);
          })
        }
      },
      
      seeModel(val){
        console.log("seeModel");
        getModelDetailApi({
         model_id: val.model_id,
        })
        .then(res=>{
          var i=0;
          var b=[];
          for(i=0; i<res.length; i++){
            
            b[i]={medicine:res[i].name, unit:res[i].unit, unit_price:res[i].price, way:res[i].way, total:res[i].total, 
                    frequency:res[i].frequency, number:res[i].number};
            console.log(b[i]);
          }
          this.table_medicine = b;
        })
      },
      
      chooseModel(val){
        var tmp_complete_id;
        if(this.up_name==''){
          this.$message("请选择病人后再选择模板");
        }
        else{
          addCompleteApi({
            doctor_id: getToken().split(" ")[0],
            paper_id: this.up_paper_id,
            complete_name: val.model_name,
            status: 175
          })
          .then(res=>{
            console.log(res);
            tmp_complete_id=res[0];
            console.log(res[0]);
            var a = {complete_name:val.model_name, complete_id: res[0], complete_status:"暂存"}
            this.table_complete.push(a);
            useModelApi({
              model_id:val.model_id,
                complete_id:tmp_complete_id,
            })
            .then(res=>{

            })
          })
        }
        // console.log("tmp_id "+tmp_complete_id);
        // ,
        
      }
  },
   mounted: function(){
      loadApi({
          doctor: getToken().split(" ")[0]
        })
        .then(res=>{
          var i=0;
          var b=[];
          for(i=0; i<res.length; i++){
            
            b[i]={paper_id:res[i].paper_id, name:res[i].name};
            console.log(b[i]);
          }
          this.table_patient=b;
          
          
        }),

        getMedicinesApi({

        })
        .then(res=>{
          var i=0;
          var b=[];
          for(i=0; i<res.length; i++){
           
            b[i]={"value":res[i].medicineName};

            // console.log(b[i]);
           
          }
        
          this.medicines=b;
        }),

        loadModelApi({
          doctor_id: getToken().split(" ")[0]
        })
        .then(res=>{
          var i=0;
          for(i=0; i<res.length; i++){
            console.log(res);
            var a = {model_name:res[i].completeModelName, model_id:res[i].completeModelId}
            this.table_model.push(a);
          }
        })

   }
}
</script>
