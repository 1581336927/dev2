package com.hcy.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hcy.dao.UserMapper;
import com.hcy.entity.User;
import com.hcy.service.UserService;
import com.hcy.vo.DataVo;
import com.hcy.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public ResultVo getlist(Integer pageNum, Integer pageSize, Long id) {
        //返回给前端的结果
        ResultVo resultVo;

        //分页相关的参数
        DataVo<User> userDataVo;

        //结果中data对应的用户数组
        List<User> users;

        //说明传递了id，那就是findById
        if (id != null) {
            users = new ArrayList<>();
            //查询
            User user = userMapper.selectByPrimaryKey(id);
            //如果没有查到用户的情况
            if (user == null) {
                userDataVo = new DataVo<>(0L, users, pageNum, pageSize);

                resultVo = new ResultVo(4000, "查无此人", false, userDataVo);
            } else {
                //查到了用户扔到集合中
                users.add(user);

                userDataVo = new DataVo<>(1L, users, pageNum, pageSize);

                resultVo = new ResultVo(1000, "查到了用户", true, userDataVo);
            }
        } else {
            //开启分页
            PageHelper.startPage(pageNum, pageSize);

            users = userMapper.selectByExample(null);

            if (users.size() == 0) {
                userDataVo = new DataVo<>(0L, users, pageNum, pageSize);

                resultVo = new ResultVo(4100, "没有用户", false, userDataVo);
            } else {
                //查到了
                //封装pageInfo，为了获取总数量
                PageInfo<User> pageInfo = new PageInfo<>(users);

                userDataVo = new DataVo<>(pageInfo.getTotal(), users, pageNum, pageSize);

                resultVo = new ResultVo(1100, "用户查询成功", true, userDataVo);
            }

        }
        return resultVo;
    }

    @Override
    public ResultVo add(User user) {
        ResultVo resultVo;
        //判断是否存在创建时间，没有就添加
        if (user.getCreateTime()==null){
            user.setCreateTime(new Date());
        }
        //受影响的行数
        int affectedRows = userMapper.insertSelective(user);
        //判断受影响的行数
        if (affectedRows>0){
            resultVo=new ResultVo(1000,"添加用户成功",true,user);
        }else {
            resultVo=new ResultVo(5000,"添加用户失败",false,null);
        }
        //返回结果集
        return resultVo;
    }

    @Override
    public ResultVo update(User user) {
        int affectedRows = userMapper.updateByPrimaryKeySelective(user);

        ResultVo vo;

        if (affectedRows > 0) {
            // 修改完成之后，再重新查询一次，保证返回给前端的是最新最全的数据
            user = userMapper.selectByPrimaryKey(user.getId());

            vo = new ResultVo(1000, "修改用户成功！！", true, user);
        } else {
            vo = new ResultVo(5000, "修改用户失败！！", false, null);
        }

        return vo;
    }

    @Override
    public ResultVo delete(Long id) {
        int affectedRows = userMapper.deleteByPrimaryKey(id);
        ResultVo vo;

        if (affectedRows > 0) {

            vo = new ResultVo(1000, "删除用户成功！！", true, null);
        } else {
            vo = new ResultVo(5000, "删除用户失败！！", false, null);
        }

        return vo;
    }
}