package com.boliangshenghe.eqim.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间工具类
 * 
 * @author xuzj
 * 
 */
public class DateUtils {

	public static String getStringDate(Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日HH时mm分");
		String dateString = formatter.format(date);
		return dateString;
	}
}
