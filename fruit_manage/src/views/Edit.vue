<template>
  <el-form ref="form" :rules="rules" :model="fruit" label-width="100px" style="width: 900px">

    <el-form-item label="水果编号：">
      <el-input v-model="fruit.id" readonly ></el-input>
    </el-form-item>

    <el-form-item label="名称：" prop="name">
      <el-input v-model="fruit.name"></el-input>
    </el-form-item>

    <el-form-item label="销量：" prop="sale">
      <el-input v-model.number="fruit.sale"></el-input>
    </el-form-item>

    <el-form-item label="图片：" prop="icon">
      <el-input v-model="fruit.icon"></el-input>
    </el-form-item>

    <el-form-item>
      <el-button type="primary" @click="onSubmit('form')">立即修改</el-button>&nbsp
      <router-link to="/table2"><el-button>取消</el-button></router-link>
    </el-form-item>

  </el-form>
</template>

<script>
export default {
  name: "Edit",
  data() {
    return {
      fruit: {
        name: '',
        sale: '',
        icon: ''
      },
      rules:{
        id:[{type: 'number', message: '水果编号不可修改'}],
        name:[
          { required: true, message: '请输入水果名称', trigger: 'blur' }
        ],
        sale:[
          { required: true, message: '请输入销量', trigger: 'blur' },
          { type: 'number', message: '销量必须为数字值'}
        ],
        icon:[
          { required: true, message: '请输入图片链接', trigger: 'blur' }
        ]
      }
    }
  },
  created() {
    let id = this.$route.query.id
    let _this = this
    axios.get('http://localhost:8888/fruit/queryById/'+id).then(function (response) {
      _this.fruit = response.data
    })
  },
  methods: {
    onSubmit(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          let _this = this
          axios.put('http://localhost:8888/fruit/updataById',this.fruit).then(function (response) {
            if(response.data){
              _this.$alert(_this.fruit.name+'修改成功！', '修改数据', {
                confirmButtonText: '确定',
                callback: action => {
                  //跳转到/table
                  _this.$router.push('/table2')
                }
              });
            }
          })
        }
      });
    }
  }
}
</script>

<style scoped>

</style>