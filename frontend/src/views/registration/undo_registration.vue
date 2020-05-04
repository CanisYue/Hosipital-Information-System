<template>
<div>
    <el-form ref="form" :model="form" label-width="80px">
    <el-row :gutter="0">
        患者信息查询
        <el-row>.</el-row>
    </el-row>
    <el-row>
        <el-col :span=7>
            <el-form-item label="病历号">
                <el-input v-model="form.registration_book_id"></el-input>
            </el-form-item>
        </el-col>
        <el-col :span=3>
            <el-button type="primary" @click="search">查询</el-button>
        </el-col>
    </el-row>
    <div>
        <el-row>
            患者信息确认
        </el-row>
    </div>
    <el-row>
        <el-col :span=7>
        <el-form-item label="姓名">
            <el-input v-model="form.name" :disabled="true"></el-input>
        </el-form-item>
        </el-col>
        <el-col :span=10>
        <el-form-item label="身份证号">
            <el-input v-model="form.id_number" :disabled="true"></el-input>
        </el-form-item>
        </el-col>
    </el-row>
</el-form>
<div>
 <el-table
    :data="tableData"
    style="width: 100%"
    height="250">
    <el-table-column
      fixed
      prop="paper_id"
      label="挂号单号"
      width="200">
    </el-table-column>
    <el-table-column
      prop="morning_afternoon"
      label="挂号午别"
      width="200">
    </el-table-column>  
    <el-table-column
      prop="department"
      label="挂号科室"
      width="200">
    </el-table-column>
     <el-table-column
      prop="doctor"
      label="挂号医生"
      width="200">
    </el-table-column>
    <el-table-column
      prop="status"
      label="看诊状态"
      width="120">
    </el-table-column>
    <el-table-column
        fixed
        prop="date"
        label="挂号日期"
        width="200">
      </el-table-column>
   <el-table-column
      fixed="right"
      label="操作"
      width="100">
      <template slot-scope="scope">
        <el-button @click="undo(scope.row)" type="primary" size="small">退号</el-button>
      </template>
    </el-table-column>


  </el-table>

  
</div>
</div>
</template>

<script>
import { searchRecord as recordApi } from "../../api/undoRegistration";
import {undo as undoApi} from "../../api/undoRegistration";
  export default {
    data() {
      return {
        form: {
          registration_book_id: '',
          name: '',
          id_number: ''
        },
        tableData: []
      }
    },
    methods: {
      onSubmit() {
        console.log('submit!');
      },
      search(){
        console.log('search');
        console.log(this.form.registration_book_id);
        recordApi({
          book_id: this.form.registration_book_id
        })
      .then(res=>{
        console.log(res);
        this.form.name = '';
        this.form.id_number = '';
        this.tableData = [];

        this.form.name=res[0].name;
        this.form.id_number=res[0].id_number;
        var i=0;
        var b=[];

        for(i=0; i<res.length; i++){     
          b[i]={paper_id:res[i].paper_id, date:res[i].date, morning_afternoon:res[i].morning_afternoon,
             department:res[i].department, doctor:res[i].doctor, status:res[i].status};
         
          console.log(b[i]);
        }
        this.tableData=b;
      })
      .catch(res => {
            this.$message("请检查病历号是否正确");
            console.log("error");
        });
      },

      undo(val){
        if(val.status!="未消费"){
          this.$message("不满足退号条件，无法退号");
        }
        else{
          console.log("undo");
          console.log(val);
          undoApi({
              paper_id:val.paper_id
          })
          .then(res=>{
            val.status=res[0].status;
            console.log(res[0])
          })
        }
      }
    }
  }
</script>

