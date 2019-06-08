package com.guozhchun.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guozhchun.constant.CheckResult;
import com.guozhchun.entity.Machine;
import com.guozhchun.mapper.MachineMapper;
import com.guozhchun.vo.QueryCondition;

@Service
public class MachineService
{
    @Autowired
    private MachineMapper machineMapper;

    public int getMachineCount(QueryCondition queryCondition)
    {
        return machineMapper.queryMachineCount(queryCondition);
    }

    public List<Machine> getMachines(QueryCondition queryCondition)
    {
        if (queryCondition.getPagePerCount() == 0)
        {
            queryCondition.setPagePerCount(10);
        }

        if (queryCondition.getStartPageNum() == 0)
        {
            queryCondition.setStartPageNum(1);
        }

        return machineMapper.queryMachines(queryCondition);
    }

    public List<Machine> getNotIdMachinesWithOrCondition(QueryCondition queryCondition)
    {
        return machineMapper.queryNotIdMachinesWithOrCondition(queryCondition);
    }

    public CheckResult checkMachineInfo(Machine machine)
    {
        QueryCondition queryCondition = new QueryCondition();
        queryCondition.setId(machine.getId());
        queryCondition.setBmcIP(machine.getBmcIP());
        queryCondition.setBusinessIP(machine.getBusinessIP());
        queryCondition.setSerialNumber(machine.getSerialNumber());

        List<Machine> machines = getNotIdMachinesWithOrCondition(queryCondition);
        if (machines.size() == 0)
        {
            return CheckResult.SUCCESS;
        }

        Machine tempMachine = machines.get(0);
        if (StringUtils.equals(tempMachine.getBmcIP(), machine.getBmcIP()))
        {
            return CheckResult.BMCIP_EXIST;
        }

        if (StringUtils.equals(tempMachine.getBusinessIP(), machine.getBusinessIP()))
        {
            return CheckResult.BUSINESSIP_EXIST;
        }

        if (StringUtils.equals(tempMachine.getSerialNumber(), machine.getSerialNumber()))
        {
            return CheckResult.SERIALNUMBER_EXIST;
        }

        return CheckResult.SUCCESS;
    }

    public void addMachine(Machine machine)
    {
        machineMapper.addMachine(machine);
    }

    public void updateMachine(Machine machine)
    {
        machineMapper.updateMachine(machine);
    }

    public void deleteMachines(List<Integer> ids)
    {
        machineMapper.deleteMachines(ids);
    }
}
