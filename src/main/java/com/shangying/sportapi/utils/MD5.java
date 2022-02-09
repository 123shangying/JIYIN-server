package com.shangying.sportapi.utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

/**
 * Created with IntelliJ IDEA.
 * Email: shangying611@gmail.com
 * Blog:  https://shangying.host/
 * Date: 2021/10/6.
 * Time: 11:27.
 * Explain:MD5加密工具类
 * @author shangying
 */
public class MD5 {

    public String md5(String s) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] bytes = md.digest(s.getBytes(StandardCharsets.UTF_8));
            return toHex(bytes);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String toHex(byte[] bytes) {
        final char[] HEX_DIGITS = "0123456789ABCDEF".toCharArray();
        StringBuilder ret = new StringBuilder(bytes.length * 2);
        for (byte aByte : bytes) {
            ret.append(HEX_DIGITS[(aByte >> 4) & 0x0f]);
            ret.append(HEX_DIGITS[aByte & 0x0f]);
        }
        return ret.toString();
    }

}
