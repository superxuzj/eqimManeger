package com.boliangshenghe.eqim.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CodeUtils {

	/**
	 * 获取当前年月
	 * @return
	 */
	public static String getYearMonth(){
		//年月
		String year =new SimpleDateFormat("yyyy-MM").format(Calendar.getInstance().getTime());
		return year;
	}
	
	public static void main(String[] args) {
		System.out.println(getYearMonth());
	}
}
