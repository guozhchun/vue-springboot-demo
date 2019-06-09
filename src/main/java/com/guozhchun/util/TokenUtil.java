package com.guozhchun.util;

import java.util.Date;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.lang3.StringUtils;

public class TokenUtil
{
    // 30 分钟
    private static final int DURATION_TIME = 30 * 60 * 1000;

    private static ConcurrentHashMap<String, Date> tokenMap = new ConcurrentHashMap<>();

    private TokenUtil()
    {

    }

    public static String generateToken()
    {
        String token = UUID.randomUUID().toString();
        Date date = new Date();
        tokenMap.putIfAbsent(token, date);
        return token;
    }

    public static void updateTime(String token)
    {
        tokenMap.replace(token, new Date());
    }

    public static boolean isTokenExpired(String token)
    {
        if (StringUtils.isEmpty(token))
        {
            throw new RuntimeException("The token is invalid");
        }

        Date date = tokenMap.get(token);
        if (date == null)
        {
            throw new RuntimeException("The token is invalid");
        }

        Date currentDate = new Date();
        if (date.getTime() + DURATION_TIME < currentDate.getTime())
        {
            return true;
        }

        return false;
    }

    public static void removeToken(String token)
    {
        tokenMap.remove(token);
    }
}
