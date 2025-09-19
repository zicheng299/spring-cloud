package com.demo.provider.service;

import com.demo.provider.vo.DocVO;
import com.demo.provider.vo.ParamVO;
import com.github.pagehelper.PageInfo;
import org.bouncycastle.operator.OperatorException;

public interface DocLibraryService {
    String operation(String resourceId, String userId, Boolean isFollow) throws OperatorException;

    PageInfo<DocVO> page(ParamVO paramVO, Integer size, Integer num);
}
