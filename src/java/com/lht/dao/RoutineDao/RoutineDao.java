package com.lht.dao.RoutineDao;

import com.lht.pojo.Topic;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoutineDao {
    public List<Integer> routineTest1();
    public List<Integer> routineTest2();
    public List<Integer> routineTest3();

    public Topic routineList1(@Param("id")int id);
    public Topic routineList2(@Param("id")int id);
    public Topic routineList3(@Param("id")int id);
}
