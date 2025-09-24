package com.demo.provider.service.impl;

import com.demo.provider.param.DocParam;
import com.demo.provider.service.DocService;

public class DocServiceImpl implements DocService {


    @Override
    public String add(DocParam param) {
        //根据文库名称判断文库是否存在
        //如果文库存在，获取文库ID = DOC_LIBRARY_ID

        //如果文库不存在，创建文库返回ID,需要字段（
        // NAME，
        // TYPE默认PROJECT，
        // PROJECT_ID，
        // TENANT_CODE，
        // CREATED_BY，
        // CREATED_TIME，
        // IS_DELETE默认0）


        //根据文档名称判断名称是否重复
        //如果名称重复，抛出“文档已存在”的操作异常


        //否则创建文档，需要字段有（
        // DOC_LIBRARY_ID
        //PARENT_ID
        // NAME
        // DOC_TYPE
        // TENANT_CODE
        // CREATED_BY
        // CREATED_TIME
        //IS_DELETE默认0
        // ）


        //返回文档ID
        return "";
    }
}
