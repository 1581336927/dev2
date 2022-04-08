package com.hcy.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hcy.vo.ResultVO;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

public class CacheInterceptor implements HandlerInterceptor {

    //在访问Controller之前先查询缓存如果能查到直接返回
    //查不到在执行控制器
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("查询缓存");
        HttpSession session = request.getSession(false);
        //如果session为空，说明是第一次访问直接放行
        if (session==null){
            return true;
        }
        Object foods = session.getAttribute("foods");
        //不是第一次访问但是第一次执行此方法 直接放行
        if (foods==null){
            return true;
        }
        System.out.println("查到了缓存");
        ResultVO vo = new ResultVO(200, "查到了缓存", true, foods);

        String json = new ObjectMapper().writeValueAsString(vo);

        response.setContentType("application/json;charset=UTF-8");
        
        response.getWriter().write(json);
        return false;
    }


    //将执行的结果放在缓存中
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        if (modelAndView != null){
            Map<String, Object> model = modelAndView.getModel();
            Object foods = model.get("foods");
            System.out.println("放到缓存中");
            request.getSession(true).setAttribute("foods",foods);

            ResultVO vo = new ResultVO(200, "没有查到缓存", true, foods);

            String json = new ObjectMapper().writeValueAsString(vo);

            response.setContentType("application/json;charset=UTF-8");

            response.getWriter().write(json);

        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
