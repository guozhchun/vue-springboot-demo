package com.guozhchun.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.guozhchun.constant.CheckResult;
import com.guozhchun.entity.VirtualMachine;
import com.guozhchun.service.VirtualMachineService;

@RestController
@RequestMapping("/virtualMachine")
public class VirtualMachineController
{
    @Autowired
    private VirtualMachineService virtualMachineService;

    @RequestMapping(method = RequestMethod.POST)
    public CheckResult addVirtualMachine(@RequestBody VirtualMachine virtualMachine)
    {
        CheckResult checkResult = virtualMachineService.checkVirtualMachineInfo(virtualMachine, true);
        if (checkResult != CheckResult.SUCCESS)
        {
            return checkResult;
        }

        virtualMachineService.addVirtualMachine(virtualMachine);
        return CheckResult.SUCCESS;
    }

    @RequestMapping(method = RequestMethod.PUT)
    public CheckResult updateVirtualMachine(@RequestBody VirtualMachine virtualMachine)
    {
        CheckResult checkResult = virtualMachineService.checkVirtualMachineInfo(virtualMachine, false);
        if (checkResult != CheckResult.SUCCESS)
        {
            return checkResult;
        }

        virtualMachineService.updateVirtualMachine(virtualMachine);
        return CheckResult.SUCCESS;
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void deleteVirtualMachine(@RequestBody VirtualMachine virtualMachine)
    {
        virtualMachineService.deleteVirtualMachine(virtualMachine);
    }
}
