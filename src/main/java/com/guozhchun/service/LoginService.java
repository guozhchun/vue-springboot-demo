package com.guozhchun.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.guozhchun.constant.CheckResult;
import com.guozhchun.util.EncryptUtil;

@Service
public class LoginService
{
    private static final String ADMIN_ENCRYPTION_PASSWORD = "c7ad44cbad762a5da0a452f9e854fdc1e0e7a52a38015f23f3eab1d80b931dd472634dfac71cd34ebc35d16ab7fb8a90c81f975113d6c7538dc69dd8de9077ec";

    public CheckResult checkParam(String name, String password)
    {
        if (StringUtils.isEmpty(name))
        {
            return CheckResult.USERNAME_EMPTY;
        }

        if (StringUtils.isEmpty(password))
        {
            return CheckResult.PASSWORD_EMPTY;
        }

        return CheckResult.SUCCESS;
    }

    public CheckResult login(String name, String password)
    {
        String encryptionPassword = EncryptUtil.encrypt(password);
        if (StringUtils.equals("admin", name) && StringUtils.equals(ADMIN_ENCRYPTION_PASSWORD, encryptionPassword))
        {
            return CheckResult.SUCCESS;
        }

        return CheckResult.FAIL;
    }
}
