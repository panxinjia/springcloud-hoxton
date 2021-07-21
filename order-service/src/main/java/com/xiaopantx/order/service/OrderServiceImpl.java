package com.xiaopantx.order.service;

import com.xiaopantx.pojo.Order;
import com.xiaopantx.pojo.Product;
import com.xiaopantx.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    @Value("${server.port}")
    private Integer port;

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
        // this.services();
        this.pay2();
        return Order.builder()
                .id(id)
                .orderNo("order-00" + id)
                .orderAddress("中国：" + this.port)
                //.productList(this.productList())
                .productList(this.productListLoadBalancerClient())
                .build();
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

    public List<Product> productList() {
        ResponseEntity<List> resp = restTemplate.getForEntity("http://product-service/product/list", List.class);
        return resp.getBody();
    }

    public List<Product> productListLoadBalancerClient() {
        ServiceInstance instance = loadBalancerClient.choose("product-service");
        if (instance == null) {
            return null;
        }

        StringBuilder url = new StringBuilder();
        url.append("http://").append(instance.getHost()).append(":").append(instance.getPort()).append("/product/list");
        // log.info("product service url => {}", url.toString());
        System.out.println("product-service url: " + url.toString());

        ResponseEntity<List> resp = restTemplate.getForEntity(url.toString(), List.class);
        return resp.getBody();
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

     public boolean pay2() {
         ResponseEntity<Boolean> resp = restTemplate.getForEntity("http://pay-service/pay/payment?price=1", Boolean.class);
         return resp.getBody();
     }

    public boolean pay() {

        ServiceInstance instance = loadBalancerClient.choose("pay-service");

        String url = "http://" + instance.getHost() + ":" + instance.getPort() + "/pay/payment?price=1";
        System.out.println("pay-service url: " + url.toString());
        ResponseEntity<Boolean> resp = restTemplate.getForEntity(url, Boolean.class);
        return resp.getBody();
    }

    public void services() {
        List<String> services = discoveryClient.getServices();
        services.stream()
                .forEach(System.out::println);
    }
}
