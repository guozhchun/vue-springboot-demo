package com.guozhchun.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptUtil
{
    // reference: https://www.breakyizhan.com/java/6772.html
    public static String encrypt(String text)
    {
        // getInstance() method is called with algorithm SHA-512
        MessageDigest md = null;
        try
        {
            md = MessageDigest.getInstance("SHA-512");
        }
        catch (NoSuchAlgorithmException e)
        {
            throw new RuntimeException("Encrypt fail.", e);
        }

        // digest() method is called
        // to calculate message digest of the input string
        // returned as array of byte
        byte[] messageDigest = md.digest(text.getBytes());

        // Convert byte array into signum representation
        BigInteger no = new BigInteger(1, messageDigest);

        // Convert message digest into hex value
        String hashtext = no.toString(16);

        // Add preceding 0s to make it 32 bit
        while (hashtext.length() < 32)
        {
            hashtext = "0" + hashtext;
        }

        // return the HashText
        return hashtext;
    }
}
