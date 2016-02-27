package com.ai.amc.utils;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * 日期工具类
 * @author renfeng
 *
 */
public class DateUtil {
	/**
	 * str转sql date
	 * @param dateStr
	 * @return
	 * @throws ParseException
	 */
	public static Date StrToDate(String dateStr) throws ParseException{
		String[] split = dateStr.split("/");
		if(split.length>0){
			dateStr=dateStr.replaceAll("/", "-");
		}
		System.out.println(dateStr);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
		java.util.Date parse = format.parse(dateStr);
		java.sql.Date date = new java.sql.Date(parse.getTime());
		return date;
	}
	/**
	 * str转sql date
	 * @param dateStr
	 * @return
	 * @throws ParseException
	 */
	public static Date StrToDate2(String dateStr) throws ParseException{
		String[] split = dateStr.split("/");
		if(split.length>0){
			dateStr=dateStr.replaceAll("/", "-");
		}
		System.out.println(dateStr);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date parse = format.parse(dateStr);
		java.sql.Date date = new java.sql.Date(parse.getTime());
		return date;
	}
	/**
	 * sql date转str
	 * @param dateStr
	 * @return
	 * @throws ParseException
	 */
	public static String DateToStr(Date date) throws ParseException{
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String format2 = format.format(date);
		format2=format2.replaceAll("-", "/");
		return format2;
	}
	/**
	 * sql date转str
	 * @param dateStr
	 * @return
	 * @throws ParseException
	 */
	public static String DateToStr2(Date date) throws ParseException{
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
		String format2 = format.format(date);
		return format2;
	}
	/**
	 * sql date转str
	 * @param dateStr
	 * @return
	 * @throws ParseException
	 */
	public static String DateToStr3(Date date) throws ParseException{
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String format2 = format.format(date);
		return format2;
	}
	/**
	 * 获取当前年
	 * @return
	 */
	public static String getYear(){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String format2 = format.format(new Date(System.currentTimeMillis()));
		return format2.substring(0, 4);
	}
	/**
	 * 获取当前时间
	 * @return
	 */
	public static Date getCurDate(){
		Date date = new Date(System.currentTimeMillis());
		return date;
	}
	/**
	 * 获取当前月
	 * @return
	 */
	public static String getMonth(){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String format2 = format.format(new Date(System.currentTimeMillis()));
		return format2.substring(5, 7);
	}
	/**
	 * 根据日期获取是星期几
	 * @param date
	 * @throws ParseException
	 */
	public static String getWeek(String date){
		SimpleDateFormat format = new SimpleDateFormat("EEEE");
		Date strToDate2=null;
		try {
			strToDate2 = DateUtil.StrToDate2(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return format.format(strToDate2);
	}
	/**
	 * 获取可报销月
	 * @param maxNum
	 * @return
	 */
	public static List<String> getMonthList(int maxNum){
		List<String> monthList = new ArrayList<String>();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
		for(int i=1;i<=maxNum;i++){
			Calendar now = Calendar.getInstance();
			now.roll(Calendar.MONTH, -i);
			String format2 = format.format(now.getTime());
			monthList.add(format2);
		}
		return monthList;
	}
	
	
	
	
	
	public static void main(String[] args) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM");
		
		
		for(int i=1;i<7;i++){
			Calendar now = Calendar.getInstance();
			now.roll(Calendar.MONTH, -i);
			String format2 = format.format(now.getTime());
			System.out.println(format2);
		}
		
		
//		System.out.println(format.format(now.getTime()));
		
		
		
		
		
		
		
		
		
//		Date strToDate = StrToDate("2015/9");
//		String dateToStr = DateToStr2(new Date(System.currentTimeMillis()));
//		System.out.println(dateToStr);
//		String week = DateUtil.getWeek("2015-12-11");
//		
//		
//		System.out.println(week);
//		Date date = new Date(System.currentTimeMillis());
//		System.out.println(date);
		//System.out.println(new Date(date));
//		System.out.println(getYear());
//		System.out.println(getMonth());
		
	}
	
}
