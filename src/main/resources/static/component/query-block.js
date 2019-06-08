var queryBlock = {
    props: ["machineKinds"],
    data: function () {
        return {
            queryCondition: {}
        }
    },
    methods: {
        query() {
            this.queryCondition.startPageNum = 1;
            this.queryCondition.pagePerCount = 10;
            this.$emit("get-data", this.queryCondition);
        }
    },
    template: `
        <el-collapse accordion>
            <el-collapse-item title="查询">
                <el-form :model="queryCondition" label-position="left" label-width="80px">
                    <el-row :gutter="20">
                        <el-col :span="12" >
                            <el-form-item label="资产编号">
                                <el-input clearable v-model="queryCondition.serialNumber" placeholder="请输入资产编号"></el-input>
                            </el-form-item>
                            <el-form-item label="类型" required>
                                <el-select v-model="queryCondition.kind" clearable placeholder="请选择机器类型">
                                    <el-option v-for="item in machineKinds" :key="item" :label="item" :value="item"></el-option>
                                </el-select>
                            </el-form-item>
                        
                            <el-form-item label="BMCIP">
                                <el-input clearable v-model="queryCondition.bmcIP" placeholder="请输入BMCIP"></el-input>
                            </el-form-item>
                            <el-form-item label="宿主机IP">
                                <el-input clearable v-model="queryCondition.businessIP" placeholder="请输入宿主机IP"></el-input>
                            </el-form-item>
                        </el-col>
                        <el-col :span="12" >
                            <el-form-item label="挂账人">
                                <el-input clearable v-model="queryCondition.owner" placeholder="请输入挂账人"></el-input>
                            </el-form-item>
                            <el-form-item label="使用人">
                                <el-input clearable v-model="queryCondition.user" placeholder="请输入使用人"></el-input>
                            </el-form-item>
                        
                            <el-form-item label="虚拟机IP">
                                <el-input clearable v-model="queryCondition.virtualMachineIP" placeholder="请输入虚拟机IP"></el-input>
                            </el-form-item>
                        </el-col>
                    </el-row>
                    <el-form-item align="right">
                        <el-button type="primary" @click="query()">查询</el-button>
                        <el-button @click="queryCondition={}">重置</el-button>
                    </el-form-item>
                </el-form>
            </el-collapse-item>
        </el-collapse>
        `
};