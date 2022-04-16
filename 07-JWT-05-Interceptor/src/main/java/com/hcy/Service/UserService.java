package com.hcy.Service;

import com.hcy.vo.UserVO;

public interface UserService {
    UserVO login(String username, String password);
}
