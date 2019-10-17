package com.sts.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.sts.demo.entities.ResultVO;
import com.sts.demo.entities.datasource.UserVO;
import com.sts.demo.entities.datasource.LoginParamVO;
import com.sts.demo.service.login.ILoginService;
import com.sts.demo.util.ImageUtil;
import com.sts.demo.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

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
        Object imgCode = request.getSession().getAttribute("img_code");
        if(imgCode != null && params != null && params.getCheckCode() != null && ! params.getCheckCode().equalsIgnoreCase(imgCode.toString())){
            //校验码错误
            result.setMessage("验证码错误!");
            result.setSuccess(false);
        }
        //判断会话中是否有用户，若有，则说明已登录，判断与当前输入的用户名是否一致
        else if(user != null){
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

    /**登出*/
    @RequestMapping(value = "/loginout",method = RequestMethod.GET)
    @ResponseBody
    public ResultVO loginOut(HttpServletResponse response, HttpServletRequest request){
        ResultVO result = new ResultVO();
        try {
            request.getSession().removeAttribute("userinfo");
            response.sendRedirect("/login.html");
        }catch (Exception e){
            result.setSuccess(false);
            result.setMessage(e.getMessage());
        }
        return result;
    }

    @RequestMapping("/imageCode")
    @ResponseBody
    public JSONObject produceImageCode(HttpSession session) throws IOException {
        JSONObject jobj = new JSONObject();
        ImageUtil iu = new ImageUtil();
        String code = iu.createImageWithVerifyCode(120,30,4,session);
        code = "data:image/png;base64,"+code;
        jobj.put("png_base64",code);
        return jobj;
    }
}
