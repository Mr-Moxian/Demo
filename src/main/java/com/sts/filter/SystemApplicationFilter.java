package com.sts.filter;

import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebFilter(filterName = "SystemApplicationFilter", urlPatterns = {"/*"},
        initParams = {@WebInitParam(name = "ignoredUrl", value = ".css#.js#.jpg#.png#.gif#.ico"),
                @WebInitParam(name = "filterPath",
                        value = "/user/login#/user/registerUser")})
public class SystemApplicationFilter implements Filter {

    private static final String FILTER_PATH = "filterPath";
    private static final String IGNORED_PATH = "ignoredUrl";

    private static final List<String> ignoredList = new ArrayList<>();
    private String[] allowUrls;
    private String[] ignoredUrls;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //初始化被允许的url以及不进行过滤的url类型
        String filterPath = filterConfig.getInitParameter(FILTER_PATH);
        if (!StringUtils.isEmpty(filterPath)) {
            allowUrls = filterPath.contains("#") ? filterPath.split("#") : new String[]{filterPath};
        }

        String ignoredPath = filterConfig.getInitParameter(IGNORED_PATH);
        if (!StringUtils.isEmpty(ignoredPath)) {
            ignoredUrls = ignoredPath.contains("#") ? ignoredPath.split("#") : new String[]{ignoredPath};
//            for (String ignoredUrl : ignoredUrls) {
//                ignoredList.add(ignoredUrl);
//            }

            ignoredList.addAll(Arrays.asList(ignoredUrls));
        }
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest servletRequest = (HttpServletRequest) request;
        HttpServletResponse servletResponse = (HttpServletResponse) response;
        String requestUrl = servletRequest.getRequestURI();

        //具体，比如：处理若用户未登录，则跳转到登录页
        Object userInfo = servletRequest.getSession().getAttribute("user");
        if(userInfo!=null) { //如果已登录，不阻止
            chain.doFilter(request, response);
            return;
        }
        servletResponse.sendRedirect("/index.html");
    }

    @Override
    public void destroy() {

    }
}
