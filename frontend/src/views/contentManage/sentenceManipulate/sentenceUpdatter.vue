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
                <el-form-item label="半句标题">
                    <el-input v-model="form.sentenceTitle" auto-complete="off"></el-input>
                </el-form-item>
                <el-form-item label="半句作者">
                    <el-input v-model="form.sentenceAuthor" auto-complete="off"></el-input>
                </el-form-item>
                <el-form-item label="半句内容">
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
    name: "sentenceUpdatter",
    props: {
        dialogFormVisible: Boolean,
        data: Array,
        title: String
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
                this.$confirm("此操作将更新该半句, 是否继续?", "提示", {
                    confirmButtonText: "确定",
                    cancelButtonText: "取消",
                    type: "warning",
                    roundButton: true
                })
                    .then(() => {
                        this.btnLoading = true;
                        this.$message(
                            "额么，老大还没有开发完这个功能呢~~ 你先玩玩别哒~~"
                        );
                        this.btnLoading = false;
                        this.form.sentenceTitle = "";
                        this.form.sentenceAuthor = "";
                        this.form.sentenceContent = "";
                        this.$emit("refreshSentences");

                        // addSentenceApi({
                        //     sentence_date: getCurrentDate(),
                        //     sentence_title: this.form.sentenceTitle,
                        //     sentence_post_author: "Half Town",
                        //     sentence_content: this.form.sentenceContent,
                        //     sentence_author: this.form.sentenceAuthor
                        // })
                        //     .then(res => {
                        //         console.log("添加半句成功");
                        //         this.$message("您写的半句添加成功了喔~~");
                        //         this.$emit("refreshSentences");
                        //     })
                        //     .catch(res => {
                        //         // console.log("没有拿到半句");
                        //         // this.$message("~~~有地方出问题啦");
                        //         this.$emit("refreshSentences");
                        //     });
                    })
                    .catch(() => {});
            }
        }
    },
    created() {
        this.form.sentenceTitle = this.props.data.sentence_title;
        this.form.sentenceAuthor = this.props.data.sentence_author;
        this.form.sentenceContent = this.props.data.sentence_content;
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

