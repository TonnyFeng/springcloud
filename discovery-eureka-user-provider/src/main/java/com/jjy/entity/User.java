package com.jjy.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by fengwei on 2018/4/24.
 */
@Entity
@Data
@NoArgsConstructor
@ApiModel
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty( name = "id" , value = "用户ID" , allowEmptyValue = true )
    private Long id;

    @Column
    @ApiModelProperty( name = "username" , value = "用户名" , allowEmptyValue = true )
    private String username;

    @Column
    @ApiModelProperty( name = "name" , value = "姓名" , allowEmptyValue = true )
    private String name;

    @Column
    @ApiModelProperty( name = "age" , value = "年龄" , allowEmptyValue = true )
    private Short age;

    @Column
    @ApiModelProperty( name = "balance" , value = "余额" , allowEmptyValue = true )
    private BigDecimal balance;
}
