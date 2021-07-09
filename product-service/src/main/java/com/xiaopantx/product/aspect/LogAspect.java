package com.xiaopantx.product.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author panxj
 */
@Slf4j
@Aspect
@Component
public class LogAspect {

    @Value(value = "${server.port}")
    private Integer port;

    @Before("execution(* com.xiaopantx.product.service.*.*(..))")
    public void before() {
        log.info("service port => {}", port);
    }
}
