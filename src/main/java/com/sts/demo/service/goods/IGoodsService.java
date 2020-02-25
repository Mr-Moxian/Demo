package com.sts.demo.service.goods;


import java.util.List;


public interface IGoodsService {

    /**
     * 查询商品
     * */
    List<?> queryGoodsData(String value) throws Exception;

}
