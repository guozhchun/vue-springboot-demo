package com.guozhchun.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.guozhchun.constant.CheckResult;
import com.guozhchun.entity.Machine;
import com.guozhchun.service.MachineService;
import com.guozhchun.vo.QueryCondition;

@RestController
@RequestMapping("/machine")
public class MachineController
{
    @Autowired
    private MachineService machineService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Machine> getMachines()
    {
        return machineService.getMachines(new QueryCondition());
    }

    @RequestMapping(method = RequestMethod.POST)
    public CheckResult addMachine(@RequestBody Machine machine)
    {
        CheckResult checkResult = machineService.checkMachineInfo(machine);
        if (checkResult != CheckResult.SUCCESS)
        {
            return checkResult;
        }

        machineService.addMachine(machine);
        return CheckResult.SUCCESS;
    }

    @RequestMapping(method = RequestMethod.PUT)
    public CheckResult updateMachine(@RequestBody Machine machine)
    {
        CheckResult checkResult = machineService.checkMachineInfo(machine);
        if (checkResult != CheckResult.SUCCESS)
        {
            return checkResult;
        }

        machineService.updateMachine(machine);
        return CheckResult.SUCCESS;
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void deleteMachines(@RequestBody List<Integer> ids)
    {
        machineService.deleteMachines(ids);
    }
}
