package com.sts.demo.filter;

import org.springframework.stereotype.Component;
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
@WebFilter(filterName = "SystemApplicationFilter", urlPatterns = {"/*"},
        initParams = {@WebInitParam(name = "ignoredUrl", value = ".css#.js#.jpg#.png#.gif#.ico"),
                @WebInitParam(name = "filterPath",
                        value = "/user/login#/user/registerUser")})
public class SystemApplicationFilter implements Filter {

    //发现通过注解注入的参数没法读取，暂先注掉，有时间排查
    //private static final String FILTER_PATH = "filterPath";
    //private static final String IGNORED_PATH = "ignoredUrl";

    private static final String FILTER_PATH = "/user/login#/user/registerUser";
    private static final String IGNORED_PATH = ".css#.js#.jpg#.png#.gif#.ico#.woff2#.eot";

    private static final List<String> ignoredList = new ArrayList<>();
    private String[] allowUrls;
    private String[] ignoredUrls;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //初始化被允许的url以及不进行过滤的url类型
        /*String filterPath = filterConfig.getInitParameter(FILTER_PATH);
        if (!StringUtils.isEmpty(filterPath)) {
            allowUrls = filterPath.contains("#") ? filterPath.split("#") : new String[]{filterPath};
        }

        String ignoredPath = filterConfig.getInitParameter(IGNORED_PATH);
        if (!StringUtils.isEmpty(ignoredPath)) {
            ignoredUrls = ignoredPath.contains("#") ? ignoredPath.split("#") : new String[]{ignoredPath};
            ignoredList.addAll(Arrays.asList(ignoredUrls));
        }*/

        if (!StringUtils.isEmpty(FILTER_PATH)) {
            allowUrls = FILTER_PATH.contains("#") ? FILTER_PATH.split("#") : new String[]{FILTER_PATH};
        }

        if (!StringUtils.isEmpty(IGNORED_PATH)) {
            ignoredUrls = IGNORED_PATH.contains("#") ? IGNORED_PATH.split("#") : new String[]{IGNORED_PATH};
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

        if(verify(ignoredList,requestUrl)){
            chain.doFilter(request, response);
            return;
        }
        if(requestUrl != null && requestUrl.equals("/login.html")){
            chain.doFilter(request, response);
            return;
        }
        servletResponse.sendRedirect("/login.html");
    }

    @Override
    public void destroy() {

    }

    private static String regexPrefix = "^.*";
    private static String regexSuffix = ".*$";

    private static boolean verify(List<String> ignoredList, String url) {
        for (String regex : ignoredList) {
            Pattern pattern = Pattern.compile(regexPrefix + regex + regexSuffix);
            Matcher matcher = pattern.matcher(url);
            if (matcher.matches()) {
                return true;
            }
        }
        return false;
    }
}
