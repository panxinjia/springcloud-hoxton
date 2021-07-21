package com.xiaopantx.alibaba.sentinel.controller;

import com.xiaopantx.alibaba.sentinel.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author panxj
 */
@RestController
@RequestMapping(value = "person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping(value = "info")
    public String info() {
        return personService.info();
    }
}
