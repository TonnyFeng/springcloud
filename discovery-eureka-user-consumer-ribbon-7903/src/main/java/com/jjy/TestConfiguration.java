//package com.jjy;
//
//import com.netflix.loadbalancer.IRule;
//import com.netflix.loadbalancer.RandomRule;
//import com.netflix.loadbalancer.RetryRule;
//import com.netflix.loadbalancer.RoundRobinRule;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//@ExcludeFromComponentScan
//public class TestConfiguration {
//  //  @Autowired
//  //  IClientConfig config;
//
//  @Bean
//  public IRule ribbonRule() {
////    return new RandomRule();
////    return new RoundRobinRule();
//    return new RetryRule();
//  }
//}
