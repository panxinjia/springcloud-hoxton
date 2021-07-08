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

    @PutMapping(value = "payment")
    public boolean payment(@RequestParam(value = "price") Double price) {
        log.info("端口 => {}, 支付订单 => {} ¥", this.port, price);
        return true;
    }
}
