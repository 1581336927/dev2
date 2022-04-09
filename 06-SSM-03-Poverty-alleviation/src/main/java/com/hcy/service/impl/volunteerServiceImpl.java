package com.hcy.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hcy.dao.VolunteerRecruitmentMapper;
import com.hcy.entity.User;
import com.hcy.entity.VolunteerRecruitment;
import com.hcy.service.VolunteerService;
import com.hcy.vo.DataVo;
import com.hcy.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class volunteerServiceImpl implements VolunteerService {
    @Autowired
    private VolunteerRecruitmentMapper volunteerRecruitmentMapper;

    @Override
    public ResultVo getlist(Integer pageNum, Integer pageSize, Long id) {
        ResultVo resultVo;

        DataVo<VolunteerRecruitment> recruitmentDataVo;

        List<VolunteerRecruitment> list;

        if (id != null) {

            list = new ArrayList<>();
            //如果没有传入id不等于null，说明传递了id查询一条数据
            VolunteerRecruitment recruitment = volunteerRecruitmentMapper.selectByPrimaryKey(id);

            if (list == null) {
                recruitmentDataVo = new DataVo<>(0L, list, pageNum, pageSize);

                resultVo = new ResultVo(4000, "查无此志愿者", false, recruitmentDataVo);
            } else {
                //如果查询单个数据点击数量需要加一
                click(recruitment.getId(), null);
                //更新点击次数
                recruitment.setClickNum(recruitment.getClickNum() + 1);

                //查到了用户扔到集合中
                list.add(recruitment);

                recruitmentDataVo = new DataVo<>(1L, list, pageNum, pageSize);

                resultVo = new ResultVo(1000, "查到了志愿者", true, recruitmentDataVo);
            }

        } else {
            //开启分页
            PageHelper.startPage(pageNum, pageSize);
            //查询全部
            list = volunteerRecruitmentMapper.selectByExample(null);
            if (list.size() == 0) {
                recruitmentDataVo = new DataVo<>(0L, list, pageNum, pageSize);

                resultVo = new ResultVo(4100, "查无志愿者", false, recruitmentDataVo);
            } else {
                PageInfo<VolunteerRecruitment> pageInfo = new PageInfo<>(list);

                recruitmentDataVo = new DataVo<>(pageInfo.getTotal(), list, pageNum, pageSize);

                resultVo = new ResultVo(1000, "查到了志愿者", true, recruitmentDataVo);
            }


        }

        return resultVo;
    }

    @Override
    public ResultVo add(VolunteerRecruitment volunteerRecruitment) {
        ResultVo vo;
        // 判断是否存在创建时间，没有就自己加上
        if (volunteerRecruitment.getCreateTime() == null) {
            volunteerRecruitment.setCreateTime(new Date());
        }

        // 新创建的扶贫政策，点击量应该是0
        volunteerRecruitment.setClickNum(0);
        volunteerRecruitment.setLastClickTime(null);

        int affectedRows = volunteerRecruitmentMapper.insertSelective(volunteerRecruitment);

        if (affectedRows > 0) {
            vo = new ResultVo(1000, "添加志愿者招聘信息成功！！", true, volunteerRecruitment);
        } else {
            vo = new ResultVo(5000, "添加志愿者招聘信息失败！！", false, null);
        }

        return vo;

    }

    @Override
    public ResultVo update(VolunteerRecruitment volunteerRecruitment) {
        ResultVo resultVo;
        int affectedRows = volunteerRecruitmentMapper.updateByPrimaryKeySelective(volunteerRecruitment);
        //判断受影响的行数
        if (affectedRows > 0) {
            VolunteerRecruitment volunteerRecruitment1 = volunteerRecruitmentMapper.selectByPrimaryKey(volunteerRecruitment.getId());

            resultVo = new ResultVo(1000, "修改志愿者成功", true, volunteerRecruitment1);

        } else {
            resultVo = new ResultVo(5000, "修改志愿者失败", false, null);
        }
        return resultVo;
    }

    @Override
    public ResultVo delete(Long id) {
        int affectedRows = volunteerRecruitmentMapper.deleteByPrimaryKey(id);
        ResultVo vo;

        if (affectedRows > 0) {

            vo = new ResultVo(1000, "删除志愿者成功！！", true, null);
        } else {
            vo = new ResultVo(5000, "删除志愿者失败！！", false, null);
        }

        return vo;
    }

    @Override
    public ResultVo click(Long id, Date lastClickTime) {

        if (lastClickTime == null) {
            lastClickTime = new Date();
        }

        Integer affectedRows = volunteerRecruitmentMapper.click(id, lastClickTime);
        ResultVo vo;

        if (affectedRows > 0) {
            vo = new ResultVo(1000, "扶贫志愿者招聘浏览量加1成功！！", true, null);
        } else {
            vo = new ResultVo(5000, "扶贫志愿者招聘浏览量加1失败！！", false, null);
        }

        return vo;

    }
}
