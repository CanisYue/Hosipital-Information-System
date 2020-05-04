<template>
    <div>
        <!-- Table -->
<el-button type="text" @click="dialogTableVisible = true">打开嵌套表格的 Dialog</el-button>

<el-dialog title="收货地址" :visible.sync="dialogTableVisible">
  <el-table :data="gridData">
    <el-table-column property="date" label="日期" width="150"></el-table-column>
    <el-table-column property="name" label="姓名" width="200"></el-table-column>
    <el-table-column property="address" label="地址"></el-table-column>
  </el-table>
</el-dialog>

<!-- Form -->
<el-button type="text" @click="dialogFormVisible = true">打开嵌套表单的 Dialog</el-button>

<el-dialog title="发票" :visible.sync="dialogFormVisible">
  <el-form :model="form">
      <el-row>
      <el-col span="10">
    <el-form-item label="发票号" :label-width="formLabelWidth">
      <el-input v-model="form.invoice_number" autocomplete="off"></el-input>
    </el-form-item>
      </el-col>
   <el-col span="10">
    <el-form-item label="病历号" :label-width="formLabelWidth">
    <el-input v-model="form.registration_book_id" autocomplete="off"></el-input>
    </el-form-item>
    </el-col>
      </el-row> 

    <el-row>
    <el-col span="10">
    <el-form-item label="患者姓名" :label-width="formLabelWidth">
    <el-input v-model="form.name" autocomplete="off"></el-input>
    </el-form-item>
    </el-col> 

    <el-col span="10">
    <el-form-item label="支付方式" :label-width="formLabelWidth">
    <el-select v-model="form.payment_type" placeholder="选择支付方式">
        <el-option label="现金" value="cash"></el-option>
        <el-option label="银行卡" value="card"></el-option>
      </el-select>
    </el-form-item>
    </el-col> 
    </el-row>

    <el-row>
    <el-col span="10">
    <el-form-item label="应收金额" :label-width="formLabelWidth">
    <el-input v-model="form.wished_payed" autocomplete="off"></el-input>
    </el-form-item>
    </el-col> 

    <el-col span="10">
    <el-form-item label="实收金额" :label-width="formLabelWidth">
    <el-input v-model="form.actrual_payed" autocomplete="off"></el-input>
    </el-form-item>
    </el-col> 
    </el-row>


    <el-col span="10">
    <el-form-item label="找零" :label-width="formLabelWidth">
    <el-input v-model="form.charge" autocomplete="off"></el-input>
    </el-form-item>
    </el-col> 

  </el-form>


  <div slot="footer" class="dialog-footer">
    <el-button @click="dialogFormVisible = false">取 消</el-button>
    <el-button type="primary" @click="dialogFormVisible = false">确 定</el-button>
  </div>
</el-dialog>

    </div>
</template>

<script>
  export default {
    data() {
      return {
        // gridData: [{
        //   date: '2016-05-02',
        //   name: '王小虎',
        //   address: '上海市普陀区金沙江路 1518 弄'
        // }, {
        //   date: '2016-05-04',
        //   name: '王小虎',
        //   address: '上海市普陀区金沙江路 1518 弄'
        // }, {
        //   date: '2016-05-01',
        //   name: '王小虎',
        //   address: '上海市普陀区金沙江路 1518 弄'
        // }, {
        //   date: '2016-05-03',
        //   name: '王小虎',
        //   address: '上海市普陀区金沙江路 1518 弄'
        // }],
        dialogTableVisible: false,
        dialogFormVisible: false,
        form: {
          invoice_number: '',
          registration_book_id: '',
          name: '',
          payment_type: '',
          wished_payed: '',
          actrual_payed: '',
          charge: ''
        },
        formLabelWidth: '120px'
      };
    }
  };
</script>