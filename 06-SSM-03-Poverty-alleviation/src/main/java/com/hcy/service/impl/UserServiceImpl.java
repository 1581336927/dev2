package com.hcy.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hcy.dao.UserMapper;
import com.hcy.entity.User;
import com.hcy.entity.UserExample;
import com.hcy.service.UserService;
import com.hcy.vo.DataVo;
import com.hcy.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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

        //受影响的行数
        int affectedRows = userMapper.insertSelective(user);
        //判断受影响的行数
        if (affectedRows > 0) {
            resultVo = new ResultVo(1000, "添加用户成功", true, user);
        } else {
            resultVo = new ResultVo(5000, "添加用户失败", false, null);
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

    @Override
    public ResultVo selectLike(String params) {
        ResultVo resultVo;
        if (params == null) {
            resultVo = new ResultVo(4100, "请输入参数", false, null);
        } else {
            List<User> users = userMapper.selectLike("%" + params + "%");

            if (users.size() == 0) {

                resultVo = new ResultVo(4100, "暂无数据", false, null);
            } else {
                resultVo = new ResultVo(200, "查到了数据", true, users);
            }

        }
        return resultVo;
    }

    @Override
    public ResultVo login(String username, String password) {
        ResultVo vo = new ResultVo();
        vo.setCode(-1);
        vo.setMessage("登陆失败");
        vo.setSuccess(false);
        vo.setData(null);

        UserExample example = new UserExample();

        UserExample.Criteria criteria = example.createCriteria();

        criteria.andUsernameEqualTo(username);

        List<User> users = userMapper.selectByExample(example);

        if (users.size() > 0) {
            User user = users.get(0);

            if (user.getPassword().equals(password)) {
                vo.setSuccess(true);
                vo.setMessage("登陆成功");
                vo.setCode(1);
                user.setPassword(null);

                //盐值
                String salt=String.valueOf((int)((Math.random()*9+1)*100000));


                Map<String, Object> headers = new HashMap<>();

                headers.put("alg", "HS256");

                headers.put("typ", "JWT");

                String token = JWT.create()
                        .withHeader(headers)
                        //主题
                        .withSubject("登陆权限验证")
                        //签发着
                        .withIssuer("admin")
                        //签发着日期
                        .withIssuedAt(new Date())
                        //过期时间
                        .withExpiresAt(new Date(System.currentTimeMillis() + 1000 * 24))
                        .withClaim("id", user.getId())
                        .withClaim("salt", salt)
                        .withClaim("username", user.getUsername())
                        //使用盐值进行签发
                        .sign(Algorithm.HMAC256(salt));

                Map<String, Object> result = new HashMap<>();

                result.put("user",user);
                result.put("token",token);

                vo.setData(result);
            } else {
                vo.setCode(-2);
                vo.setMessage("登陆失败，请检查用户名和密码");

            }
        }
        return vo;
    }
}

