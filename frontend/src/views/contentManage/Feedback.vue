<template>
    <div>
        <ToolBar>
            <div class="animated bounceInRight">
                <el-button
                    type="primary"
                    icon="el-icon-plus"
                    size="small" 
                    round
                    @click="addFeedback"
                >点我也没用，你是管理员，有问题找老大去</el-button>
            </div>
            <div style="float: right">
                <el-input
                    placeholder="搜索意见反馈"
                    size="small"
                    style="width: 140px"
                    v-model="searchParams.feedbackTitle"
                    clearable
                ></el-input>
                <el-select
                    v-model="searchParams.feedbackType"
                    size="small"
                    clearable
                    placeholder="请选择分类"
                    style="width: 140px"
                >
                    <el-option v-for="(v,k) in $Config.feedbackType" :key="k" :label="v" :value="k"></el-option>
                </el-select>

                <el-button
                    type="success"
                    icon="el-icon-search"
                    size="small"
                    round
                    @click="refresh = !refresh"
                ></el-button>
            </div>
        </ToolBar>

        <div class="animated fadeInUp">
            <el-table :data="tableDataSentences" border height="485px" style="width: 100%">
                <el-table-column prop="id" label="id" width="50"></el-table-column>
                <el-table-column
                    prop="feedback_timeline_id"
                    label="feedback_timeline_id"
                    width="170"
                ></el-table-column>
                <el-table-column prop="feedback_content" label="反馈内容"></el-table-column>
                <el-table-column prop="feedback_contact" label="反馈联系" width="140"></el-table-column>

                <el-table-column label="操作" :render-header="tableAction" width="100">
                    <template slot-scope="scope">
                        <el-button
                            @click="handleClick(scope.row)"
                            type="info"
                            icon="el-icon-info"
                            size="small"
                            circle
                        ></el-button>

                        <el-button
                            @click="deleteFeedback(scope.row)"
                            type="primary"
                            icon="el-icon-delete"
                            size="small"
                            circle
                        ></el-button>
                    </template>
                </el-table-column>
            </el-table>
        </div>
    </div>
</template>

<script>
import ToolBar from "@/components/ToolBar.vue";
import HelpHint from "@/components/HelpHint.vue";
import { allFeedback as feedbackApi } from "../../api/content";
import { deleteFeedback as deleteFeedbackApi } from "../../api/content";

export default {
    data() {
        return {
            searchParams: {
                feedbackTitle: "",
                feedbackType: "意见反馈"
            },
            addFeedbackBt_egg: 0,
            tableDataSentences: []
        };
    },
    methods: {
        addFeedback() {
            let self = this;
            self.addFeedbackBt_egg = self.addFeedbackBt_egg + 1;
            this.$message({
                type: "info",
                message: "点我也没用，你是管理员，有问题找老大去"
            });
            if (self.addFeedbackBt_egg % 5 == 4) {
                this.$message({
                    type: "warning",
                    message:
                        "你咋就说不听呢，都说了有问题找老大去，不要再点了，不然有可怕的事发生"
                });
            }
        },
        handleClick(row) {
            this.$alert(row, "意见反馈", {
                confirmButtonText: "确定",
                callback: action => {},
                roundButton: true
            });
        },
        tableAction() {
            return this.$createElement(
                "HelpHint",
                {
                    props: {
                        content: "查看反馈 / 删除反馈 "
                    }
                },
                "操作"
            );
        },

        deleteFeedback(row) {
            let self = this;
            self.$confirm("此操作将删除该反馈, 是否继续?", "提示", {
                confirmButtonText: "确定",
                cancelButtonText: "取消",
                type: "warning",
                roundButton: true
            })
                .then(() => {
                    deleteFeedbackApi({
                        id: row.id
                    })
                        .then(res => {
                            self.$notify({
                                title: "成功",
                                message: "id为 " + row.id + " 的反馈删除成功",
                                type: "success",
                                offset: 60
                            });
                            self.refreshFeedback();
                        })
                        .catch(res => {
                            console.log("没有删除该反馈");
                        });
                })
                .catch(() => {});
        },

        refreshFeedback() {
            feedbackApi({})
                .then(res => {
                    console.log("得到所有反馈res");
                    console.log(res);
                    this.tableDataSentences = res;
                })
                .catch(res => {
                    console.log("没有拿到反馈");
                });
        }
    },

    created() {
        this.refreshFeedback();
    },

    components: {
        ToolBar,
        HelpHint
    }
};
</script>

