<template>
<div >
  <div>
    <div class="wrap">
      <div class="header">
        <div class="container">
          <h1>智慧医疗管理平台</h1>
        </div>
      </div><!--header end-->
      <div class="main">
        <div class="container">
          <div class="loginbox">
            <h1>请填写您的登录信息</h1>
            <el-form :model="ruleForm" status-icon :rules="rules"  ref="ruleForm" class="demo-ruleForm" style="margin:auto;margin-top: 0px;width: 250px">

              <el-form-item  prop="cellphone">
                <el-input v-model="ruleForm.cellphone" placeholder="请填写手机号码"></el-input>
              </el-form-item>
              <el-form-item  prop="password" >
                <el-input  v-model="ruleForm.password" type="password" placeholder="请填写密码" autocomplete="off"></el-input>
              </el-form-item>

              <el-form-item  prop="imageCode">
                <el-input v-model="ruleForm.imageCode" placeholder="请填写验证码" style="width: 150px;"></el-input>
                <img src="/VerificationCode/code" style="position: absolute;top: 1px;margin-left: 20px" width="80px" height="40px">
              </el-form-item>
              <el-form-item>
                <el-button type="primary" @click="submitForm('ruleForm')">登录</el-button>
                <el-button @click="resetForm('ruleForm')">重置</el-button>
              </el-form-item>
            </el-form>


          </div>
          <div class="fr">
            <h2>智慧医疗管理平台</h2>
            <p>智慧医疗管理云平台是基于互联网技术、医学权威指南建立的慢病管理系统，为医院和医生提供智能化、多元化的有效管理工具。</p>
          </div>
        </div>
      </div><!--main end-->
    </div><!--wrap end-->
  </div>
</div>
</template>

<script>
export default {
  data() {
    var validateCellphone = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('请填写手机号码'));
      } else if (!/^1[3456789]\d{9}$/.test(value)) {
        callback(new Error('请填写正确的手机号码'));
      } else {
        callback();
      }
    };
    var validatePassword = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('请填写密码'));
      } else if (value.length < 6) {
        callback(new Error('密码长度必须大于或等于6位'));
      } else {
        callback();
      }
    };
    var validateimageCode = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('请填写验证码'));
      } else {
        callback();
      }
    };

    return {
      ruleForm: {
        cellphone:'',
        password: '',
        imageCode:''

      },
      rules: {
        cellphone: [
          { validator: validateCellphone, trigger: 'blur' }
        ],
        password: [
          { validator: validatePassword, trigger: 'blur' }
        ],
        imageCode: [
          { validator: validateimageCode, trigger: 'blur' }
        ],
      }
    };
  },
  methods: {
    submitForm(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          //数据填写完毕
          this.$axios.post("/system/consumer", this.$data.ruleForm)
            .then(resp => {
              if (resp.data.code != "20000") {
                this.$message.error(resp.data.message);
              }else{
                this.$message({ type: 'success', message: resp.data.message });
                this.$router.push("/index")
              }
            });
        } else {
          console.log('error submit!!');
          return false;
        }
      });
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    }
  }
}
</script>

<style scoped src="../static/css/login.css">

</style>

