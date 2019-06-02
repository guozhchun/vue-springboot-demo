package com.guozhchun.vo;

public class QueryCondition
{
    private int id;

    private String serialNumber;

    private String kind;

    private String bmcIP;

    private String businessIP;

    private String owner;

    private String user;

    private String virtualMachineIP;

    private int startPageNum;

    private int pagePerCount;

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

    public String getVirtualMachineIP()
    {
        return virtualMachineIP;
    }

    public void setVirtualMachineIP(String virtualMachineIP)
    {
        this.virtualMachineIP = virtualMachineIP;
    }

    public int getStartPageNum()
    {
        return startPageNum;
    }

    public void setStartPageNum(int startPageNum)
    {
        this.startPageNum = startPageNum;
    }

    public int getPagePerCount()
    {
        return pagePerCount;
    }

    public void setPagePerCount(int pagePerCount)
    {
        this.pagePerCount = pagePerCount;
    }
}
