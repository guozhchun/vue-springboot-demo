package com.guozhchun.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.guozhchun.util.TokenUtil;

@Component
public class AuthFilter implements Filter
{
    private boolean needAuth(HttpServletRequest request)
    {
        String requestURI = request.getRequestURI();
        String requestMethod = request.getMethod();
        if (StringUtils.equals("/machine", requestURI))
        {
            if (StringUtils.equals("POST", requestMethod)
                    || StringUtils.equals("PUT", requestMethod)
                    || StringUtils.equals("DELETE", requestMethod))
            {
                return true;
            }

            return false;
        }

        if (StringUtils.equals("/virtualMachine", requestURI))
        {
            return true;
        }

        return false;
    }

    private void validateToken(String token)
    {
        if (TokenUtil.isTokenExpired(token))
        {
            throw new RuntimeException("The token is invalid");
        }
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException
    {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String token = request.getHeader("token");
        if (needAuth(request))
        {
            validateToken(token);
        }

        if (StringUtils.isNotEmpty(token))
        {
            TokenUtil.updateTime(token);
        }
        filterChain.doFilter(servletRequest,servletResponse);
    }
}
