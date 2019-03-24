package com.uerax.learning.mapper;

import com.uerax.learning.domain.UserCource;
import com.uerax.learning.domain.UserCourceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserCourceMapper {
    long countByExample(UserCourceExample example);

    int deleteByExample(UserCourceExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserCource record);

    int insertSelective(UserCource record);

    List<UserCource> selectByExample(UserCourceExample example);

    UserCource selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserCource record, @Param("example") UserCourceExample example);

    int updateByExample(@Param("record") UserCource record, @Param("example") UserCourceExample example);

    int updateByPrimaryKeySelective(UserCource record);

    int updateByPrimaryKey(UserCource record);
}