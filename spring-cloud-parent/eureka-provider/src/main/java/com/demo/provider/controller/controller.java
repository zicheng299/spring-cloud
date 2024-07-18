package com.demo.provider.controller;

import org.junit.Test;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/provider")
public class controller {


    @GetMapping("/test")
    public String test() {

        return "provider请求成功";
    }






}
