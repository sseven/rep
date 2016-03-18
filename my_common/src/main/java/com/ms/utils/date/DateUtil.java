package com.ms.utils.date;

import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.time.FastDateFormat;

/**
 * 日期操作类 
 * @author mao.s
 * 2016年3月15日 下午5:17:09
 * 
 */
public class DateUtil {
	
	//	FastDateFormat线程安全
	private static Map<DateStyle, FastDateFormat> formatConverter = new HashMap<DateStyle, FastDateFormat>();
	
	//	初始化所有日期转化格式format
	static {
		DateStyle[] dss = DateStyle.values();
		for (DateStyle dateStyle : dss) {
			formatConverter.put(dateStyle, FastDateFormat.getInstance(dateStyle.getValue()));
		}
	}
	
    public static Date strToDate(String date, DateStyle dateStyle) {  
        try {
			return (Date)(formatConverter.get(dateStyle).parseObject(date));
		} catch (ParseException e) {
			e.printStackTrace();
		}
        return null;
    }
    
    public static String dateToStr(Date date) {  
    	return formatConverter.get(DateStyle.YYYY_MM_DD_HH_MM_SS_EN).format(date);
    }
    
    public static String dateToStr(Date date, DateStyle dateStyle) {  
    	return formatConverter.get(dateStyle).format(date);
    }
    
	
}
