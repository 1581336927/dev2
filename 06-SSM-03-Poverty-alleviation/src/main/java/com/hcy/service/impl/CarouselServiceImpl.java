package com.hcy.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hcy.dao.CarouselMapper;
import com.hcy.entity.Carousel;
import com.hcy.entity.User;
import com.hcy.service.CarouselService;
import com.hcy.vo.DataVo;
import com.hcy.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarouselServiceImpl implements CarouselService {
    @Autowired
    private CarouselMapper carouselMapper;

    @Override
    public ResultVo getlist(Integer pageNum, Integer pageSize, Integer id) {
        // 返回给前端的结果
        ResultVo resultVO;

        // 分页相关的参数
        DataVo<Carousel> carouselDataVO;

        // 结果中data对应的用户数组
        List<Carousel> carousels;

        // 说明传递了id，那就是findById
        if (id != null) {
            carousels = new ArrayList<>();

            // 查询
            Carousel carousel = carouselMapper.selectByPrimaryKey(id);

            // 没有查到用户的情况
            if (carousel == null) {
                carouselDataVO = new DataVo<>(0L, carousels, pageNum, pageSize);

                resultVO = new ResultVo(4000, "查无此图!", false, carouselDataVO);
            } else {
                // 查到了用户扔到集合中
                carousels.add(carousel);

                carouselDataVO = new DataVo<>(1L, carousels, pageNum, pageSize);

                resultVO = new ResultVo(1000, "查到了该图!", true, carouselDataVO);
            }
        } else {
            // 开启分页
            PageHelper.startPage(pageNum, pageSize);

            carousels = carouselMapper.selectByExample(null);

            // 如果数据库是空的，一个人都没查到
            if (carousels.size() == 0) {
                carouselDataVO = new DataVo<>(0L, carousels, pageNum, pageSize);

                resultVO = new ResultVo(4100, "啥图都没!!!", false, carouselDataVO);
                // 查到了
            } else {
                // 封装pageInfo，为了获取总数据量
                PageInfo<Carousel> pageInfo = new PageInfo<>(carousels);

                carouselDataVO = new DataVo<>(pageInfo.getTotal(), carousels, pageNum, pageSize);

                resultVO = new ResultVo(1100, "轮播图查询成功！！！!", true, carouselDataVO);

            }
        }

        return resultVO;
    }

    @Override
    public ResultVo add(Carousel carousel) {
        ResultVo vo;
        //如果没有告知轮播图的状态，默认是不可用的。
        if (carousel.getAvailable() == null) {
            carousel.setAvailable(false);
        }
        int affectedRows = carouselMapper.insertSelective(carousel);
        if (affectedRows > 0) {
            vo = new ResultVo(1000, "添加用户成功", true, carousel);
        } else {
            vo = new ResultVo(5000, "添加用户失败", false, null);
        }
        //返回结果集
        return vo;
    }

    @Override
    public ResultVo update(Carousel carousel) {
        int affectedRows = carouselMapper.updateByPrimaryKeySelective(carousel);

        ResultVo vo;

        if (affectedRows > 0) {
            // 修改完成之后，再重新查询一次，保证返回给前端的是最新最全的数据
            Carousel carousel1 = carouselMapper.selectByPrimaryKey(carousel.getId());

            vo = new ResultVo(1000, "修改轮播图成功！！", true, carousel1);
        } else {
            vo = new ResultVo(5000, "修改轮播图失败！！", false, null);
        }

        return vo;
    }

    @Override
    public ResultVo delete(Integer id) {
        int affectedRows = carouselMapper.deleteByPrimaryKey(id);
        ResultVo vo;

        if (affectedRows > 0) {

            vo = new ResultVo(1000, "删除轮播图成功！！", true, null);
        } else {
            vo = new ResultVo(5000, "删除轮播图失败！！", false, null);
        }

        return vo;
    }
}
