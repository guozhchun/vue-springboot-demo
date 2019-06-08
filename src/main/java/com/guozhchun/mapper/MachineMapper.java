package com.guozhchun.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.guozhchun.entity.Machine;
import com.guozhchun.vo.QueryCondition;

@Mapper
@Repository
public interface MachineMapper
{
    int queryMachineCount(QueryCondition queryCondition);

    List<Machine> queryMachines(QueryCondition queryCondition);

    List<Machine> queryNotIdMachinesWithOrCondition(QueryCondition queryCondition);

    void addMachine(Machine machine);

    void updateMachine(Machine machine);

    void deleteMachines(List<Integer> ids);
}
