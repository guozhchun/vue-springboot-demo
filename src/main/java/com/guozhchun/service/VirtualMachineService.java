package com.guozhchun.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guozhchun.constant.CheckResult;
import com.guozhchun.entity.VirtualMachine;
import com.guozhchun.mapper.VirtualMachineMapper;

@Service
public class VirtualMachineService
{
    @Autowired
    private VirtualMachineMapper virtualMachineMapper;

    public CheckResult checkVirtualMachineInfo(VirtualMachine virtualMachine, boolean isAdd)
    {
        if (StringUtils.isEmpty(virtualMachine.getIp()))
        {
            return CheckResult.VIRTUALIP_EMPTY;
        }

        List<VirtualMachine> virtualMachines = virtualMachineMapper.queryVirtualMachinesByExactCondition(virtualMachine);
        if (virtualMachines.size() == 0)
        {
            return CheckResult.SUCCESS;
        }

        if (isAdd)
        {
            return CheckResult.VIRTUALIP_EXIST;
        }

        return CheckResult.SUCCESS;
    }

    public void addVirtualMachine(VirtualMachine virtualMachine)
    {
        virtualMachineMapper.addVirtualMachine(virtualMachine);
    }

    public void updateVirtualMachine(VirtualMachine virtualMachine)
    {
        virtualMachineMapper.updateVirtualMachine(virtualMachine);
    }

    public void deleteVirtualMachine(VirtualMachine virtualMachine)
    {
        virtualMachineMapper.deleteVirtualMachine(virtualMachine);
    }
}
