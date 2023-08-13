<template>
  <div>
  <el-table
      :data="tableData"
      :header-cell-style="{'text-align':'center'}"
      :cell-style="{'text-align':'center'}"
      border
      style="width: 100%; text-align: center">
    <el-table-column
        fixed
        prop="id"
        label="水果编号"
        width="150">
    </el-table-column>
    <el-table-column
        prop="name"
        label="水果名称"
        width="180">
    </el-table-column>
    <el-table-column
        prop="sale"
        label="水果销量"
        width="180">
    </el-table-column>
    <el-table-column
        prop="icon"
        label="水果图片"
        width="200">
      <template v-slot:default="scope">
            <img :src="scope.row.icon" style="height: 100px">
      </template>
    </el-table-column>
    <el-table-column
        fixed="right"
        label="操作"
        width="200">
      <template v-slot:default="scope">
<!--        <el-button type="warning" size="small" @click="dialogFormVisible = true">编辑</el-button>-->
        <el-button @click="findFruit(scope.row)" type="warning" size="small">编辑</el-button>
        <el-button @click="Delete(scope.row)" type="danger" size="small">删除</el-button> &nbsp
      </template>
    </el-table-column>
  </el-table>

<!--    //点击编辑之后可见弹出表单-->
<!--  <el-dialog title="编辑" :visible.sync="dialogFormVisible">-->
<!--&lt;!&ndash;    表单加入rules规则,每行加入prop属性&ndash;&gt;-->
<!--    <el-form :model="form" :rules="rules">-->

<!--      <el-form-item label="水果销量:" :label-width="formLabelWidth" prop="sale">-->
<!--        <el-input v-model="form.sale" autocomplete="off"></el-input>-->
<!--      </el-form-item>-->

<!--      <el-form-item label="水果图片链接:" :label-width="formLabelWidth" prop="icon">-->
<!--        <el-input v-model="form.icon" autocomplete="off"></el-input>-->
<!--      </el-form-item>-->

<!--    </el-form>-->
<!--    <div slot="footer" class="dialog-footer">-->
<!--      <el-button @click="dialogFormVisible = false">取 消</el-button>-->
<!--      <el-button type="primary" @click="dialogFormVisible = false;Edit()">确 定</el-button>-->
<!--    </div>-->
<!--  </el-dialog>-->
<!--&lt;!&ndash;    用一个div把table和dialog框起来&ndash;&gt;-->
  </div>

</template>

<script>
export default {
  methods: {
    //删除方法
    Delete(row) {
      let _this = this
      this.$confirm('此操作将删除'+ row.name +',是否继续?', '提示', {
       cancelButtonText: '取消',
        confirmButtonText: '确定',
        type: 'warning'
      }).then(() => {
        // this.$message({
        //   type: 'success',
        //   message: '删除成功!'

      axios.delete('http://localhost:8888/fruit/delete/'+row.id).then(function (response) {
        if (response.data){
          _this.$alert("删除"+row.name+"成功!",'消息',{
            confirmButtonText: '确定',
            type: 'message',
            callback:action => {
              //点击确定之后重新刷新页面
              location.reload()
            }
          })

        }
        });
      }).catch(() => {
        // 代码结构，这里就不用_this
        this.$message({
          type: 'info',
          message: '已取消删除'
        });
      });

      // console.log(row);
      // alert(row.id)
    },

    findFruit(row){
      // 点击事件中使用导航到另一个页面
      this.$router.push('/edit?id='+row.id)
    }

    // //从后端得到弹出的表单数据
    // Edit(){  let _this = this
    //   this.$confirm('此操作将修改数据，是否继续?', '提示', {
    //     cancelButtonText: '取消',
    //     confirmButtonText: '确定',
    //     type: 'warning'
    //   }).then(() => {
    //     axios.delete('http://localhost:8888/fruit/delete/'+row.id).then(function (response) {
    //       if (response.data){
    //         _this.$alert("删除"+row.name+"成功!",'消息',{
    //           confirmButtonText: '确定',
    //           type: 'message',
    //           callback:action => {
    //             //点击确定之后重新刷新页面
    //             location.reload()
    //           }
    //         })
    //
    //       }
    //     });
    //   }).catch(() => {
    //     // 代码结构，这里就不用_this
    //     this.$message({
    //       type: 'info',
    //       message: '已取消编辑'
    //     });
    //   });
    // }


  },

  // 得到后端数据
  created() {
    let _this=this
    //从后端得到表格数据
    axios.get('http://localhost:8888/fruit/queryAll').then(function (response) {
      console.log(response)
       _this.tableData=response.data
    })
    // axios.get('http://localhost:8888/fruit/queryById/'+row.id).then(function (response2){
    //   console.log(response2)
    //   _this.form=response2.data
    // })
  },

  data() {
    return {
      tableData: [{
        date: '2016-05-02',
        name: '王小虎',
        province: '上海',
        city: '普陀区',
        address: '上海市普陀区金沙江路 1518 弄',
        zip: 200333
      }, {
        date: '2016-05-04',
        name: '王小虎',
        province: '上海',
        city: '普陀区',
        address: '上海市普陀区金沙江路 1517 弄',
        zip: 200333
      }, {
        date: '2016-05-01',
        name: '王小虎',
        province: '上海',
        city: '普陀区',
        address: '上海市普陀区金沙江路 1519 弄',
        zip: 200333
      }, {
        date: '2016-05-03',
        name: '王小虎',
        province: '上海',
        city: '普陀区',
        address: '上海市普陀区金沙江路 1516 弄',
        zip: 200333
      }],


      //弹出表单
      // dialogFormVisible: false,
      // form: {
      //   sale: '',
      //   icon: '',
      // },
      // rules:{
      //   sale:[{required: true, message: '请输入水果销量', trigger: 'blur'}],
      //   icon:[{required: true, message: '请输入水果图片链接', trigger: 'blur'}],
      // },
      // formLabelWidth: '120px'
    }
  }
}
</script>