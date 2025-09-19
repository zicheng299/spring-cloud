package com.demo.provider.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.demo.provider.entity.DocLibrary;
import com.demo.provider.entity.GeneralFollow;
import com.demo.provider.mapper.DocLibraryMapper;
import com.demo.provider.mapper.GeneralFollowMapper;
import com.demo.provider.service.DocLibraryService;
import com.demo.provider.vo.DocVO;
import com.demo.provider.vo.ParamVO;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.bouncycastle.operator.OperatorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Wrapper;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class DocLibraryServiceImpl implements DocLibraryService {

    @Autowired
    private DocLibraryMapper docLibraryMapper;

    @Autowired
    private GeneralFollowMapper generalFollowMapper;


    @Override
    public String operation(String resourceId, String userId, Boolean isFollow) throws OperatorException {

        DocLibrary docLibrary = docLibraryMapper.selectById(resourceId);
        if(docLibrary == null){
            throw new OperatorException("文档不存在");
        }
        //关注
        if(isFollow){
            //是否已关注

            if(isFollow(resourceId, userId)){
                throw new OperatorException("该文档已关注，无需重复关注");
            }
            GeneralFollow generalFollow = new GeneralFollow();
            generalFollow.setCreatedBy(userId);
            generalFollow.setCreatedTime(LocalDateTime.now());
            //文档类型为DOCLIBRARY时，resourceId = docLibraryId
            generalFollow.setResourceType("DOCLIBRARY");
            generalFollow.setResourceId(resourceId);
            generalFollow.setDocLibraryId(resourceId);
            generalFollow.setTenantCode("bk_ci");
            int insert = generalFollowMapper.insert(generalFollow);
            if(insert <= 0 ){
                throw new OperatorException("数据库操作失败");
            }
        } else {
            //取消关注
            if (isFollow(resourceId, userId)) {
                int delete = generalFollowMapper.delete(Wrappers.<GeneralFollow>lambdaQuery()
                        .eq(GeneralFollow::getCreatedBy, userId)
                        .eq(GeneralFollow::getResourceId, resourceId));
                if (delete <= 0) {
                    throw new OperatorException("数据库操作失败");
                }
            }

        }
        return "操作成功";
    }

    @Override
    public PageInfo<DocVO> page(ParamVO paramVO, Integer size, Integer num) {
        PageHelper.startPage(num, size);
        List<DocVO> docList = docLibraryMapper.selectByParam(paramVO);
        PageInfo<DocVO> pageInfo = new PageInfo<>(docList);
        return pageInfo;
    }

    private Boolean isFollow(String resourceId, String userId) {
        return generalFollowMapper.exists(
                Wrappers.<GeneralFollow>lambdaQuery()
                        .eq(GeneralFollow::getCreatedBy, userId)
                        .eq(GeneralFollow::getResourceId, resourceId));
    }
}
