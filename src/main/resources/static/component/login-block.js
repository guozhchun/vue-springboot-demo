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
                    _this.$alert(_this.$t('message.loginSuccess'), _this.$t('message.prompt'), {
                        confirmButtonText: _this.$t('message.confirm'),
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
            this.$confirm(this.$t('message.tips.dialog.logout'), this.$t('message.warning'), {
                confirmButtonText: this.$t('message.confirm'),
                cancelButtonText: this.$t('message.cancel'),
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
        changeLanguaue(lang) {
            this.$i18n.locale = lang;
        },
        openDialog() {
            this.visible = true;
            this.user = {};
        },
        handleError(type) {
            var errorMessage = this.$t('message.tips.errors.fail');
            if (type == "USERNAME_EMPTY") {
                errorMessage = this.$t('message.tips.errors.usernameEmpty');
            } else if (type == "PASSWORD_EMPYT") {
                errorMessage = this.$t('message.tips.errors.passwordEmpty');
            } else if (type == "FAIL") {
                errorMessage = this.$t('message.loginFail');
            } else if (type == "OPERATION_FAIL") {
                errorMessage = this.$t('message.tips.errors.fail');
            }

            this.$alert(errorMessage, this.$t('message.error'), {
                confirmButtonText: this.$t('message.confirm'),
                type: "error"
            });
        }
    },
    template: `
        <div>
            <div align="right" class="login-btn-group">
                {{loginUserName}}
                <el-button type="text" @click="openDialog()" v-if="loginUserName == null || loginUserName == ''">{{$t('message.login')}}</el-button>
                <el-button type="text" @click="logout()" v-else>{{$t('message.logout')}}</el-button>
                <el-divider direction="vertical"></el-divider>
                <el-button type="text" @click="changeLanguaue('zh')" :disabled="$i18n.locale=='zh'">中文</el-button>
                <el-button type="text" @click="changeLanguaue('en')" :disabled="$i18n.locale=='en'">English</el-button>
            </div>
            <el-dialog :title="$t('message.login')" :visible.sync="visible" :close-on-click-modal=false>
                <el-form :model="user" label-position="left" label-width="100px">
                    <el-form-item :label="$t('message.username')" required>
                        <el-input v-model="user.name" :placeholder="$t('message.tips.input.username')" required></el-input>
                    </el-form-item>
                    <el-form-item :label="$t('message.password')" required>
                        <el-input v-model="user.password" :placeholder="$t('message.tips.input.password')" show-password required></el-input>
                    </el-form-item>
                    <el-form-item align="right">
                        <el-button type="primary" @click="login()">{{$t('message.login')}}</el-button>
                        <el-button @click="visible=false">{{$t('message.cancel')}}</el-button>
                    </el-form-item>
                </el-form>
            </el-dialog>
        </div>
        `
};