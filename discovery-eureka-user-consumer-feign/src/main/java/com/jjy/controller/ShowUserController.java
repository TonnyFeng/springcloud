package com.jjy.controller;

import com.jjy.entity.User;
import com.jjy.feign.UserFeignClient;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by fengwei on 2018/4/24.
 */
@RestController
public class ShowUserController {

    @Autowired
    private UserFeignClient userFeignClient;

    @ApiOperation(value = "获取用户信息" , notes = "根据用户ID获取用户信息"  , response = User.class )
    @ApiImplicitParam(name = "id" , value = "用户ID" , required = true , dataType = "Long" , paramType = "path")
    @GetMapping("/movie/{id}")
    public User findById(@PathVariable Long id) {
        return userFeignClient.findById( id );
    }
}