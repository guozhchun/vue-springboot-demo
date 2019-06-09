var loginBlock = {
    data: function () {
        return {
            visible: false,
            user: {
                name: "",
                password: ""
            },
            loginUserName: localStorage.getItem("loginUserName")
        }
    },
    methods: {
        login() {
            var _this = this;
            axios.post("/login", this.user).then(function(response) {
                if (response.data == "USERNAME_EMPTY" || response.data == "PASSWORD_EMPYT" || response.data == "FAIL") {
                    _this.handleError(response.data);
                    _this.$emit("get-user", "");
                } else {
                    _this.$alert("登录成功", "提示", {
                        confirmButtonText: "确定",
                        type: "success"
                    });
                    localStorage.setItem("token", response.data);
                    localStorage.setItem("loginUserName", _this.user.name);
                    _this.visible = false;
                    _this.loginUserName = _this.user.name;
                    _this.$emit("get-user", "admin");
                }
            }).catch(function(error) {
                _this.handleError("OPERATION_FAIL");
                _this.$emit("get-user", "");
            });
        },
        logout() {
            var _this = this;
            this.$confirm('确定要退出登录?', '警告', {
                confirmButtonText: '确定',
                cancelButtonText: '取消',
                type: 'warning'
            }).then(() => {
                axios.post("/logout").then(function(response) {
                    localStorage.removeItem("token");
                    localStorage.removeItem("loginUserName");
                    _this.loginUserName = "";
                    _this.user = {};
                    _this.$emit("get-user", "");
                }).catch(function(error) {
                    _this.handleError("OPERATION_FAIL");
                });
            }).catch(() => {
            });
        },
        openDialog() {
            this.visible = true;
            this.user = {};
        },
        handleError(type) {
            var errorMessage = "操作失败";
            if (type == "USERNAME_EMPTY") {
                errorMessage = "用户名为空";
            } else if (type == "PASSWORD_EMPYT") {
                errorMessage = "密码为空";
            } else if (type == "FAIL") {
                errorMessage = "登录失败";
            } else if (type == "OPERATION_FAIL") {
                errorMessage = "操作失败";
            }

            this.$alert(errorMessage, "错误", {
                confirmButtonText: "确定",
                type: "error"
            });
        }
    },
    template: `
        <div>
            <div align="right" class="login-btn-group">
                {{loginUserName}}
                <el-button type="text" @click="openDialog()" v-if="loginUserName == null || loginUserName == ''">登录</el-button>
                <el-button type="text" @click="logout()" v-else>注销</el-button>
            </div>
            <el-dialog title="登录" :visible.sync="visible" :close-on-click-modal=false>
                <el-form :model="user" label-position="left" label-width="80px">
                    <el-form-item label="用户名" required>
                        <el-input v-model="user.name" placeholder="请输入用户名" required></el-input>
                    </el-form-item>
                    <el-form-item label="密码" required>
                        <el-input v-model="user.password" placeholder="请输入密码" show-password required></el-input>
                    </el-form-item>
                    <el-form-item align="right">
                        <el-button type="primary" @click="login()">登录</el-button>
                        <el-button @click="visible=false">取消</el-button>
                    </el-form-item>
                </el-form>
            </el-dialog>
        </div>
        `
};