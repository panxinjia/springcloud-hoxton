package com.xiaopantx.pay.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * @author xiaopantx
 */
@Slf4j
@RestController
@RequestMapping(value = "pay")
public class PayController {

    @Value("${server.port}")
    private Integer port;

    @Value("${eureka.instance.hostname}")
    private String hostName;

    @PutMapping(value = "payment")
    public boolean payment(@RequestParam(value = "price") Double price) {
        log.info(hostName + ":" + port + "/pay/payment?price" + price);
        return true;
    }
}
