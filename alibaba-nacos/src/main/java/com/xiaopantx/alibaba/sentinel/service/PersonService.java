package com.xiaopantx.alibaba.sentinel.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.sun.deploy.security.BlockedException;
import org.springframework.stereotype.Service;

/**
 * @author panxj
 */
@Service
public class PersonService {


    @SentinelResource(value = "PersonService.info",blockHandler = "fail")
    public String info() {
        //return "Person.info:" + info;
        return "通过";
    }


    public String fail(BlockException e){
        System.out.println("阻塞");
        return "fail";
    }
}
