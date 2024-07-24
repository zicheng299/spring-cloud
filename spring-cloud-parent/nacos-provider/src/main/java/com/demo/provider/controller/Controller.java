package com.demo.provider.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/provider")
public class Controller {



    @GetMapping("/test")
    public String test() {

        return "nacos-provider请求成功";
    }




}
