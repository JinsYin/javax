package x.util;

import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 扩展 Date 类型
 *
 * 说明：
 * 1. java.sql.Timestamp 继承自 java.util.Date
 */
public
final class DateX {
    // 日期格式
    public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    public static final String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
    public static final String YYYYMMDDHHMMSSFFF = "yyyyMMddhhmmssSSS";

    /**
     * java.util.Date 转 String
     * @param date 可以接收 java.sql.Timestamp 子类对象
     */
    public static String date2str(Date date, String dateFormat) {
        if (date == null || dateFormat == null) {
            return null;
        }
        Format formatter = new SimpleDateFormat(dateFormat);
        return formatter.format(date);
    }

    /**
     * String 转 java.util.Date
     */
    public static Date str2date(String dateString, String dateFormat) throws ParseException {
        if (dateString == null || dateFormat == null) {
            return null;
        }
        return new SimpleDateFormat(dateFormat).parse(dateString);
    }

    /**
     * String 转 java.sql.Timestamp
     */
    public static java.sql.Timestamp strToSqlTs(String dateString, String dateFormat) throws ParseException {
        if (dateString == null || dateFormat == null) {
            return null;
        }
        return new java.sql.Timestamp(new SimpleDateFormat(dateFormat).parse(dateString).getTime());
    }
}