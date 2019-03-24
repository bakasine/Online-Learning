package com.uerax.learning.mapper;

import com.uerax.learning.domain.Cource;
import com.uerax.learning.domain.CourceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CourceMapper {
    long countByExample(CourceExample example);

    int deleteByExample(CourceExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Cource record);

    int insertSelective(Cource record);

    List<Cource> selectByExample(CourceExample example);

    Cource selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Cource record, @Param("example") CourceExample example);

    int updateByExample(@Param("record") Cource record, @Param("example") CourceExample example);

    int updateByPrimaryKeySelective(Cource record);

    int updateByPrimaryKey(Cource record);
}