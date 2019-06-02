package com.guozhchun.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.guozhchun.entity.VirtualMachine;

@Mapper
@Repository
public interface VirtualMachineMapper
{
    List<VirtualMachine> queryVirtualMachinesByExactCondition(VirtualMachine virtualMachine);

    void addVirtualMachine(VirtualMachine virtualMachine);

    void updateVirtualMachine(VirtualMachine virtualMachine);

    void deleteVirtualMachine(VirtualMachine virtualMachine);
}
