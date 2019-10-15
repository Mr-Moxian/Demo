package com.sts.demo.service;

import com.sts.demo.Entity.People;
import com.sts.demo.dao.PeopleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IPeopleServiceImpl implements PeopleService{

    @Autowired
    private PeopleDao peopleDao;

    @Override
    public int add(People vo) {
        return this.peopleDao.add(vo);
    }

    @Override
    public int update(People vo) {
        return this.peopleDao.update(vo);
    }

    @Override
    public int delete(People vo) {
        return this.peopleDao.delete(vo);
    }

    @Override
    public People queryUserInfoById(String id) {
        return this.peopleDao.queryUserInfoById(id);
    }

    @Override
    public List<People> queryAllPeopleByCondition(People vo) {
        return this.peopleDao.queryAllPeopleByCondition(vo);
    }
}
