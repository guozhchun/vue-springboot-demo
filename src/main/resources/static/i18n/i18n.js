const messages = {
    zh: {
        message: {
            delete: "删除",
            add: "增加",
            edit: "编辑",
            query: "查询",
            reset: "重置",
            addVirtual: "增加虚拟机",
            operation: "操作",
            virtualIP: "虚拟机IP",
            usage: "用途",
            serialNumber: "资产编号",
            type: "类型",
            machineIP: "宿主机IP",
            owner: "挂账人",
            machineUser: "使用人",
            address: "地址",
            submit: "提交",
            cancel: "取消",
            confirm: "确定",
            warning: "警告",
            prompt: "提示",
            error: "错误",
            operationSuccess: "操作成功",
            loginSuccess: "登录成功",
            loginFail: "登录失败",
            login: "登录",
            logout: "注销",
            username: "用户名",
            password: "密码",
            tips: {
                input: {
                    serialNumber: "请输入资产编号",
                    type: "请选择机器类型",
                    BMCIP: "请输入BMCIP",
                    machineIP: "请输入宿主机IP",
                    owner: "请输入挂账人",
                    machineUser: "请输入使用人",
                    usage: "请输入机器用途",
                    address: "请输入实验室位置",
                    virtualIP: "请输入虚拟机IP",
                    username: "请输入用户名",
                    password: "请输入密码",
                },
                dialog: {
                    addMachine: "添加机器",
                    editMachine: "编辑机器",
                    addVirtual: "添加虚拟机",
                    editVirtual: "编辑虚拟机",
                    deleteMachine:"此操作将删除选中的机器以及选中机器下的所有虚拟机, 是否继续?",
                    deleteVirtualMachine: "确定删除虚拟机?",
                    logout: "确定要退出登录?"
                },
                errors: {
                    fail: "操作失败",
                    BMCIPExist: "BMCIP已经存在",
                    businessIPExist: "宿主机IP已经存在",
                    serialNumberExist: "资产编号已经存在",
                    virtualIPEmpty: "虚拟机IP为空",
                    virtualIPExist: "虚拟机IP已经存在",
                    unknow: "未知错误",
                    usernameEmpty: "用户名为空",
                    passwordEmpty: "密码为空"
                }
            }
        },
        ...ELEMENT.lang.zhCN
    },
    en: {
        message: {
            delete: "delete",
            add: "add",
            edit: "edit",
            query: "query",
            reset: "reset",
            addVirtual: "add virtual machine",
            operation: "operation",
            virtualIP: "virtual machine IP",
            usage: "usage",
            serialNumber: "serial number",
            type: "type",
            machineIP: "machine IP",
            owner: "machine owner",
            machineUser: "machine user",
            address: "address",
            submit: "submit",
            cancel: "cancel",
            confirm: "confirm",
            warning: "warning",
            prompt: "prompt",
            error: "error",
            operationSuccess: "operation success",
            loginSuccess: "login success",
            loginFail: "login fail",
            login: "login",
            logout: "logout",
            username: "username",
            password: "password",
            tips: {
                input: {
                    serialNumber: "please input the serial number",
                    type: "please select the machine type",
                    BMCIP: "please input the BMCIP",
                    machineIP: "please input the machine IP",
                    owner: "please input the machine owner",
                    machineUser: "please input the machine user",
                    usage: "please input the uses for the machine",
                    address: "please input the address",
                    virtualIP: "please input the virtual machine IP",
                    username: "please input the username",
                    password: "please input the password",
                },
                dialog: {
                    addMachine: "add machine",
                    editMachine: "edit machine information",
                    addVirtual: "add virtual machine",
                    editVirtual: "edit virtual machine",
                    deleteMachine:"This operation will delete all the machines and their virtual machines which be choosen, are you sure to continue?",
                    deleteVirtualMachine: "Are you sure to delete the virtual machine?",
                    logout: "Are you sure to logout?"
                },
                errors: {
                    fail: "operation fail",
                    BMCIPExist: "BMCIP is exist",
                    businessIPExist: "The machine IP is exist",
                    serialNumberExist: "The serial number is exist",
                    virtualIPEmpty: "The virtual machine IP is empty",
                    virtualIPExist: "The virtual machine IP is exist",
                    unknow: "unknow error",
                    usernameEmpty: "The username is empty",
                    passwordEmpty: "The password is empty"
                }
            }
        },
        ...ELEMENT.lang.en
    }
};

const i18n = new VueI18n({
    locale: "zh", // set locale
    messages, // set locale messages
});

Vue.use(ELEMENT, {
    i18n: (key, value) => i18n.t(key, value)
});