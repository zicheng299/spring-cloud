package com.demo.consumer.controller;

import com.demo.consumer.config.RestTemplateConfig;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@Slf4j
@RestController
@RequestMapping("/consumer")
public class ConsumerController {


    private final static Logger logger = LoggerFactory.getLogger(ConsumerController.class);


    @Autowired
    private RestTemplateConfig restTemplateConfig;


    @GetMapping("/test")
    public String test() {
        return "consumer请求成功";
    }

    /**
     * restTemplate 远程调用
     */
    @GetMapping("/restTemplate")
    public String restTemplate() {
        RestTemplate restTemplate = restTemplateConfig.restTemplate();
        String result = restTemplate.getForObject("http://localhost:8000/provider/test", String.class);
        return result;
    }

    /**
     * discoveryClient 使用
     */
    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/discoveryClient")
    public String discoveryClient() {
        //获取注册中心实例列表
        List<ServiceInstance> instances = discoveryClient.getInstances("PROVIDER");
        if (instances != null && instances.size() > 0) {
            ServiceInstance provider = instances.get(0);
            String host = provider.getHost();
            int port = provider.getPort();
            String path = "http://" + host + ":" + port + "/provider/test";
            logger.info("远程调用地址:{}" + path);
            RestTemplate restTemplate = restTemplateConfig.restTemplate();
            return restTemplate.getForObject(path, String.class);
        }
        return null;
    }


}
