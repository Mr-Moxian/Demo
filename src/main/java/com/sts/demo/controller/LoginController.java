package com.sts.demo.controller;

import com.sts.demo.entities.ResultVO;
import com.sts.demo.entities.datasource.UserVO;
import com.sts.demo.entities.datasource.LoginParamVO;
import com.sts.demo.service.login.ILoginService;
import com.sts.demo.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/user")
public class LoginController {

    @Autowired
    private ILoginService iLoginService;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public ResultVO login(LoginParamVO params, HttpServletRequest request){
        ResultVO result = new ResultVO();
        Object user = request.getSession().getAttribute("userinfo");
        //判断会话中是否有用户，若有，则说明已登录，判断与当前输入的用户名是否一致
        if(user != null){
            UserVO userInfo = (UserVO) user;
            if(userInfo != null && !StringUtils.isEmpty(params.getUsername()) && params.getUsername().equalsIgnoreCase(userInfo.getUsername())){
                //该用户已登录，无需再次登录
                result.setMessage("user already login");
                result.setSuccess(true);
            }
        }
        else{
            result = iLoginService.login(params);
            UserVO userVO = new UserVO();
            userVO.setUsername(params.getUsername());
            userVO.setPassword(params.getPassword());
            if(result.isSuccess()){
                request.getSession().setAttribute("userinfo",userVO);
            }
        }

        return result;
    }
}
