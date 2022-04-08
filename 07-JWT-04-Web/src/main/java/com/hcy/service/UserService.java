package com.hcy.service;

import com.hcy.vo.UserVO;

public interface UserService {
    UserVO Login(String username,String password);
}
