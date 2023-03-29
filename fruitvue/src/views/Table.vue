<template>
    <el-table
            :data="tableData"
            border
            style="width: 100%">
        <el-table-column
                fixed
                prop="id"
                label="水果ID"
                width="160">
        </el-table-column>
        <el-table-column
                prop="name"
                label="水果名称"
                width="160">
        </el-table-column>
        <el-table-column
                prop="sale"
                label="售价"
                width="160">
        </el-table-column>
        <el-table-column
                prop="icon"
                label="水果图片"
                width="160">
            <template slot-scope="scope">
                <img :src="scope.row.icon" style="height: 70px"/>
            </template>
        </el-table-column>

        <el-table-column
                label="操作"
                width="160">
            <template slot-scope="scope">
                <el-button @click="fruitDelete(scope.row)" type="text" size="small">删除</el-button>
                <el-button @click="findFruit(scope.row)" type="text" size="small">编辑</el-button>
                <el-button @click="addFruit()" type="text" size="small">添加</el-button>
            </template>
        </el-table-column>
    </el-table>
</template>

<script>
    export default {
        methods: {
            addFruit(){
                this.$router.push('add')

            },
            findFruit(row){
              this.$router.push('edit?id='+row.id)

            },
            fruitDelete(row) {

                let _this = this
                this.$confirm('是否切丁要删除'+row.name+'?', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {
                    axios.delete('http://localhost:8181/fruit/delete/'+row.id).then(function (response) {
                        if (response.data){
                            this.$alert('删除成功', 'OK', {
                                confirmButtonText: '确定',
                                callback: action => {
                                    location.reload()
                                }
                            });

                        }

                    })

                }).catch(() => {

                });

            }
        },
        created() {
            const _this = this
            axios.get('http://localhost:8181/fruit/list').then(function (resp) {
                _this.tableData = resp.data

            })
        },

        data() {
            return {
                tableData: [{
                    id: '2016-05-02',
                    name: '王小虎',
                    sale: '上海',
                    icon: '普陀区',

                }]
            }
        }
    }
</script>