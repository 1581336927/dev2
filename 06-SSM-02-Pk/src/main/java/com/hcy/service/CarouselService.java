package com.hcy.service;

import com.hcy.entity.Carousel;

import java.util.Map;

public interface CarouselService {
    Map<String, Object> insertCarousel(Carousel carousel);

    Map<String, Object> deleteCarousel(Integer id);

    Map<String, Object> updateCarousel(Carousel carousel);

    Map<String, Object> selectCarousel();
}
