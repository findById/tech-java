package org.cn.web.rbac.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import java.util.UUID;

public class AuthUtil {

    public static String initPassword(int length) {
        String template = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789_-.";
        Random random = new Random();
        String result = "";
        for (int i = 0; i < length; i++) {
            result += template.charAt(random.nextInt(template.length()) % template.length());
        }
        return result;
    }

    public static String initSalt() {
        return UUID.randomUUID().toString();
    }

    public static String encode(String password, String salt) {
        if (password == null) {
            return "";
        }
        if (salt == null) {
            salt = "";
        }
        return digest(password + "_SALT_" + salt, "SHA-1");
    }

    private static String digest(String input, String algorithm) {
        MessageDigest digest = null;
        try {
            digest = MessageDigest.getInstance(algorithm);
            digest.reset();
            digest.update(input.getBytes());
            byte[] bytes = digest.digest();
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < bytes.length; i++) {
                if (Integer.toHexString(0xFF & bytes[i]).length() == 1) {
                    sb.append("0").append(Integer.toHexString(0xFF & bytes[i]));
                } else {
                    sb.append(Integer.toHexString(0xFF & bytes[i]));
                }
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } finally {
        }
        return "";
    }

    public static boolean verify(String signature, String salt, String password) {
        if (signature == null || "".equals(signature)) {
            return false;
        }
        if (signature.equals(AuthUtil.encode(password, salt))) {
            return true;
        }
        return false;
    }

}
