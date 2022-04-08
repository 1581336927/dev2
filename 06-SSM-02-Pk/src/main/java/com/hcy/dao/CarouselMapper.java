package com.hcy.dao;

import com.hcy.entity.Carousel;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarouselMapper {
    int  insertCarousel(Carousel carousel);

    int deleteCarousel(Integer id);

    Integer updateCarousel(Carousel carousel);

    List<Carousel> selectCarousel();
}
