package com.hcy.service;

import com.hcy.entity.User;
import com.hcy.vo.ResultVo;

public interface UserService {
    ResultVo getlist(Integer pageNum, Integer pageSize, Long id);

    ResultVo add(User user);

    ResultVo update(User user);

    ResultVo delete(Long id);

}
