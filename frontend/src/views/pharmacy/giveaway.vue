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
        <el-col :span=7>
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
    ref="multipleTable"
    :data="tableData1"
    tooltip-effect="dark"
    style="width: 100%"
    height="270"
    @selection-change="handleSelectionChange">
     <el-table-column
      type="selection"
      width="55">
    </el-table-column>
    <el-table-column
      fixed
      prop="paper_id"
      label="挂号编码"
      width="200">
    </el-table-column>
    <el-table-column
      fixed
      prop="detail_id"
      label="项目编码"
      width="200">
    </el-table-column>
    <el-table-column
      prop="medicine_name"
      label="项目名称"
      width="200">
    </el-table-column>  
    <el-table-column
      prop="money"
      label="单价"
      width="200">
    </el-table-column>
    <el-table-column
      prop="number"
      label="数量"
      width="200">
    </el-table-column>
     <el-table-column
      prop="time"
      label="开立时间"
      width="200">
    </el-table-column>
    <el-table-column
      prop="status"
      label="状态"
      width="120">
    </el-table-column>

  </el-table>

</div>
     <el-col :span=7>
            <el-button type="primary" @click="giveawayMedicine">发药</el-button>
        </el-col>
  

</div>
</template>

<script>
import {search as searchApi} from "../../api/pharmacy"
import {giveaway as giveawayApi} from "../../api/pharmacy"
  export default {
    data() {
      return {
        form: {
          registration_book_id: '',
          name: '',
          id_number: ''
        },
        tableData1: []
      }
    },
    tableData: [],
    formLabelWidth: '120px',
    selections: [],


    methods: {
      onSubmit() {
        console.log('submit!');
      },
      search(){
      console.log("search");
      this.tableData1=[];
      this.selections=[];
      searchApi({
        book_id:this.form.registration_book_id 
      })
      .then(res=>{        
          var i = 0;
          var c;
          this.form.name='';
          this.form.id_number='';
          this.tableData1=[];
          console.log(res);
          this.form.name = res[0].name;
          this.form.id_number = res[0].id_number;
          
          for(i=0; i<res.length; i++){
              var a = {detail_id:res[i].detail_id, paper_id:res[i].paper_id, medicine_name:res[i].medicine_name,
                        money:res[i].price, number:res[i].number, time:res[i].time, status:res[i].status}

              this.tableData1.push(a);
              
          }
          // this.tableData1=[];
          console.log("tableData"+this.tableData1);

      })
      .catch(res => {
            this.$message("请检查病历号是否正确");
            console.log("error");
        });
      },
      handleSelectionChange(val){
        this.selections=val;
      },
      giveawayMedicine(){
        this.tableData1=[];
        giveawayApi({
            medicineList:JSON.stringify(this.selections),
            operator_id:getToken().split(" ")[0],
        })
        .then(res=>{
            this.search();
        })
        console.log("fff"+this.tableData1);
      }


    }
  }
</script>


 </template>
 