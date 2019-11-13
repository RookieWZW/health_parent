package com.RookieWZW.controller;

import com.RookieWZW.constant.MessageConstant;
import com.RookieWZW.entity.Result;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: health_parent
 * @description: /
 * @author: RookieWZW
 * @create: 2019-11-13 15:50
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/getUsername")
    public Result getUsername()throws Exception{
        try {
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            return new Result(true, MessageConstant.GET_USERNAME_SUCCESS,user.getUsername());
        }catch (Exception e){
            return new Result(false,MessageConstant.GET_USERNAME_FAIL);
        }
    }
}