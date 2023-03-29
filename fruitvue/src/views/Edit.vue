<template>
    <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
        <el-form-item label="水果ID" prop="id">
            <el-input v-model="ruleForm.id" readonly></el-input>
        </el-form-item>

        <el-form-item label="名称" prop="name">
            <el-input v-model="ruleForm.name"></el-input>
        </el-form-item>

        <el-form-item label="销量" prop="sale">
            <el-input v-model="ruleForm.sale"></el-input>
        </el-form-item>

        <el-form-item label="图片" prop="icon">
            <el-input v-model="ruleForm.icon"></el-input>
        </el-form-item>

        <el-form-item>
            <el-button type="primary" @click="submitForm('ruleForm')">修改</el-button>
            <el-button @click="resetForm('ruleForm')">重置</el-button>
        </el-form-item>
    </el-form>
    
</template>

<script>
    export default {
        data() {
            return {
                ruleForm: {
                    id: '',
                    name: '',
                    sale: '',
                    icon: '',

                },
                rules: {
                    name: [
                        { required: true, message: '请输入水果名称', trigger: 'blur' },
                    ],
                    sale: [
                        { required: true, message: '请输入水果销量', trigger: 'blur' },
                    ],
                    icon: [
                        { required: true, message: '请输入水果图片', trigger: 'blur' },
                    ]

                }
            };
        },
        created() {
            let id = this.$route.query.id
            let _this = this
            axios.get('http://localhost:8181/fruit/find/'+id).then(function (response) {
                _this.ruleForm = response.data
            })
        },
        methods: {
            submitForm(formName) {
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        let _this = this
                        axios.put('http://localhost:8181/fruit/update',this.ruleForm).then(function (response) {
                            _this.$alert(_this.ruleForm.name+'修改成功', 'OK', {
                                confirmButtonText: '确定',
                                callback: action => {
                                    _this.$router.push('/table')
                                }
                            });

                        })
                    }
                });
            },
            resetForm(formName) {
                this.$refs[formName].resetFields();
            }
        }
    }
</script>