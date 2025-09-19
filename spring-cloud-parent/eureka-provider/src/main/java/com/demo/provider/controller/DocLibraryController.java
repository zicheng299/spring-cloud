package com.demo.provider.controller;

import com.demo.provider.common.Response;
import com.demo.provider.service.DocLibraryService;
import com.demo.provider.vo.DocVO;
import com.demo.provider.vo.ParamVO;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.page.PageParams;
import org.bouncycastle.operator.OperatorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/page")
    public Response<PageInfo<DocVO>> page(
            @RequestParam("num")
            Integer num,
            @RequestParam("size")
            Integer size,
            @RequestBody
            ParamVO paramVO
    ) {
        return Response.success(docLibraryService.page(paramVO, size, num));
    }

}
