package com.hcy.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class FilterUser implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {


        //将请求和响应对象强转为支持HTTP协议的对象
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        //获取session这里需要用false
        HttpSession session = request.getSession(false);
        //获取请求的uri
        String uri = request.getRequestURI();

        // 判断是否以指定路径结尾路径结尾
        if (uri.endsWith("/login.jsp") || uri.endsWith("user/login")||uri.endsWith("js")||uri.endsWith("css")||uri.endsWith("jpg")||uri.endsWith("png")) {

            // 放行
            chain.doFilter(request, response);

            //如果session为空，说明没有登陆
        } else if (session == null) {

            // 重定向登陆页面
            response.sendRedirect("/login.jsp");

            //session不为空，并且user参数也不为空
        } else if (session.getAttribute("user") != null) {

            // 还行
            chain.doFilter(request, response);
        } else {
            // 跳转到登录页
            response.sendRedirect("/login.jsp");
        }
    }

    @Override
    public void destroy() {

    }
}
