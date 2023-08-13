<template>
  <div>
<!--  <el-tag type="primary">添加数据</el-tag>-->
  <el-form ref="form" :rules="rules" :model="fruit" label-width="100px" style="width: 900px">

    <el-form-item label="水果编号：" prop="id">
      <el-input v-model="fruit.id"></el-input>
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
      <el-button type="primary" @click="onSubmit('form')">增加</el-button>&nbsp;
      <router-link to="/table2"><el-button>取消</el-button></router-link>
    </el-form-item>

  </el-form>
  </div>
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
        id:[{ required: true, message: '请输入销量', trigger: 'blur' },
        ],
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

  methods: {
    onSubmit(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          let _this = this
          axios.put('http://localhost:8888/fruit/add',this.fruit).then(function (response) {
            if(response.data){
              _this.$alert(_this.fruit.name+'增加成功！', '增加数据', {
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