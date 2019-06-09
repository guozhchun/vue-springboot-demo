package com.guozhchun.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.guozhchun.constant.CheckResult;
import com.guozhchun.service.LoginService;
import com.guozhchun.util.TokenUtil;
import com.guozhchun.vo.User;

@RestController
public class LoginController
{
    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Object login(@RequestBody User user)
    {
        String name = user.getName();
        String password = user.getPassword();
        CheckResult checkResult = loginService.checkParam(name, password);
        if (checkResult != CheckResult.SUCCESS)
        {
            return checkResult;
        }

        if (loginService.login(name, password) != CheckResult.SUCCESS)
        {
            return CheckResult.FAIL;
        }

        return TokenUtil.generateToken();
    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public void logout(HttpServletRequest request, HttpServletRequest reponse)
    {
        String token = request.getHeader("token");
        TokenUtil.removeToken(token);
    }
}
