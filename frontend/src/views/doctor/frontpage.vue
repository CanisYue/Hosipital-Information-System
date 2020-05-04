<template>
<div>

<el-container>
  <!-- <el-header></el-header> -->
  <el-container>
    
    <el-aside width="250px">
        <el-row>   
        未诊患者
        </el-row>
    <el-table
    :data="tableData_uncheck"
    height="600"
    
    :row-style="{height:'20px'}"
    :cell-style="{padding:'0px'}"
    >
    <el-table-column
      prop="paper_id"
      label="挂号单号"
      width="80">
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
     <el-row>   
        已诊患者
    </el-row>
    <el-table
    :data="tableData_check"
    height="400"
    
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
        <div>
  <el-form ref="form" :model="form" label-width="80px" >
    <el-row>
      <el-form-item label="姓名">
        <el-col :span= 3>
          <el-input v-model="form.up_name" :disabled="true"></el-input>  
        </el-col>
      </el-form-item>
      <el-form-item label="挂号单号">
        <el-col :span=3>
          <el-input v-model="form.up_paper_id" :disabled="true"></el-input>
        </el-col>
      </el-form-item>
    </el-row>
  <el-form-item label="主诉">
    <el-input v-model="form.main_problem"></el-input>
  </el-form-item>
  <el-form-item label="现病史">
    <el-input type="textarea" v-model="form.disease_for_now"></el-input>
  </el-form-item>
  <el-form-item label="现病治疗情况">
    <el-input type="textarea" v-model="form.treatment_for_now"></el-input>
  </el-form-item>
  <el-form-item label="既往史">
    <el-input type="textarea" v-model="form.disease_for_past"></el-input>
  </el-form-item>
  <el-form-item label="过敏史">
    <el-input type="textarea" v-model="form.allergic_history"></el-input>
  </el-form-item>
  <el-form-item label="体格检查">
    <el-input type="textarea" v-model="form.body_check"></el-input>
  </el-form-item>
  <el-form-item>
 
  </el-form-item>
  <el-form-item>
    <el-button type="primary" @click="onSubmit">立即创建</el-button>
    <el-button>取消</el-button>
  </el-form-item>
</el-form>
  <el-row>
    <el-col :span=4>
      <el-button type="primary" @click="add">增加诊断</el-button>
     </el-col>
     <el-col :span=9>
      
      <el-autocomplete
      class="inline-input"
      v-model="state1"
      :fetch-suggestions="querySearch"
      placeholder="请输入内容"
      @select="handleSelect"
    ></el-autocomplete>


     </el-col>
     <el-col :span=7>
      <el-date-picker type="date" placeholder="发病日期" v-model="ill_time" style="width: 100%;"
      value-format=" yyyy-MM-dd"></el-date-picker>
    </el-col>
  </el-row>
    

    <el-table
    :data="tableData_estimate"
    style="width: 100%"
    height="250">
    <el-table-column label="评估/诊断">
    <!-- <el-table-column
      fixed
      prop="ICD"
      label="ICD编码"
      width="80">
    </el-table-column> -->
    <el-table-column
      prop="check_disease"
      label="疾病名称"
      width="300">
    </el-table-column>  
    <el-table-column
      prop="ill_date"
      label="发病时间"
      width="300">
    </el-table-column>
    <el-table-column
      fixed="right"
      label="操作"
      width="120">
      <template slot-scope="scope">
        <el-button
          @click.native.prevent="deleteRow(scope.$index, tableData_estimate)"
          type="text"
          size="small">
          移除
        </el-button>
      </template>
    </el-table-column>

     </el-table-column>
  </el-table>
  
        </div>
          
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






</div>
</template>


