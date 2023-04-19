package zian.example.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.Interceptor;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @ClassName LoginInterceptor
 * @Description 登录检查
 * @Author ljzhang
 * @Date 2023/4/17 11:04
 * @Version 1.0
 */
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //登录逻辑检测
        log.info("preHandle拦截的请求路径{}",request.getRequestURI());
        HttpSession session = request.getSession();
        String username = (String)session.getAttribute("username");
        log.info("用户 {} 正在登录",username);
        if(StringUtils.isEmpty(username)){
            request.setAttribute("msg","请重新登录");
            request.getRequestDispatcher("/").forward(request, response);
            return false;
        }
        return HandlerInterceptor.super.preHandle(request,response,handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
