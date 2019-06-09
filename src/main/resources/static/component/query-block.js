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
            <el-collapse-item :title="$t('message.query')">
                <el-form :model="queryCondition" label-position="right" label-width="120px">
                    <el-row :gutter="20">
                        <el-col :span="12" >
                            <el-form-item :label="$t('message.serialNumber')">
                                <el-input clearable v-model="queryCondition.serialNumber" :placeholder="$t('message.tips.input.serialNumber')"></el-input>
                            </el-form-item>
                            <el-form-item :label="$t('message.type')" required>
                                <el-select v-model="queryCondition.kind" clearable :placeholder="$t('message.tips.input.type')">
                                    <el-option v-for="item in machineKinds" :key="item" :label="item" :value="item"></el-option>
                                </el-select>
                            </el-form-item>
                        
                            <el-form-item label="BMCIP">
                                <el-input clearable v-model="queryCondition.bmcIP" :placeholder="$t('message.tips.input.BMCIP')"></el-input>
                            </el-form-item>
                            <el-form-item :label="$t('message.machineIP')">
                                <el-input clearable v-model="queryCondition.businessIP" :placeholder="$t('message.tips.input.machineIP')"></el-input>
                            </el-form-item>
                        </el-col>
                        <el-col :span="12" >
                            <el-form-item :label="$t('message.owner')">
                                <el-input clearable v-model="queryCondition.owner" :placeholder="$t('message.tips.input.owner')"></el-input>
                            </el-form-item>
                            <el-form-item :label="$t('message.machineUser')">
                                <el-input clearable v-model="queryCondition.user" :placeholder="$t('message.tips.input.machineUser')"></el-input>
                            </el-form-item>
                        
                            <el-form-item :label="$t('message.address')">
                                <el-input clearable v-model="queryCondition.virtualMachineIP" :placeholder="$t('message.tips.input.address')"></el-input>
                            </el-form-item>
                        </el-col>
                    </el-row>
                    <el-form-item align="right">
                        <el-button type="primary" @click="query()">{{$t('message.query')}}</el-button>
                        <el-button @click="queryCondition={}">{{$t('message.reset')}}</el-button>
                    </el-form-item>
                </el-form>
            </el-collapse-item>
        </el-collapse>
        `
};