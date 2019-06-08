package com.guozhchun.vo;

import java.util.List;

import com.guozhchun.entity.Machine;

public class QueryResult
{
    private int totalNum;

    private List<Machine> machineList;

    public QueryResult()
    {
    }

    public QueryResult(int totalNum, List<Machine> machineList)
    {
        this.totalNum = totalNum;
        this.machineList = machineList;
    }

    public int getTotalNum()
    {
        return totalNum;
    }

    public void setTotalNum(int totalNum)
    {
        this.totalNum = totalNum;
    }

    public List<Machine> getMachineList()
    {
        return machineList;
    }

    public void setMachineList(List<Machine> machineList)
    {
        this.machineList = machineList;
    }
}
