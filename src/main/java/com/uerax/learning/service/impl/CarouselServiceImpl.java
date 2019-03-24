package com.uerax.learning.service.impl;

import com.uerax.learning.domain.Carousel;
import com.uerax.learning.mapper.CarouselMapper;
import com.uerax.learning.service.CarouselService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author uerax
 * @date 2019/3/24 21:47
 */
@Service
public class CarouselServiceImpl implements CarouselService {

    @Autowired
    private CarouselMapper carouselMapper;

    @Override
    public List<Carousel> getCarousel() {
        return carouselMapper.selectByExample(null);
    }

    @Override
    public void addCarousel(Carousel carousel) {
        carouselMapper.insertSelective(carousel);
    }

    @Override
    public void updateCarousel(Carousel carousel) {
        carouselMapper.updateByPrimaryKeySelective(carousel);
    }

    @Override
    public void deleteCarousel(Carousel carousel) {
        carouselMapper.deleteByPrimaryKey(carousel.getId());
    }

    @Override
    public List<Carousel> getEnableCarousel() {
        return carouselMapper.selectEnable();
    }
}
