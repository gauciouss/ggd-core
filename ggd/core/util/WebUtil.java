package ggd.core.util;

import javax.servlet.http.HttpServletRequest;

/**
 * 處理{@code HttpServletRequest}, {@code HttpServletSession}, {@code ModelAndView}, 相關物件的工具程式.
 * @author tonyyang
 *
 */
public class WebUtil {
	
	private static String PREFIX = "\\u";    
	
	/**
	 * ascii 2 native
	 * @param str
	 * @return
	 */
	public static String ascii2Native(String str) {      
        StringBuilder sb = new StringBuilder();      
        int begin = 0;      
        int index = str.indexOf(PREFIX);      
        while (index != -1) {      
            sb.append(str.substring(begin, index));      
            sb.append(ascii2Char(str.substring(index, index + 6)));      
            begin = index + 6;      
            index = str.indexOf(PREFIX, begin);      
        }      
        sb.append(str.substring(begin));      
        return sb.toString();      
    }     
	
	/**
	 * ascii 2 native
	 * @param str
	 * @return
	 */
	public static char ascii2Char(String str) {      
        if (str.length() != 6) {      
            throw new IllegalArgumentException("Ascii string of a native character must be 6 character.");      
        }      
        if (!PREFIX.equals(str.substring(0, 2))) {      
            throw new IllegalArgumentException("Ascii string of a native character must start with \"\\u\".");      
        }      
        String tmp = str.substring(2, 4);      
        int code = Integer.parseInt(tmp, 16) << 8;      
        tmp = str.substring(4, 6);      
        code += Integer.parseInt(tmp, 16);      
        return (char) code;      
    }   
	
	/**
	 * native to ascii
	 * @param str
	 * @return
	 */
	public static String unicodeEscaped(String str) {
		char[] cs = str.toCharArray();
		StringBuilder sb = new StringBuilder();
		for (char c : cs) {
			sb.append(unicodeEscaped(c));
		}
		return sb.toString();
	}

	/**
	 * native to ascii
	 * @param ch
	 * @return
	 */
	public static String unicodeEscaped(char ch) {
		if (ch < 0x10) {
			return "\\u000" + Integer.toHexString(ch);
		} else if (ch < 0x100) {
			return "\\u00" + Integer.toHexString(ch);
		} else if (ch < 0x1000) {
			return "\\u0" + Integer.toHexString(ch);
		}
		return "\\u" + Integer.toHexString(ch);
	}

	
	/**
	 * 透過傳入的{@code HttpServletRequest}取得客戶IP.
	 * @param request
	 * @return
	 */
	public static String getClientIpAddr(HttpServletRequest request) {  
	    String ip = request.getHeader("X-Forwarded-For");  
	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
	        ip = request.getHeader("Proxy-Client-IP");  
	    }  
	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
	        ip = request.getHeader("WL-Proxy-Client-IP");  
	    }  
	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
	        ip = request.getHeader("HTTP_X_FORWARDED_FOR");  
	    }  
	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
	        ip = request.getHeader("HTTP_X_FORWARDED");  
	    }  
	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
	        ip = request.getHeader("HTTP_X_CLUSTER_CLIENT_IP");  
	    }  
	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
	        ip = request.getHeader("HTTP_CLIENT_IP");  
	    }  
	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
	        ip = request.getHeader("HTTP_FORWARDED_FOR");  
	    }  
	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
	        ip = request.getHeader("HTTP_FORWARDED");  
	    }  
	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
	        ip = request.getHeader("HTTP_VIA");  
	    }  
	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
	        ip = request.getHeader("REMOTE_ADDR");  
	    }  
	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
	        ip = request.getRemoteAddr();  
	    }  
	    return ip;  
	}
	
}
