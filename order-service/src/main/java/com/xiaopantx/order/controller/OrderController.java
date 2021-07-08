package com.xiaopantx.order.controller;

import com.xiaopantx.pojo.Order;
import com.xiaopantx.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value = "order")
public class OrderController {


    @Autowired
    private OrderService orderService;

    @GetMapping(value = "{id}")
    public Order info(@PathVariable(value = "id") Integer id) {
        return orderService.info(id);
    }
}
