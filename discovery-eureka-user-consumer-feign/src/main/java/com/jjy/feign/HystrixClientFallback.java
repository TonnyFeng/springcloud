package com.jjy.feign;

import com.jjy.entity.User;
import org.springframework.stereotype.Component;

@Component
public class HystrixClientFallback implements UserFeignClient {
  @Override
  public User findById(Long id) {
    User user = new User();
    user.setId(-1L);
    return user;
  }
}