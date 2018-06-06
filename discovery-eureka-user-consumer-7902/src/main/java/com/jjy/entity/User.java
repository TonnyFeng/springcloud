package com.jjy.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * Created by fengwei on 2018/4/24.
 */
@Data
@NoArgsConstructor
@ApiModel
public class User {

    @ApiModelProperty( name = "id" , value = "用户ID" , allowEmptyValue = true )
    private Long id;

    @ApiModelProperty( name = "username" , value = "用户名" , allowEmptyValue = true )
    private String username;

    @ApiModelProperty( name = "name" , value = "姓名" , allowEmptyValue = true )
    private String name;

    @ApiModelProperty( name = "age" , value = "年龄" , allowEmptyValue = true )
    private Short age;

    @ApiModelProperty( name = "balance" , value = "余额" , allowEmptyValue = true )
    private BigDecimal balance;
}
