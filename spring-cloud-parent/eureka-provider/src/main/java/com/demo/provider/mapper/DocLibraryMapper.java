package com.demo.provider.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.demo.provider.entity.DocLibrary;
import com.demo.provider.vo.DocVO;
import com.demo.provider.vo.ParamVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DocLibraryMapper extends BaseMapper<DocLibrary> {


    List<DocVO> selectByParam(@Param("param") ParamVO paramVO);
}
