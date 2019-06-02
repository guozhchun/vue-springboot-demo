package com.guozhchun.entity;

import java.util.List;

public class Machine
{
    private int id;

    private String serialNumber;

    private String kind;

    private String bmcIP;

    private String businessIP;

    private String address;

    private String owner;

    private String user;

    private String usages;

    private List<VirtualMachine> virtualMachines;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getSerialNumber()
    {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber)
    {
        this.serialNumber = serialNumber;
    }

    public String getKind()
    {
        return kind;
    }

    public void setKind(String kind)
    {
        this.kind = kind;
    }

    public String getBmcIP()
    {
        return bmcIP;
    }

    public void setBmcIP(String bmcIP)
    {
        this.bmcIP = bmcIP;
    }

    public String getBusinessIP()
    {
        return businessIP;
    }

    public void setBusinessIP(String businessIP)
    {
        this.businessIP = businessIP;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getOwner()
    {
        return owner;
    }

    public void setOwner(String owner)
    {
        this.owner = owner;
    }

    public String getUser()
    {
        return user;
    }

    public void setUser(String user)
    {
        this.user = user;
    }

    public String getUsages()
    {
        return usages;
    }

    public void setUsages(String usages)
    {
        this.usages = usages;
    }

    public List<VirtualMachine> getVirtualMachines()
    {
        return virtualMachines;
    }

    public void setVirtualMachines(List<VirtualMachine> virtualMachines)
    {
        this.virtualMachines = virtualMachines;
    }
}
