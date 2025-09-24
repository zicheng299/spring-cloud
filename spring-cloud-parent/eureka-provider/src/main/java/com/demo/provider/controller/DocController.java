package com.demo.provider.controller;

import com.demo.provider.common.Response;
import com.demo.provider.param.DocParam;
import com.demo.provider.service.DocLibraryService;
import com.demo.provider.service.DocService;
import org.bouncycastle.operator.OperatorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doc")
public class DocController {
    @Autowired
    private DocService docService;


    @PostMapping("/add")
    public Response<String> add(
            @PathVariable("userId")
            String userId,
            @RequestBody
            DocParam param
    ) throws OperatorException {
        return Response.success(docService.add(param));
    }



}
