package com.hcy.service;

import com.hcy.vo.UserVO;

public interface UserService {
    UserVO login(String username,String password);
}
