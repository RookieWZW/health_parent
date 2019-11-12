package com.RookieWZ.controller;

import com.RookieWZW.constant.MessageConstant;
import com.RookieWZW.entity.Result;
import com.RookieWZW.pojo.Setmeal;
import com.RookieWZW.service.SetmealService;
import com.RookieWZW.utils.SMSUtils;
import com.RookieWZW.utils.ValidateCodeUtils;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.plugin2.message.Message;

import java.util.List;

/**
 * @program: health_parent
 * @description: *
 * @author: RookieWZW
 * @create: 2019-11-12 09:57
 */
@RequestMapping("/setmeal")
@RestController
public class SetmealController {

    @Reference
    private SetmealService setmealService;


    @RequestMapping("/getSetmeal")
    public Result getSetmeal(){
        try {
            List<Setmeal> list  = setmealService.findAll();
            return new Result(true, MessageConstant.GET_SETMEAL_LIST_SUCCESS,list);
        }catch (Exception e){
            e.printStackTrace();;
            return new Result(false,MessageConstant.GET_SETMEAL_LIST_FAIL);
        }
    }

    @RequestMapping("/findById")
    public Result findById(Integer id){
        try {
            Setmeal setmeal = setmealService.findById(id);
            return new Result(true,MessageConstant.QUERY_SETMEAL_SUCCESS,setmeal);
        }catch (Exception e){
            return new Result(false,MessageConstant.QUERY_SETMEAL_FAIL);
        }
    }


}