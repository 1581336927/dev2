package com.hcy.service.impl;

import com.hcy.vo.UserVO;
import com.hcy.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public UserVO Login(String username, String password) {
        UserVO userVO=null;
        // 登录成功
        if (username.equals("易烊千玺") && password.equals("123456")) {
            userVO = new UserVO();
            userVO.setId(1);
            userVO.setUsername(username);
            userVO.setLastAccessTime(new Date());
        }
        return userVO;
    }
}
