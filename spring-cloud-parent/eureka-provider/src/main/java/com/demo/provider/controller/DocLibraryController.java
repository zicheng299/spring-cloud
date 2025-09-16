package com.demo.provider.controller;

import com.demo.provider.common.Response;
import com.demo.provider.entity.Book;
import com.demo.provider.service.DocLibraryService;
import org.bouncycastle.operator.OperatorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/library")
public class DocLibraryController {

    @Autowired
    private DocLibraryService docLibraryService;


    @GetMapping("/operation/{resourceId}/{isFollow}")
    public Response<String> operation(
            @PathVariable("resourceId")
            String resourceId,
            @PathVariable("isFollow")
            Boolean isFollow,
            @RequestParam("userId")
            String userId
    ) throws OperatorException {
        return Response.success(docLibraryService.operation(resourceId, userId, isFollow));
    }

}
