package com.cniao5.common.network.support;

import androidx.annotation.Nullable;

import com.blankj.utilcode.util.EncryptUtils;
import com.cniao5.common.network.config.CniaoConfigKt;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * 作者： 志威  zhiwei.org
 * 主页： Github: https://github.com/zhiwei1990
 * 日期： 2020年08月22日 21:33
 * 签名： 天行健，君子以自强不息；地势坤，君子以厚德载物。
 *      _              _           _     _   ____  _             _ _
 *     / \   _ __   __| |_ __ ___ (_) __| | / ___|| |_ _   _  __| (_) ___
 *    / _ \ | '_ \ / _` | '__/ _ \| |/ _` | \___ \| __| | | |/ _` | |/ _ \
 *   / ___ \| | | | (_| | | | (_) | | (_| |  ___) | |_| |_| | (_| | | (_) |
 *  /_/   \_\_| |_|\__,_|_|  \___/|_|\__,_| |____/ \__|\__,_|\__,_|_|\___/  -- 志威 zhiwei.org
 *
 * You never know what you can do until you try !
 * ----------------------------------------------------------------
 */
public class CniaoUtils {

    private CniaoUtils() {
    }

    /**
     * 中文转 unicode
     *
     * @param string
     * @return
     */
    public static String unicodeEncode(String string) {
        char[] utfBytes = string.toCharArray();
        String unicodeBytes = "";
        for (int i = 0; i < utfBytes.length; i++) {
            String hexB = Integer.toHexString(utfBytes[i]);
            if (hexB.length() <= 2) {
                hexB = "00" + hexB;
            }
            unicodeBytes = unicodeBytes + "\\u" + hexB;
        }
        return unicodeBytes;
    }

    /**
     * unicode 转中文
     *
     * @param string
     * @return
     */
    public static String unicodeDecode(String string) {
        Pattern pattern = Pattern.compile("(\\\\u(\\p{XDigit}{4}))");
        Matcher matcher = pattern.matcher(string);
        char ch;
        while (matcher.find()) {
            ch = (char) Integer.parseInt(matcher.group(2), 16);
//            Integer.valueOf("", 16);
            string = string.replace(matcher.group(1), ch + "");
        }
        return string;
    }

    /**
     * 解析返回的data数据
     *
     * @param dataStr 未解密的响应数据
     * @return 解密后的数据String
     */
    @Nullable
    public static String decodeData(@Nullable String dataStr) {
        //java代码，无自动null判断，需要自行处理
        if (dataStr != null) {
            return new String(EncryptUtils.decryptBase64AES(
                    dataStr.getBytes(), CniaoConfigKt.NET_CONFIG_APPKEY.getBytes(),
                    "AES/CBC/PKCS7Padding",
                    "J#y9sJesv*5HmqLq".getBytes()
            ));
        } else {
            return null;
        }

    }
}
