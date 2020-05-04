<template>
    <div>
        <el-card class="box-card">
            <div slot="header">
                <span>{{ $route.meta.title}}</span>
            </div>
            <el-tabs v-model="activeName">
                <el-tab-pane label="基本信息" name="index">
                    <div class="panel-heading">
                        <img :src="currentAdminAvator">
                        <span class="title">
                            <p class="role">{{$store.state.currentAdminAccount}}</p>
                            <span class="name">{{$store.state.currentAdminPermission}}</span>
                        </span>
                        <i
                            class="el-icon-edit-outline"
                            style="font-size: 28px; position: absolute; right: 31px; cursor: pointer;"
                        ></i>
                    </div>
                    <div class="panel-body">
                        <ul>
                            <li>
                                <el-row :gutter="20">
                                    <el-col :span="6">
                                        <i class="fa fa-id-card"></i>
                                    </el-col>
                                    <el-col :span="12">ID</el-col>
                                    <el-col :span="6">1</el-col>
                                </el-row>
                            </li>
                            <li>
                                <el-row :gutter="20">
                                    <el-col :span="6">
                                        <i class="fa fa-envelope"></i>
                                    </el-col>
                                    <el-col :span="12">EMAIL</el-col>
                                    <el-col :span="6">Admin@gmail.com</el-col>
                                </el-row>
                            </li>
                            <li>
                                <el-row :gutter="20">
                                    <el-col :span="6">
                                        <i class="fa fa-female"></i>
                                    </el-col>
                                    <el-col :span="12">性别</el-col>
                                    <el-col :span="6">女</el-col>
                                </el-row>
                            </li>
                            <li>
                                <el-row :gutter="20">
                                    <el-col :span="6">
                                        <i class="fa fa-birthday-cake"></i>
                                    </el-col>
                                    <el-col :span="12">生日</el-col>
                                    <el-col :span="6">04.08</el-col>
                                </el-row>
                            </li>
                            <li>
                                <el-row :gutter="20">
                                    <el-col :span="6">
                                        <i class="fa fa-phone"></i>
                                    </el-col>
                                    <el-col :span="12">手机</el-col>
                                    <el-col :span="6">158XXXX2554</el-col>
                                </el-row>
                            </li>
                            <li>
                                <el-row :gutter="20">
                                    <el-col :span="6">
                                        <i class="fa fa-calendar"></i>
                                    </el-col>
                                    <el-col :span="12">注册时间</el-col>
                                    <el-col :span="6">2017-08-23</el-col>
                                </el-row>
                            </li>
                        </ul>
                    </div>
                </el-tab-pane>
                <el-tab-pane label="头像修改" name="second">
                    所以，你到这里来，就是为了改个头像嘛(⊙︿⊙)
                    
                    <el-upload
                        class="upload-demo"
                        drag
                        action="https://sm.ms/api/upload"
                        :on-success="uploadAvatorURL"
                        :on-error="uploadAvatorURLError"
                        :before-upload="beforeAvatarUpload"
                    >
                        <i class="el-icon-upload"></i>
                        <div class="el-upload__text">
                            将文件拖到此处，或
                            <em>点击上传</em>
                        </div>
                        <div class="el-upload__tip" slot="tip">只能上传jpg/png文件，且不超过5MB</div>
                    </el-upload>
                    

                </el-tab-pane>
                <el-tab-pane label="密码修改" name="third">就是不让你改，你能怎么样</el-tab-pane>
            </el-tabs>
        </el-card>
    </div>
</template>

<script>
import { uploadAvatorURL as uploadAvatorURLApi } from "../../api/user";

export default {
    data() {
        return {
            activeName: "index",
            currentAdminAvator: ""
        };
    },
    methods: {
        beforeAvatarUpload(file) {
            const isJPG = file.type === "image/jpeg";
            const isPNG = file.type === "image/png";
            const isLt2M = file.size / 1024 / 1024 < 5;

            if (!isJPG && !isPNG) {
                this.$message.error("上传头像图片只能是 JPG或者PNG 格式!");
            }
            if (!isLt2M) {
                this.$message.error("上传头像图片大小不能超过 5MB!");
            }
            return isJPG && isLt2M;
        },
        uploadAvatorURL(response, file, fileList) {
            console.log("lsk上传的图片：");
            console.log(response);
            // uploadAvatorURLApi({
            //           // admin_account: this.userName,
            //           // admin_password: this.password
            //       })
            //           .then(res => {
            //               console.log("res");
            //               console.log(res);

            //           })
            //           .catch(res => {
            //               console.log("res");
            //           });

            this.$messagee({
                message: "吼吼吼~~上传成功",
                type: "success"
            });
        },
        uploadAvatorURLError(err, file, fileList) {
            this.$message.error("啊偶~~上传失败了");
        }
    },
    created: function() {
        this.currentAdminAvator = this.$store.state.currentAdminAvator;
    }
};
</script>
<style lang="scss">
.box-card {
    border-radius: 0;
    .panel-heading {
        display: flex;
        text-align: left;
        width: 100%;
        border-bottom: 1px solid #eeeff1;
        padding: 15px;
        font-weight: bold;
        img {
            margin-right: 15px;
            width: 90px;
            height: 90px;
            border-radius: 50%;
        }
        .title {
            display: flex;
            flex-direction: column;
            justify-content: center;
            .name {
                color: #367fa9;
                font-size: 18px;
            }
            .role {
                color: #99a9c0;
            }
        }
    }
    .panel-body {
        color: #3c8dbc;
        ul {
            li {
                border-bottom: 1px solid #eeeff1;
                padding: 0 15px;
                height: 45px;
                line-height: 45px;
            }
        }
    }
}
</style>
