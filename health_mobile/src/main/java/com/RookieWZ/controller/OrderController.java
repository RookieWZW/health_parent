package com.RookieWZ.controller;

import com.RookieWZW.constant.MessageConstant;
import com.RookieWZW.constant.RedisMessageConstant;
import com.RookieWZW.entity.Result;
import com.RookieWZW.pojo.Order;
import com.RookieWZW.service.OrderService;
import com.RookieWZW.utils.SMSUtils;
import com.alibaba.dubbo.config.annotation.Reference;
import com.aliyuncs.exceptions.ClientException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.JedisPool;

import java.util.Map;

/**
 * @program: health_parent
 * @description: 体检预约
 * @author: RookieWZW
 * @create: 2019-11-12 11:10
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Reference
    private OrderService orderService;

    @Autowired
    private JedisPool jedisPool;

    @RequestMapping("/submit")
    public Result submitOrder(@RequestMapping Map map){
        String telephone = (String) map.get("telephone");

        String codeInRedis = jedisPool.getResource().get(
                telephone+ RedisMessageConstant.SENDTYPE_ORDER
        );
        String validateCode = (String) map.get("validateCode");
        if (codeInRedis == null || !codeInRedis.equals(validateCode)){
            return new Result(false, MessageConstant.VALIDATECODE_ERROR);
        }
        Result result = null;
        try {
            map.put("orderType", Order.ORDERTYPE_WEIXIN);
            result = orderService.order(map);

        }catch (Exception e){
            e.printStackTrace();
            return result;
        }
        if (result.isFlag()){
            String orderDate = (String) map.get("orderDate");
            try {
                SMSUtils.sendShortMessage(SMSUtils.ORDER_NOTICE,telephone,orderDate);
            }catch (ClientException e){
                e.printStackTrace();
            }
        }
        return result;
    }

    @RequestMapping("/findById")
    public Result findById(Integer id){
        try {
            Map map = orderService.findById(id);
            return new Result(true,MessageConstant.QUERY_ORDER_SUCCESS,map);
        }catch (Exception e){
            e.printStackTrace();
            return new Result(false,MessageConstant.QUERY_ORDER_FAIL);
        }
    }
}