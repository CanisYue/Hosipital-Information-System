<template>
    <div class="sentence-dialog">
        <el-dialog
            id="addSentenceDialog"
            :title="title"
            :visible="dialogFormVisible"
            :show-close="false"
            width="45%"
        >
            <el-form :model="form">
                <el-form-item label="半句主题(如果是添加主题则必须填上)">
                    <el-input v-model="form.sentenceTheme" auto-complete="off" placeholder="没有主题的话空着就好啦 "></el-input>
                </el-form-item>
                <el-form-item label="半句标题*">
                    <el-input v-model="form.sentenceTitle" auto-complete="off"></el-input>
                </el-form-item>
                <el-form-item label="半句作者*">
                    <el-input v-model="form.sentenceAuthor" placeholder="此处填作者而非发布作者" auto-complete="off"></el-input>
                </el-form-item>
                <el-form-item label="半句内容*">
                    <el-input
                        v-model="form.sentenceContent"
                        type="textarea"
                        :rows="3"
                        placeholder="请输入您的半句"
                    ></el-input>
                </el-form-item>
            </el-form>
            <div slot="footer" class="dialog-footer">
                <el-button round @click="$emit('cancel');">取 消</el-button>
                <el-button round type="primary" :loading="btnLoading" @click="btnOk">确 定</el-button>
            </div>
        </el-dialog>
    </div>
</template>

<script>
import { addSentence as addSentenceApi } from "../../../api/content";

export default {
    name: "sentenceAdder",
    props: {
        dialogFormVisible: Boolean,
        // data: [Object, Boolean],
        title: String
        // departTree: Array
    },
    data() {
        return {
            props: {
                value: "id",
                label: "name",
                children: "children"
            },
            form: {
                id: null,
                sentenceTheme:"",
                sentenceTitle: "",
                sentenceAuthor: "",
                sentenceContent: ""
            },
            btnLoading: false
        };
    },
    watch: {
        data: {
            handler: function() {}
        }
    },
    methods: {
        btnOk() {
            //显示日期在页面上  yyy-MM-dd
            function getCurrentDate() {
                var date = new Date();
                //年
                var year = date.getFullYear();
                //月
                var month = date.getMonth() + 1;
                //日
                var day = date.getDate();
                //时
                var hh = date.getHours();
                //分
                var mm = date.getMinutes();
                //秒
                var ss = date.getSeconds();

                if (month >= 1 && month <= 9) {
                    month = "0" + month;
                }
                if (day >= 1 && day <= 9) {
                    day = "0" + day;
                }
                if (hh >= 1 && hh <= 9) {
                    hh = "0" + hh;
                }
                if (mm >= 1 && mm <= 9) {
                    mm = "0" + mm;
                }
                if (ss >= 1 && ss <= 9) {
                    ss = "0" + ss;
                }

                return (
                    year +
                    "-" +
                    month +
                    "-" +
                    day +
                    " " +
                    hh +
                    ":" +
                    mm +
                    ":" +
                    ss
                );
            }
            if (this.form.sentenceTitle == "") {
                this.$message("半句标题不可以为空喔~~");
            } else if (this.form.sentenceAuthor == "") {
                this.$message("半句作者不可以为空喔~~");
            } else if (this.form.sentenceContent == "") {
                this.$message("半句内容不可以为空喔~~");
            } else if (
                this.form.sentenceTitle != "" &&
                this.form.sentenceAuthor != "" &&
                this.form.sentenceContent != ""
            ) {
                this.btnLoading = true;
                addSentenceApi({
                    sentence_date: getCurrentDate(),
                    sentence_theme: this.form.sentenceTheme,
                    sentence_title: this.form.sentenceTitle,
                    sentence_post_author: "Half Town",
                    sentence_post_author_id: "lskhyn",
                    sentence_post_author_avator: "https://wx4.sinaimg.cn/mw1024/006hpJxDly1g4dkvk7lx4j30ex0ed0up.jpg",
                    sentence_content: this.form.sentenceContent,
                    sentence_author: this.form.sentenceAuthor,
                    sentence_imgUrl: this.form.sentenceImgUrl
                })
                    .then(res => {
                        console.log("添加半句成功");
                        this.$message("您写的半句添加成功了喔~~");
                        this.$emit("refreshSentences");
                    })
                    .catch(res => {
                        // console.log("没有拿到半句");
                        // this.$message("~~~有地方出问题啦");
                        this.$emit("refreshSentences");
                    });
            }
            this.btnLoading = false;
            this.form.sentenceTheme = "";
            this.form.sentenceTitle = "";
            this.form.sentenceAuthor = "";
            this.form.sentenceContent = "";
            this.$emit("refreshSentences");
        }
    },
    components: {}
};
</script>
<style lang="scss">
.sentence-dialog {
    .el-cascader {
        width: 100%;
    }
}
</style>
