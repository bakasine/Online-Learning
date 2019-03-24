package com.uerax.learning.mapper;

import com.uerax.learning.domain.Carousel;
import com.uerax.learning.domain.CarouselExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CarouselMapper {
    long countByExample(CarouselExample example);

    int deleteByExample(CarouselExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Carousel record);

    int insertSelective(Carousel record);

    List<Carousel> selectByExample(CarouselExample example);

    List<Carousel> selectEnable();
    Carousel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Carousel record, @Param("example") CarouselExample example);

    int updateByExample(@Param("record") Carousel record, @Param("example") CarouselExample example);

    int updateByPrimaryKeySelective(Carousel record);

    int updateByPrimaryKey(Carousel record);
}