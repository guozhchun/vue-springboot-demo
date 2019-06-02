package com.guozhchun.entity;

public class VirtualMachine
{
    private int machineId;

    private String ip;

    private String usages;

    public int getMachineId()
    {
        return machineId;
    }

    public void setMachineId(int machineId)
    {
        this.machineId = machineId;
    }

    public String getIp()
    {
        return ip;
    }

    public void setIp(String ip)
    {
        this.ip = ip;
    }

    public String getUsages()
    {
        return usages;
    }

    public void setUsages(String usages)
    {
        this.usages = usages;
    }
}
