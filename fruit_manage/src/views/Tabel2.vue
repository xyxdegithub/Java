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

    <el-pagination
    @size-change="handleSizeChange"
    @current-change="handleCurrentChange"
    :current-page="currentPage"
    :page-sizes="[1,4, 10, 20, 30]"
    :page-size="pageSize"
    layout="total, sizes, prev, pager, next, jumper"
    :total="totalCount">
    </el-pagination>
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
                //点击确定之后重新刷新页面，还是在table页面
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
    },

    // 分页点击方法,改变size时
    handleSizeChange(val) {
      let _this = this
      axios.get('http://localhost:8888/fruit/getPage2/'+val).then(function (response) {
        console.log(response)
        //赋值
        _this.tableData=response.data.data
        _this.currentPage=response.data.current
        _this.pageSize=response.data.size
        _this.totalCount=response.data.totalCount
      })
    },
    // 分页点击方法,改变当前页时
    handleCurrentChange(val) {
      let _this = this
      let size=_this.pageSize
      axios.get('http://localhost:8888/fruit/getPage3/',{params:{
        current: val,
        size: size
      }}).then(function (response) {
        console.log(response)
        //赋值
        _this.tableData=response.data.data
        _this.currentPage=response.data.current
        _this.pageSize=response.data.size
        _this.totalCount=response.data.totalCount
      })
    }

  },

  // 得到后端数据
  created() {
    let _this=this
    //从后端得到表格数据
    axios.get('http://localhost:8888/fruit/getPage').then(function (response) {
      console.log(response)
      //赋值
      _this.tableData=response.data.data
      _this.currentPage=response.data.current
      _this.pageSize=response.data.size
      _this.totalCount=response.data.totalCount


    })
  },

  data() {
    return {
      //默认分页数据
      currentPage:1,
      pageSize: 4,
      totalCount: 10,




    }
  }
}
</script>