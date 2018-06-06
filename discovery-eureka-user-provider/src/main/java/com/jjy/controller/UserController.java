package com.jjy.controller;

import com.jjy.entity.User;
import com.jjy.repository.UserRepository;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by fengwei on 2018/4/24.
 */
@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

//    @Autowired
//    private EurekaClient eurekaClient;
//
//    @Autowired
//    private DiscoveryClient discoveryClient;

    @ApiOperation(value = "获取用户信息" , notes = "根据用户ID获取用户信息"  , response = User.class )
    @ApiImplicitParam(name = "id" , value = "用户ID" , required = true , dataType = "Long" , paramType = "path")
    @GetMapping("/simple/{id}")
    public User findById(@PathVariable Long id) {
//        try {
//            Thread.sleep( 1000 * 60 );
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return this.userRepository.findOne( id );
    }

//    @GetMapping("/eureka-instance")
//    public String serviceUrl() {
//        InstanceInfo instance = this.eurekaClient.getNextServerFromEureka("DISCOVERY-EUREKA-USER", false);
//        return instance.getHomePageUrl();
//    }
//
//    @GetMapping("/instance-info")
//    public ServiceInstance showInfo() {
//        ServiceInstance localServiceInstance = this.discoveryClient.getLocalServiceInstance();
//        return localServiceInstance;
//    }

    @ApiOperation(value="创建用户", notes="根据User对象创建用户", response = User.class )
    @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    @PostMapping("/user")
    public User postUser(@RequestBody User user) {
        return userRepository.save( user );
    }

    // 该请求不会成功
    @ApiIgnore//使用该注解忽略这个API
    @GetMapping("/get-user")
    public User getUser(User user) {
        Specification specification = new Specification<User>(){
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if(null != user.getAge()){
                    predicates.add(criteriaBuilder.greaterThan(root.get("age"), user.getAge()));
                }
                if(null != user.getName()){
                    predicates.add(criteriaBuilder.like(root.get("nickname"), "%"+user.getName()+"%"));
                }
                if(null != user.getId()){
                    predicates.add(criteriaBuilder.equal(root.get("id"), user.getId() ));
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };
        return (User) userRepository.findOne( specification );
    }

    @ApiOperation(value="获取用户列表", notes="获取用户列表", response = User.class )
    @GetMapping("list-all")
    public List<User> getUserList() {
        Specification specification = new Specification<User>(){
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder criteriaBuilder) {
                return null;
            }
        };
        return userRepository.findAll(specification);
    }
}