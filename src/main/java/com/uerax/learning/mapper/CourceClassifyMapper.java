package com.uerax.learning.mapper;

import com.uerax.learning.domain.CourceClassify;
import com.uerax.learning.domain.CourceClassifyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CourceClassifyMapper {
    long countByExample(CourceClassifyExample example);

    int deleteByExample(CourceClassifyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CourceClassify record);

    int insertSelective(CourceClassify record);

    List<CourceClassify> selectByExample(CourceClassifyExample example);

    List<CourceClassify> getByParentCode(String parentCode);

    CourceClassify selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CourceClassify record, @Param("example") CourceClassifyExample example);

    int updateByExample(@Param("record") CourceClassify record, @Param("example") CourceClassifyExample example);

    int updateByPrimaryKeySelective(CourceClassify record);

    int updateByPrimaryKey(CourceClassify record);
}