<style>
  .el-header, .el-footer {
    background-color: #B3C0D1;
    color: #333;
    text-align: center;
    line-height: 40px;
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
import {loadCheck as loadApi} from "../../api/frontpage";
import {unCheck as uncheckApi} from "../../api/frontpage";
// import {addDisease as addDiseaseApi} from "../../api/frontpage";
import {getAllDiseases as DiseaseApi} from "../../api/frontpage";
import {submitFrontpage as frontpageApi} from "../../api/frontpage";
import {getToken} from '../../utils/dataStorage'
  export default {
    data() {
      return {
        form: {
          main_problem: '',
          disease_for_now: '',
          treatment_for_now: '',
          disease_for_past: '',
          allergic_history: '',
          body_check: '',
          up_name: '',
          up_paper_id: '',
        },
        tableData_check: [],
        tableData_uncheck: [],
        tableData_estimate: [],
        disease_name: '',
        pointer: 1,
        diseases: [],
        state1: '',
        ill_time: '',
        tmp_ICD: '',
      }
    },
    methods: {
       querySearch(queryString, cb) {
        var diseases = this.diseases;
        var results = queryString ? diseases.filter(this.createFilter(queryString)) : diseases;
        // 调用 callback 返回建议列表的数据
        cb(results);
      },
      createFilter(queryString) {
        return (disease) => {
          return (disease.value.toLowerCase().indexOf(queryString.toLowerCase()) === 0);
        };
      },
      handleSelect(item) {
        console.log(item);
      },
     
      handleClick(val){
          this.form.up_paper_id=val.paper_id;
          this.form.up_name=val.name;
          this.form.main_problem='';
          this.form.disease_for_now='';
          this.form.treatment_for_now='';
          this.form.allergic_history='';
          this.form.disease_for_past='';
          this.form.body_check='';
          this.tableData_estimate=[];

          
      },

      deleteRow(index, rows) {
        rows.splice(index, 1);  
      },
      add(){
        console.log("add");
        console.log(this.ill_time);
        if(this.state1=='' || this.ill_time==''){
          this.$message("请将诊断信息填写完整");
        }
        else{
          this.tableData_estimate.push({check_disease:this.state1, ill_date:this.ill_time})
        }
        // this.tableData_estimate

      },
      onSubmit() {
        console.log('submit!');
        console.log(this.form.up_paper_id);
        console.log(this.form.main_problem);
        console.log(this.form.body_check);


        var length = 0;
        for(var a in this.tableData_estimate){
          length ++;
        }
        if(this.form.up_paper_id!="" && this.form.main_problem!="" && 
        this.form.disease_for_now!="" && this.form.treatment_for_now!="" && this.form.disease_for_past!="" && 
        this.form.allergic_history!="" && this.form.body_check!="" && length!=0){
          frontpageApi({
            in_paper_id: this.form.up_paper_id,
            main_problem: this.form.main_problem,
            disease_for_now: this.form.disease_for_now,
            treatment_for_now: this.form.treatment_for_now,
            disease_for_past: this.form.disease_for_past,
            allergic_history: this.form.allergic_history,
            body_check: this.form.body_check,
            result_estimate: JSON.stringify(this.tableData_estimate)

        })
        .then(res=>{
          console.log("res");
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
            this.tableData_uncheck=b;
            
            
          }),
        uncheckApi({
          doctor: getToken().split(" ")[0]
        })
        .then(res=>{
            var i=0;
            var b=[];
            for(i=0; i<res.length; i++){
              
              b[i]={paper_id:res[i].paper_id, name:res[i].name};
              console.log(b[i]);
            }
            this.tableData_check=b;
        })
        })}
      else{
        this.$message("请将信息填写完整");
      }

      },
    },
    mounted: function(){
      loadApi({
          doctor: getToken().split(" ")[0]
        })
        .then(res=>{
          console.log("Token: "+getToken().split(" ")[0])
          var i=0;
          var b=[];
          for(i=0; i<res.length; i++){
            
            b[i]={paper_id:res[i].paper_id, name:res[i].name};
            console.log(b[i]);
          }
          this.tableData_uncheck=b;
          
          
        }),
      uncheckApi({
        doctor: getToken().split(" ")[0]
      })
       .then(res=>{
          var i=0;
          var b=[];
          for(i=0; i<res.length; i++){
            
            b[i]={paper_id:res[i].paper_id, name:res[i].name};
            console.log(b[i]);
          }
          this.tableData_check=b;
       }),
      DiseaseApi({

      })
      .then(res=>{
         var i=0;
          var b=[];
          for(i=0; i<res.length; i++){
           
            b[i]={"value":res[i].diseaseName};

            // console.log(b[i]);
           
          }
        
          this.diseases=b;
      })
    }
  }
</script>