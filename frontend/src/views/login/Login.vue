<template>
    <div class="login">
        <div class="login-form">
            <div class="login-header">
                <img src="../../assets/images/logo.png"  alt>
                <p>HIS-系统</p>
            </div>
            <el-input
                placeholder="请输入用户名"
                suffix-icon="fa fa-user"
                v-model="userName"
                style="margin-bottom: 18px"
            ></el-input>

            <el-input
                placeholder="请输入密码"
                suffix-icon="fa fa-keyboard-o"
                v-model="password"
                type="password"
                style="margin-bottom: 18px"
                @keyup.native.enter="login"
            ></el-input>

            <el-button
                type="primary"
                :loading="loginLoading"
                style="width: 100%;margin-bottom: 18px"
                @click.native="login"
            >登录</el-button>
        </div>
    </div>
</template>

<script>
import { setToken } from "../../utils/dataStorage";
import { getToken } from "../../utils/dataStorage";
import { login as loginApi } from "../../api/user";
import store from "../../store/index";

export default {
    data() {
        return {
            userName: "",
            password: "",
            Remenber: true,
            loginLoading: false
        };
    },
    methods: {
        login() {
            this.loginLoading = true;
            console.log(this.userName);
            console.log(this.password);
            if (this.userName == "") {
                this.$message("请您输入用户名喔~~");
            } else if (this.password == "") {
                this.$message("请您输入密码喔~~");
            } else if (this.userName != "" && this.password != "") {
                loginApi({
                    account: this.userName,
                    password: this.password
                })

                .then(res => {
                    // console.log("res: "+res[0].status);
                    // setToken(res[0].operator_id+" "+res[0].operator_type_id);
                    // console.log("token: "+getToken().split(" "));
                    // if(res[0].operator_type_id==165||res[0].operator_type_id==166){
                    //      this.$router.push({ path: "/doctor" });
                    // }
                    // else if(res[0].operator_type_id==169) {
                    //     this.$router.push({ path: "/pharmacy" });
                    // }
                    // else {
                    //     console.log("here");
                    //     this.$router.push({ path: "/operator" });
                    // }
                    setToken(res[0].operator_id+" "+res[0].operator_type_id);
                    this.$router.push({ path: "/pharmacy" });


            })
            .catch(res => {
                console.log("error");
                this.$message("用户名或密码错误");
            });
        }
        this.loginLoading = false;
        }
    }
    };
</script>


<style lang="scss">
@import "Login.scss";
</style>
