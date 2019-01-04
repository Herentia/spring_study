package com.pb.mvc.views;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.Map;

/**
 * @author haohan
 * 12/26/2018 - 04:50 下午
 * 继承view，控制器可以将return"helloView"时，会跳转到该类并执行render方法
 * 需要在web.xml配置BeanNameViewResolver
 */
@Component
public class HelloView implements View {

    @Override
    public String getContentType() {
        return "text/html";
    }

    @Override
    public void render(Map<String, ?> map, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        httpServletResponse.getWriter().print("helloview" + new Date());
    }
}
