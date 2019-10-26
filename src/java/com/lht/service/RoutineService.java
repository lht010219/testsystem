package com.lht.service;


import com.lht.pojo.Topic;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoutineService {
    public List<Integer> routineTest1();
    public List<Integer> routineTest2();
    public List<Integer> routineTest3();

    public Topic routineList1(int id);
    public Topic routineList2(int id);
    public Topic routineList3(int id);
}
