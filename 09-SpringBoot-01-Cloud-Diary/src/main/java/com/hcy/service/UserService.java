package com.hcy.service;


import com.hcy.entity.TbUser;
import com.hcy.vo.ResultVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

public interface UserService {
    ResultVO login(String username, String password);

    ResultVO update(MultipartFile img, TbUser user);

    Integer checkNick(String nick);

}
