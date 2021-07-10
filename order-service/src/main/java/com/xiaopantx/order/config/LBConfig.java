package com.xiaopantx.order.config;

import com.netflix.loadbalancer.*;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class LBConfig {



    @Bean
    //@LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    /**
     * 全局定制负载均衡策略
     * @return
     */
    @Bean
    public IRule iRule() {
        // ribbon 客户端负载策略
        return new RandomRule(); // 随机负载策略
        // return new RoundRobinRule();  // 轮询负载策略
        // return new RetryRule(); // 响应时间负载策略
    }
}
