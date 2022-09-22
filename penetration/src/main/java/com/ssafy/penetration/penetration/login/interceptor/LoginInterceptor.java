package com.ssafy.penetration.penetration.login.interceptor;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Slf4j
public class LoginInterceptor implements HandlerInterceptor {

    public static final String LOG_ID = "logId";

    // HTTP 요청 → WAS → 필터 → 서블릿 → 인터셉터1 → 인터셉터2 → 컨트롤러
    // preHandle : 컨트롤러 호출 전에 호출된다.
    // postHandle : 컨트롤러 호출 후에 호출된다.
    // afterCompletion : 뷰가 렌더링 된 이후에 호출된다.

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();
        String uuid = UUID.randomUUID().toString();

        request.setAttribute(LOG_ID, uuid);

        if (handler instanceof HandlerMethod) {
            HandlerMethod hm = (HandlerMethod) handler;
        }

        log.info("LogIntercpetor perHandle REQUEST [{}][{}][{}]", uuid, requestURI, handler);

        return true;
    }


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("LogInterceptor postHandle [{}]", modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        String requestURI = request.getRequestURI();
        String logId = (String) request.getAttribute(LOG_ID);
        log.info("afterCompletion {} {}", requestURI, logId);

        if (ex != null) {
            log.error("afterCompletion error!", ex);
        }
    }
}