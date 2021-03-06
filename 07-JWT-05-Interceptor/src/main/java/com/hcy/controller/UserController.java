package com.hcy.controller;

import com.auth0.jwt.JWT;
import com.hcy.Service.UserService;
import com.hcy.entity.User;
import com.hcy.util.JwtUtil;
import com.hcy.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("login")
    public Map<String, Object> login(User user) {
        UserVO userVO = userService.login(user.getUsername(), user.getPassword());

        Map<String, Object> map = new HashMap<>();

        if (userVO != null) {
            map.put("code", 200);
            map.put("success", true);
            map.put("message", "登陆成功");
            map.put("data", userVO);

            Map<String, Object> claim = new HashMap<>();

            claim.put("username", userVO.getUsername());
            claim.put("lassAccessTime", userVO.getLastAccessTime());

            String token = JwtUtil.getToken(claim, 20);

            map.put("token", token);
        } else {
            map.put("code", -1);
            map.put("success", false);
            map.put("message", "登陆失败");
            map.put("data", null);
        }
        return map;
    }


    @RequestMapping("verify")
    public Map<String, Object> verify(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        map.put("code", 200);
        map.put("success", true);
        map.put("message", "验证成功！");
        map.put("data", request.getAttribute("claim"));

        return map;
    }
}
