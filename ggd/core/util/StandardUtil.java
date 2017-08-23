package ggd.core.util;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import baytony.util.StringUtil;
import baytony.util.Util;

public class StandardUtil {
	
	private static Logger log = LoggerFactory.getLogger(StandardUtil.class);
	
	private static final String PRICE_FORMAT_WITH_NO_COMMA = "###0.00";
	private static final String PRICE_FORMAT = "#,##0.00";
	private static final String TINY_PRICE_FORMAT_WITH_NO_COMMA = "###0.000";
	private static final String TINY_PRICE_FORMAT = "#,##0.000";
	private static final String QTY_FORMAT = "#,##0";
	private static final String CELL_PHONE_NUMBER_FORMAT = "09[0-9]{8}";

	public static Float toFloat(String num){
		return toFloat(num, 0f);
	}
	
	public static Double toDouble(String num){
		return toDouble(num, 0d);
	}
	
	public static Integer toInteger(String num){
		return toInteger(num, 0);
	}
	
	public static Long toLong(String num){
		return toLong(num, 0l);
	}
	
	public static Float toFloat(String num, Float defaultValue){
		if(Util.isEmpty(num)){
			return defaultValue;
		}
		try{
			return Float.valueOf(num);
		}catch (Exception e) {
			return defaultValue;
		}
	}
	
	public static Double toDouble(String num, Double defaultValue){
		if(Util.isEmpty(num)){
			return defaultValue;
		}
		try{
			return Double.valueOf(num);
		}catch (Exception e) {
			return defaultValue;
		}
	}
	
	public static Integer toInteger(String num, Integer defaultValue){
		if(Util.isEmpty(num)){
			return defaultValue;
		}
		try{
			return Integer.valueOf(num);
		}catch (Exception e) {
			return defaultValue;
		}
	}
	
	public static Long toLong(String num, Long defaultValue){
		if(Util.isEmpty(num)){
			return defaultValue;
		}
		try{
			return Long.valueOf(num);
		}catch (Exception e) {
			return defaultValue;
		}
	}
	
	/**
	 * 小數點２位
	 * 格式化回傳值，#####.00
	 * @param price
	 * @return
	 */
	public static String formatPriceNoComma(String price) {
		return formatPriceNoComma(toDouble(price));
	}
	
	/**
	 * 小數點２位
	 * 格式化回傳值，#####.00
	 * @param price
	 * @return
	 */
	public static String formatPriceNoComma(double price) {
		return formatStr(price, PRICE_FORMAT_WITH_NO_COMMA);
	}
	
	/**
	 * 小數點２位
	 * 格式化回傳值，#####.00
	 * @param price
	 * @return
	 */
	public static String formatPriceNoComma(Number num) {
		return formatStr(num, PRICE_FORMAT_WITH_NO_COMMA);
	}
	
	/**
	 * 小數點３位
	 * 格式化回傳值，#####.000
	 * @param price
	 * @return
	 */
	public static String formatTinyPriceNoComma(String price) {
		return formatPriceNoComma(toDouble(price));
	}
	
	/**
	 * 小數點３位
	 * 格式化回傳值，#####.000
	 * @param price
	 * @return
	 */
	public static String formatTinyPriceNoComma(double price) {
		return formatStr(price, TINY_PRICE_FORMAT_WITH_NO_COMMA);
	}
	
	/**
	 * 小數點３位
	 * 格式化回傳值，#####.000
	 * @param price
	 * @return
	 */
	public static String formatTinyPriceNoComma(Number num) {
		return formatStr(num, TINY_PRICE_FORMAT_WITH_NO_COMMA);
	}
	
	/**
	 * 格式化回傳值，#####.00, 且自動的把.00過濾．
	 * @param price
	 * @return
	 */
	public static String formatPriceNoComma1(String price) {
		return formatPriceNoComma(toDouble(price));
	}
	
	/**
	 * 格式化回傳值，#####.00, 且自動的把.00過濾．
	 * @param price
	 * @return
	 */
	public static String formatPriceNoComma1(double price) {
		return formatStr(price, PRICE_FORMAT_WITH_NO_COMMA).replaceAll("\\.00", "");
	}
	
	/**
	 * 格式化回傳值，#####.00, 且自動的把.00過濾．
	 * @param price
	 * @return
	 */
	public static String formatPriceNoComma1(Number num) {
		return formatStr(num, PRICE_FORMAT_WITH_NO_COMMA).replaceAll("\\.00", "");
	}
	
	/**
	 * 小數點３位
	 * 格式化回傳值，#####.000, 且自動的把.00過濾．
	 * @param price
	 * @return
	 */
	public static String formatTinyPriceNoComma1(String price) {
		return formatPriceNoComma(toDouble(price));
	}
	
	/**
	 * 小數點３位
	 * 格式化回傳值，#####.000, 且自動的把.00過濾．
	 * @param price
	 * @return
	 */
	public static String formatTinyPriceNoComma1(double price) {
		return formatStr(price, TINY_PRICE_FORMAT_WITH_NO_COMMA).replaceAll("\\.000", "");
	}
	
