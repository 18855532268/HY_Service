package com.yajie.huayi.util;


import com.yajie.huayi.constant.Constants;
import com.yajie.huayi.exception.ErrorRollbackException;
import org.apache.commons.lang.StringUtils;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;


/**
 * 一些通用方法
 *
 * @author zhangjicheng
 */
public class CommonUtil {
    /**
     * 获得随机uuid
     *
     * @return 随机uuid
     */
    public static synchronized String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    /**
     * 返回的str不为null，一般用于VO中的字段处理
     *
     * @param str 传入String
     * @return 转换后的String
     */
    public static String getNotNullString(String str) {
        return StringUtils.isBlank(str) ? "" : str;
    }

    /**
     * 将秒数转换为前端显示的格式：（XX小时）XX分钟（XX秒）
     *
     * @param seconds 秒数
     * @return 显示格式的字段
     */
    public static String getStrFromSeconds(Integer seconds) {
        if (seconds == null) {
            return null;
        }
        int calcHours = seconds / (60 * 60);
        int calcMinutes = (seconds % (60 * 60)) / 60;
        int calcSeconds = seconds % 60;
        return (calcHours == 0 ? "" : String.format("%02d", calcHours) + ":") +
                String.format("%02d", calcMinutes) + ":" +
                String.format("%02d", calcSeconds);
    }

    public static String getStringMoney(Double num, Boolean needBegin) {
        return ((needBegin != null && needBegin) ? (num > 0 ? "+" : "") : "") + String.format("%.2f", num);
    }

    public static String formatDateTime(LocalDateTime localDateTime) {
        if (localDateTime == null) {
            return "";
        }
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return dtf.format(localDateTime);
    }

    public static Date stringToDate(String date) {
        Date parse = new Date();
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            parse = sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return parse;
    }

    /**
     * 如果url未带开头则添加开头http://
     *
     * @param url
     * @return
     */
    public static String getStartWithHttpUrl(String url) {
        if (StringUtils.isNotBlank(url)) {
            if (StringUtils.startsWithIgnoreCase(url, "http://") && (StringUtils.startsWithIgnoreCase(url, "https://"))) {
                url = "http://" + url;
            }
        }
        return url;
    }

    /**
     * 是否为数字（整数+小数）
     *
     * @param number
     * @return
     */
    public static Boolean checkIsNumber(String number) {
        if (number.indexOf(".") != number.lastIndexOf(".")) {
            return false;
        }
        return StringUtils.isNumeric(number.replace(".", ""));
    }

    /**
     * 数据存储到分，前台转换显示
     *
     * @param money 传入存储到分的数据
     * @return 正常显示金额
     */
    public static Double convertLongAmountToDouble(Long money) {
        if (money == null) {
            return null;
        }
        return money / Constants.DATABASE_NUMBER_STORE_UNIT;
    }

    /**
     * 金额转分，后台转换显示
     *
     * @param money 传入存储到分的数据
     * @return 正常显示金额
     */
    public static Long convertDoubleAmountToLong(Double money) {
        if (money == null) {
            money = 0d;
        }
        return (long) (money * Constants.DATABASE_NUMBER_STORE_UNIT);
    }

    /**
     * 将原pcm转为wav
     *
     * @param source
     * @param target
     * @throws Exception
     */
    public static void parsePcm2Mp3(String source, String target) throws Exception {
        float sampleRate = 16000;
        int sampleSizeInBits = 16;
        int channels = 1;
        boolean signed = true;
        boolean bigEndian = false;
        AudioFormat af = new AudioFormat(sampleRate, sampleSizeInBits, channels, signed, bigEndian);
        File sourceFile = new File(source);
        FileOutputStream out = new FileOutputStream(new File(target));
        AudioInputStream audioInputStream = new AudioInputStream(new FileInputStream(sourceFile), af, sourceFile.length());
        AudioSystem.write(audioInputStream, AudioFileFormat.Type.WAVE, out);
        audioInputStream.close();
        out.flush();
        out.close();
        sourceFile.delete();
    }

    /**
     * 判断输入参数是否为空
     *
     * @param objects
     */
    public static void checkParameters(Object... objects) {
        if (objects != null) {
            for (Object o : objects) {
                if (o == null || "".equals(o)) {
                    throw new ErrorRollbackException("参数为空或添加参数有误");
                }
            }
        }
    }

    public static String dateToStr(Date dateDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(dateDate);
        return dateString;
    }

    public static String arrayToString(Integer[] arr) {
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<arr.length;i++){
            sb.append(arr[i]+",");
        }
        return sb.toString().substring(0,sb.length() -1);
    }

}
