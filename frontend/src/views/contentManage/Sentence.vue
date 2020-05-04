<template>
    <div>
        <ToolBar>
            <div class="animated bounceInRight">
                <el-button
                    type="primary"
                    icon="el-icon-plus"
                    size="small"
                    round
                    @click="addSentence"
                >添加</el-button>
            </div>
            <sentenceAdder
                :title="sentenceAdderTitle"
                :dialogFormVisible="dialogFormVisible"
                @val-change="sentenceEditChange"
                @cancel="dialogFormVisible = false"
                @refreshSentences="refreshSentences"
            ></sentenceAdder>
            <sentenceUpdatter
                :title="sentenceUpdatterTitle"
                :dialogFormVisible="sentenceUpdatter"
                :data="currentEditSentence"
                @val-change="sentenceEditChange"
                @cancel="sentenceUpdatter = false"
                @refreshSentences="refreshSentences"
            ></sentenceUpdatter>

            <div style="float: right">
                <el-input
                    placeholder="搜索半句"
                    size="small"
                    style="width: 140px"
                    v-model="searchParams.sentenceTitle"
                    clearable
                ></el-input>
                <el-select
                    v-model="searchParams.sentenceType"
                    size="small"
                    clearable
                    placeholder="请选择分类"
                    style="width: 140px"
                >
                    <el-option v-for="(v,k) in $Config.sentenceType" :key="k" :label="v" :value="k"></el-option>
                </el-select>

                <el-select
                    v-model="searchParams.sentenceStatus"
                    size="small"
                    clearable
                    placeholder="请选择状态"
                    style="width: 120px"
                >
                    <el-option
                        v-for="(v,k) in $Config.sentenceStatus"
                        :key="k"
                        :label="v"
                        :value="k"
                    ></el-option>
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
                <el-table-column prop="sentence_timeline_id" label="timeline_id" width="78"></el-table-column>
                <el-table-column prop="sentence_date" label="发布日期" width="100"></el-table-column>
                <el-table-column prop="sentence_theme" label="半句主题" width="80"></el-table-column>
                <el-table-column prop="sentence_title" label="半句标题" width="150"></el-table-column>
                <el-table-column prop="sentence_post_author" label="半句发布人" width="100"></el-table-column>
                <el-table-column prop="sentence_post_author_avator" label="发布人头像" width="70">
                    <template scope="scope"> 
                        <img :src="scope.row.sentence_post_author_avator" width="50" height="50" style="border-radius: 50%;"/> 
                    </template> 
                </el-table-column>
                <el-table-column prop="sentence_content" label="内容"></el-table-column>
                <el-table-column prop="sentence_author" label="作者" width="90"></el-table-column>

                <el-table-column label="操作" :render-header="tableAction" width="140">
                    <template slot-scope="scope">
                        <el-button
                            @click="handleClick(scope.row)"
                            type="info"
                            icon="el-icon-info"
                            size="small"
                            circle
                        ></el-button>
                        <el-button
                            @click="updateSentence(scope.row)"
                            type="primary"
                            icon="el-icon-edit"
                            size="small"
                            circle
                        ></el-button>
                        <el-button
                            @click="deleteSentence(scope.row)"
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
import { allSentences as sentencesApi } from "../../api/content";
import { deleteSentence as deleteSentenceApi } from "../../api/content";
import sentenceAdder from "./sentenceManipulate/sentenceAdder.vue";
import sentenceUpdatter from "./sentenceManipulate/sentenceUpdatter.vue";

export default {
    data() {
        return {
            sentenceAdderTitle: "半句编写",
            dialogFormVisible: false,
            sentenceUpdatterTitle: "半句更新",
            sentenceUpdatter: false,
            currentEditSentence: [],
            searchParams: {
                sentenceTitle: "",
                sentenceType: "官方半句",
                sentenceStatus: "发布"
            },
            tableDataSentences: []
        };
    },
    methods: {
        addSentence() {
            let self = this;
            self.dialogFormVisible = true;
        },
        sentenceEditChange() {},
        handleClick(row) {
            this.$alert(row, "半句名称", {
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
                        content: "查看半句 / 编辑半句 / 删除半句 "
                    }
                },
                "操作"
            );
        },

        updateSentence(row) {
            let self = this;
            self.currentEditSentence = [row];
            // console.log("self.currentEditSentence")
            // console.log(self.currentEditSentence)
            self.sentenceUpdatter = true;
        },
        deleteSentence(row) {
            let self = this;
            self.$confirm("此操作将删除该半句, 是否继续?", "提示", {
                confirmButtonText: "确定",
                cancelButtonText: "取消",
                type: "warning",
                roundButton: true
            })
                .then(() => {
                    deleteSentenceApi({
                        id: row.id
                    })
                        .then(res => {
                            self.$notify({
                                title: "成功",
                                message: "id为 " + row.id + " 的半句删除成功",
                                type: "success",
                                offset: 60
                            });
                            self.refreshSentences();
                        })
                        .catch(res => {
                            console.log("没有删除该半句");
                        });
                })
                .catch(() => {});
        },

        refreshSentences() {
            sentencesApi({})
                .then(res => {
                    console.log("得到所有半句res");
                    console.log(res);
                    this.tableDataSentences = res;
                    this.dialogFormVisible = false;
                })
                .catch(res => {
                    console.log("没有拿到半句");
                    this.dialogFormVisible = false;
                });
        }
    },

    created() {
        this.refreshSentences();
    },

    components: {
        ToolBar,
        HelpHint,
        sentenceAdder,
        sentenceUpdatter
    }
};
</script>

<style>
</style>

