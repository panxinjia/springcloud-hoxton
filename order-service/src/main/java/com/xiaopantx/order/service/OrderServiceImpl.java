package com.xiaopantx.order.service;

import com.xiaopantx.pojo.Order;
import com.xiaopantx.pojo.Product;
import com.xiaopantx.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {


    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private LoadBalancerClient loadBalancerClient;


    @Override
    public List<Order> list() {
        return null;
    }

    @Override
    public Order info(Integer id) {
        return null;
    }

    @Override
    public boolean save(Order entity) {
        return false;
    }

    @Override
    public Order update(Order order) {
        return null;
    }

    @Override
    public boolean remove(Integer id) {
        return false;
    }


    public List<Product> productListByDiscoveryClient() {
        StringBuilder url = new StringBuilder("http://");

        List<String> services = discoveryClient.getServices();
        if (CollectionUtils.isEmpty(services)) {
            return null;
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("PRODUCT-SERVICE");
        if (CollectionUtils.isEmpty(instances)) {
            return null;
        }

        // RoundRibbon 模拟随机调用
        int index = (int)(Math.random() * instances.size());
        ServiceInstance instance = instances.get(index);

        url.append(instance.getHost()).append(":").append(instance.getPort()).append("/product/list");

//        TODO restTemplate 调用
//        restTemplate.exchange(url.toString(), HttpMethod.GET, null, )



        return null;
    }
}
