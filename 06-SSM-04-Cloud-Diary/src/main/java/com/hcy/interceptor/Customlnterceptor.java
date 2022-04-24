//package com.hcy.interceptor;
//
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
////自定义拦截器
//public class Customlnterceptor implements HandlerInterceptor {
//    //前置通知，在Controller执行前执行
//    //返回值代表是否被拦截
//    //返回值是true就对应放行否则就放行
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        if (request.getRequestURI().contains("user/login")) {
//            return true;
//        }
//        if (request.getSession(false).getAttribute("user") == null) {
//
//            response.sendRedirect("/user/login");
//            return false;
//        }
//        return true;
//    }
//
//    //在Controller执行之后执行此方法
//    @Override
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//        System.out.println("拦截器后置拦截");
//    }
//
//    //视图解析器渲染视图之后执行此方法，一般用于资源的释放
//    @Override
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//        System.out.println("页面渲染之后执行");
//    }
//}
