package com.jjy.controller;

import com.jjy.entity.User;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * Created by fengwei on 2018/4/24.
 */
@RestController
public class ShowUserController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${user.userServicePath}")
    private String userServicePath;

    @ApiOperation(value = "获取用户信息" , notes = "根据用户ID获取用户信息"  , response = User.class )
    @ApiImplicitParam(name = "id" , value = "用户ID" , required = true , dataType = "Long" , paramType = "path")
    @GetMapping("/movie/{id}")
    public User findById(@PathVariable Long id) {
        return this.restTemplate.getForObject(this.userServicePath + "{1}", User.class , id );
    }
}