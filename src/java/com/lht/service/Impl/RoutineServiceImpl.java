package com.lht.service.Impl;

import com.lht.dao.RoutineDao.RoutineDao;
import com.lht.pojo.Topic;
import com.lht.service.RoutineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("routineService")
public class RoutineServiceImpl implements RoutineService {
    @Autowired
    private RoutineDao routineDao;

    @Override
    public List<Integer> routineTest1() {
        return routineDao.routineTest1();
    }

    @Override
    public List<Integer> routineTest2() {
        return routineDao.routineTest2();
    }

    @Override
    public List<Integer> routineTest3() {
        return routineDao.routineTest3();
    }

    @Override
    public Topic routineList1(int id) {
        return routineDao.routineList1(id);
    }

    @Override
    public Topic routineList2(int id) {
        return routineDao.routineList2(id);
    }

    @Override
    public Topic routineList3(int id) {
        return routineDao.routineList3(id);
    }
}
