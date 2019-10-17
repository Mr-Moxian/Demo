package com.sts.demo.dao;

import com.sts.demo.entities.People;

import java.util.List;

public interface PeopleDao {
    /**t添加*/
    int add(People vo);

    /**修改*/
    int update(People vo);

    /**删除*/
    int delete(People vo);

    /**查询（根据ID）*/
    People queryUserInfoById(String id);

    /**查询所有的用户*/
    List<People> queryAllPeopleByCondition(People vo);
}
