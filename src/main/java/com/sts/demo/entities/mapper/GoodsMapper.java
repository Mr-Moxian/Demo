package com.sts.demo.entities.mapper;

import java.util.List;

public interface GoodsMapper {

    /**
     * 根据名称模糊查询参数
     * @param value 查询参数
     * */
    List<?> queryGoodsData(String value) throws Exception;
}
