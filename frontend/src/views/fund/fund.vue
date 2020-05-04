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
    :data="tableData"
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
     <el-col :span=7>
            <!-- <el-button type="primary">收费结算</el-button> -->
            <el-button type="primary" @click="funding">收费结算</el-button>
        </el-col>
  
</div>

 <div>

<!-- Form -->


<el-dialog title="发票" :visible.sync="dialogFormVisible">
  <el-form :model="form">
      <el-row>
      <el-col :span="10">
    <el-form-item label="发票号" :label-width="formLabelWidth">
      <el-input v-model="form.invoice_number" autocomplete="off" :disabled="true"></el-input>
    </el-form-item>
      </el-col>
   <el-col :span="10">
    <el-form-item label="病历号" :label-width="formLabelWidth">
    <el-input v-model="form.registration_book_id" autocomplete="off" :disabled="true"></el-input>
    </el-form-item>
    </el-col>
      </el-row> 

    <el-row>
    <el-col :span="10">
    <el-form-item label="患者姓名" :label-width="formLabelWidth">
    <el-input v-model="form.name" autocomplete="off"></el-input>
    </el-form-item>
    </el-col> 

    <el-col :span="10">
    <el-form-item label="支付方式" :label-width="formLabelWidth">
    <el-select v-model="form.payment_type" placeholder="选择支付方式">
        <el-option label="现金" value="cash"></el-option>
        <el-option label="银行卡" value="card"></el-option>
      </el-select>
    </el-form-item>
    </el-col> 
    </el-row>

    <el-row>
    <el-col :span="10">
    <el-form-item label="应收金额" :label-width="formLabelWidth">
    <el-input v-model="form.wished_payed" autocomplete="off" :disabled="true"></el-input>
    </el-form-item>
    </el-col> 

    <el-col :span="10">
    <el-form-item label="实收金额" :label-width="formLabelWidth">
    <el-input v-model="form.actrual_payed" autocomplete="off"></el-input>
    </el-form-item>
    </el-col> 
    </el-row>


    <el-col :span="10">
    <el-form-item label="找零" :label-width="formLabelWidth">
    <el-input v-model="form.charge" autocomplete="off" :disabled="true"></el-input>
    </el-form-item>
    </el-col> 

  </el-form>



  <div slot="footer" class="dialog-footer">
    <!-- <el-button @click="dialogFormVisible = false">取 消</el-button> -->
    <el-button @click="close">关闭</el-button>
    <el-button type="primary" @click="payBill">收费</el-button>
  </div>
</el-dialog>
 </div>
</div>


</template>

<script>
import {search as searchApi} from "../../api/fund"
import {fund as fundApi} from "../../api/fund"
import {getToken} from '../../utils/dataStorage'
  export default {
    data() {
      return {
        dialogTableVisible: false,
        dialogFormVisible: false,
        flag: 0,
        form: {
          registration_book_id: '',
          name: '',
          id_number: '',
          invoice_number: '',
          payment_type: '',
          wished_payed: '',
          actrual_payed: '',
          charge: '',

        },
        tableData: [],
        formLabelWidth: '120px',
        selections: [],
      }
    },
    methods: {
      onSubmit() {
        console.log('submit!');
      },
      search(){
          searchApi({
            book_id:this.form.registration_book_id 
          })
          .then(res=>{
              this.tableData=[];
              this.form.name='';
              this.form.id_number='';
              var i = 0;
              var c;
              console.log(res);
              this.form.name = res[0].name;
              this.form.id_number = res[0].id_number;

              for(i=0; i<res.length; i++){
                  var a = {detail_id:res[i].detail_id, paper_id:res[i].paper_id, medicine_name:res[i].medicine_name,
                            money:res[i].price, number:res[i].number, time:res[i].time, status:res[i].status}

                  this.tableData.push(a);
              }
              console.log("tableData"+this.tableData);
          })
           .catch(res => {
            this.$message("请检查病历号是否正确");
            console.log("error");
        });
      },
      handleSelectionChange(val){
        this.selections=val;
      },
      funding(){
        if(this.form.name==""){
          this.$message("请输入正确病历号");
        }
        else{
          console.log("funding");
          this.dialogFormVisible = true;
          var amount=0;
          var i=0;
          this.form.charge='';
          this.form.actrual_payed='';
          this.form.payment_type='';
          for(i=0; i<this.selections.length; i++){
            amount+=this.selections[i].money*this.selections[i].number;
          }
          this.form.wished_payed = amount;
        }
      },
      payBill(){
        console.log(this.selections);
        var tmp_charge = this.form.actrual_payed - this.form.wished_payed;
        if(tmp_charge>=0){
          if(this.form.payment_type==''){
            this.$message("请选择支付方式");
          }
          else{
            fundApi({
                fundingList:JSON.stringify(this.selections),
                operator_id:getToken().split(" ")[0],
                fund:this.form.wished_payed
            })
            .then(res=>{
                this.form.invoice_number = res[0];
                this.form.charge = this.form.actrual_payed - this.form.wished_payed;
                // this.search();
            })
          }
        }
        else{
          this.$message("实付金额小于应付金额");
        }
      },
      close(){
        this.dialogFormVisible = false;
        this.form.registration_book_id = '';
        this.form.name = '';
        this.form.id_number = '';
        this.tableData = [];
      }
    }
  }
</script>


 </template>
 