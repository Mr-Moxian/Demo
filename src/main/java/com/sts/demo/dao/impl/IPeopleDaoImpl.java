package com.sts.demo.dao.impl;

import com.sts.demo.entities.People;
import com.sts.demo.dao.PeopleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class IPeopleDaoImpl implements PeopleDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int add(People vo) {
        return jdbcTemplate.update("insert into t_persion (name,age,sex,hobby)  values(?,?,?,?)",vo.getName(),vo.getAge(),vo.getSex(),vo.getHobby());
    }

    @Override
    public int update(People vo) {
        return jdbcTemplate.update("update t_persion set name = ? where id = ?",vo.getId(),vo.getName());
    }

    @Override
    public int delete(People vo) {
        return jdbcTemplate.update("delete from t_persion where id = ?",vo.getId());
    }

    @Override
    public People queryUserInfoById(String id) {
        List<People> rs = jdbcTemplate.query("select * from  t_persion where id = ?",new Object[]{id},new BeanPropertyRowMapper(People.class));
        if(rs != null && !rs.isEmpty()){
            return rs.get(0);
        }
        return null;
    }

    @Override
    public List<People> queryAllPeopleByCondition(People vo) {
        List<People> rs = jdbcTemplate.query("select * from  t_persion",new Object[]{},new BeanPropertyRowMapper(People.class));
        return rs;
    }
}
