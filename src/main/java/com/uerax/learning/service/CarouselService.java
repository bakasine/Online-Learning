package com.uerax.learning.service;

import com.uerax.learning.domain.Carousel;

import java.util.List;

/**
 * @author uerax
 * @date 2019/3/24 21:47
 */
public interface CarouselService {

    public List<Carousel> getCarousel();
    public void addCarousel(Carousel carousel);
    public void updateCarousel(Carousel carousel);
    public void deleteCarousel(Carousel carousel);
    public List<Carousel> getEnableCarousel();
}
