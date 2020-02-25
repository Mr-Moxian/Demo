package com.sts.demo.controller;

import com.sts.demo.entities.ResultVO;
import com.sts.demo.service.goods.IGoodsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping(value = "/goods")
public class GoodsController {

    @Resource
    private IGoodsService service;
    /**
     * 查询商品
     * */
    @RequestMapping(value = "/queryData",method = RequestMethod.POST)
    @ResponseBody
    public ResultVO queryGoods(String value){
        ResultVO rsVO = new ResultVO();
        List<?> data = null;
        try{
            data = service.queryGoodsData(value);
            rsVO.setData(data);
            rsVO.setSuccess(true);
            rsVO.setMessage("数据查询成功，查询数据共计" + data.size() + "条");
        }catch (Exception e){
            rsVO.setSuccess(false);
            rsVO.setMessage("数据查询失败！" + e);
        }

        return rsVO;
    }
}
