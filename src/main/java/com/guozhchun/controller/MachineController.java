package com.guozhchun.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.guozhchun.constant.CheckResult;
import com.guozhchun.entity.Machine;
import com.guozhchun.service.MachineService;
import com.guozhchun.vo.QueryCondition;
import com.guozhchun.vo.QueryResult;

@RestController
@RequestMapping("/machine")
public class MachineController
{
    @Autowired
    private MachineService machineService;

    @RequestMapping(method = RequestMethod.GET)
    public QueryResult getMachines(@RequestParam String querys) throws IOException
    {
        ObjectMapper mapper=new ObjectMapper();
        QueryCondition queryCondition = mapper.readValue(querys, QueryCondition.class);
        List<Machine> machines = machineService.getMachines(queryCondition);
        int machineCount = machineService.getMachineCount(queryCondition);

        QueryResult queryResult = new QueryResult(machineCount, machines);
        return queryResult;
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