	/**
	 * 小數點３位
	 * 格式化回傳值，#####.000, 且自動的把.00過濾．
	 * @param price
	 * @return
	 */
	public static String formatTinyPriceNoComma1(Number num) {
		return formatStr(num, TINY_PRICE_FORMAT_WITH_NO_COMMA).replaceAll("\\.000", "");
	}
	
	/**
	 * 格式化回傳值，#,####.00
	 * 
	 * @param price
	 * @return
	 */
	public static String formatPrice(Number num) {
		return formatStr(num, PRICE_FORMAT);
	}
	
	/**
	 * 格式化回傳值，#,####.00
	 * 
	 * @param price
	 * @return
	 */
	public static String formatPrice(String price) {
		return formatPrice(toDouble(price));
	}

	/**
	 * 格式化回傳值，#,####.00
	 * 
	 * @param price
	 * @return
	 */
	public static String formatPrice(double price) {
		return formatStr(price, PRICE_FORMAT);
	}
	
	/**
	 * 格式化回傳值，#,####.000
	 * 
	 * @param price
	 * @return
	 */
	public static String formatTinyPrice(Number num) {
		return formatStr(num, TINY_PRICE_FORMAT);
	}
	
	/**
	 * 格式化回傳值，#,####.000
	 * 
	 * @param price
	 * @return
	 */
	public static String formatTinyPrice(String price) {
		return formatPrice(toDouble(price));
	}

	/**
	 * 格式化回傳值，#,####.000
	 * 
	 * @param price
	 * @return
	 */
	public static String formatTinyPrice(double price) {
		return formatStr(price, TINY_PRICE_FORMAT);
	}
	
	public static String formatQty(Number num) {
		return formatStr(num, QTY_FORMAT);
	}
	
	public static String formatQty(String qty) {
		return formatQty(toDouble(qty));
	}
	
	public static String formatQty(double qty) {
		return formatStr(qty, QTY_FORMAT);
	}
	
	private static String formatStr(Number num, String resultFormat) {
		String result = "0.00";
		try{
			NumberFormat format = new DecimalFormat(resultFormat);
			result = format.format(num);
		}catch(Exception e){
			log.error(StringUtil.getStackTraceAsString(e));
		}
		return result;
	}
	
	private static String formatStr(double d, String resultFormat) {
		String result = "0.00";
		try{
			NumberFormat format = new DecimalFormat(resultFormat);
			result = format.format(d);
		}catch(Exception e){
			log.error(StringUtil.getStackTraceAsString(e));
		}
		return result;
	}
	
	
	public static long string2Number(String str) {
		StringBuilder sb = new StringBuilder();
		if(!Util.isEmpty(str)) {
			int leng = str.length();
			for(int i=0 ; i<leng ; i++) {
				char c = str.charAt(i);
				int ci = (int) c;
				sb.append(ci);
			}
			String s = sb.toString();
			long rs = Long.parseLong(s);
			return rs;
		}
		return 0L;
	}
	
	public static String time2String(Timestamp t) {		
		return time2String(t, "yyyy-MM-dd HH:mm:ss");
	}
	
	public static String time2String(Date d) {
		return time2String(d, "yyyy-MM-dd HH:mm:ss");		
	}
	
	public static String time2String(Timestamp t, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(t);
	}
	
	public static String time2String(Date d, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(d);		
	}
	
	public static int parseDate2Int(Date d) {
		Calendar c = Calendar.getInstance();
		c.setTime(d);		
		return parseDate2Int(c);
	}
	
	public static int parseDate2Int(Timestamp t) {
		Date d = new Date(t.getTime());
		return parseDate2Int(d);
	}
	
	public static int parseDate2Int(Calendar c) {
		return c.get(Calendar.YEAR) * 10000 + (c.get(Calendar.MONDAY) + 1) * 100 + c.get(Calendar.DATE);
	}
	
	public static boolean isCellPhoneNumber(String phone) {
		return phone.matches(CELL_PHONE_NUMBER_FORMAT);
	}
	
	public static String[] split(String Str, char Reg) {
		if ((Str.indexOf(Reg) == -1) && (Str != null || Str != "")) {
			String NewAry[] = { Str };
			return NewAry;
		} else if (Str.length() != 0) {
			int inxesOfStr = 0;
			int lastInx = 0;
			int AryInx = 0;
			// 先求新陣列要有幾個元素
			for (int m = 0; m < Str.length(); m++) {
				if (Str.charAt(m) == Reg) {
					inxesOfStr += 1;
				}
			}
			inxesOfStr += 1; // 最後還要再加一
			String NewAry[];
			NewAry = new String[inxesOfStr];
			for (int i = 0; i < Str.length(); i++) {
				if (Str.charAt(i) == Reg) {

					if (AryInx == 0) { // 第一個元素
						NewAry[AryInx] = new String(Str.substring(0, i));
					} else {
						NewAry[AryInx] = new String(Str.substring(lastInx + 1,
								i));
					}
					lastInx = i;
					AryInx += 1;
				} else if (i == (Str.length() - 1)) { // 最後的元素
					NewAry[AryInx] = new String(Str.substring(lastInx + 1));
				}
			}
			return NewAry;
		} else {
			String NewAry[];
			NewAry = new String[0];
			return NewAry;
		}
	}
}
