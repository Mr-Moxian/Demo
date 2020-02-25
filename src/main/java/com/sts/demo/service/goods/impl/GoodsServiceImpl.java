package com.sts.demo.service.goods.impl;

import com.sts.demo.entities.mapper.GoodsMapper;
import com.sts.demo.service.goods.IGoodsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GoodsServiceImpl implements IGoodsService {

    @Resource
    private GoodsMapper mapper;

    @Override
    public List<?> queryGoodsData(String value) throws Exception{
        return mapper.queryGoodsData(value);
    }
}
