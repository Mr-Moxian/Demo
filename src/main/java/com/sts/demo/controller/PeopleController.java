package com.sts.demo.controller;

import com.sts.demo.entities.People;
import com.sts.demo.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/people")
public class PeopleController {

    @Autowired
    private PeopleService peopleService;

    /**新增方法*/
    @RequestMapping(value = "/add")
    public void add(People vo){
        try{
            vo.setId(1);
            vo.setName("xiaoming");
            vo.setAge(22);
            vo.setSex("男");
            vo.setHobby("manymany");
            peopleService.add(vo);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**查询方法*/
    @RequestMapping(value = "/queryUser")
    public List<People> queryUser(People vo){
        try{

            return peopleService.queryAllPeopleByCondition(vo);
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }
}
