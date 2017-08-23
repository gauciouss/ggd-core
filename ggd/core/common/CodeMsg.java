package ggd.core.common;

import java.util.HashMap;
import java.util.Map;

import baytony.util.Util;

public class CodeMsg {
	
	/**
	 * 當CodeMsg查無設定訊息時，預設產生的說明．
	 */
	public static final String CODE_ERROR = "：未設定錯誤訊息.";
	
	/**
	 * 查詢成功
	 */
	public static final String QUERY_SUCCESS = "查詢成功";
	
	
	
	/**
	 * SUCCES_000 = 00-000
	 */
	public static final String SUCCES_000 = "00-000";
	
	/**
	 * CORE_001 = "CO-001"
	 * Request JSON裡缺少ver資訊.
	 */
	public static final String CORE_001 = "CO-001";
	
	/**
	 * CORE_002 = "CO-002"
	 * Request JSON裡缺少tim資訊．
	 */
	public static final String CORE_002 = "CO-002";
	
	/**
	 * CORE_002 = "CO-003"
	 * Request JSON裡缺少device資訊．
	 */
	public static final String CORE_003 = "CO-003";
	
	/**
	 * CORE_002 = "CO-004"                    
	 * Request JSON裡缺少loginId資訊．
	 */
	public static final String CORE_004 = "CO-004";
	
	/**
	 * CORE_002 = "CO-005"
	 * Request JSON裡缺少debitAcc資訊．
	 */
	public static final String CORE_005 = "CO-005";
	
	/**
	 * CORE_002 = "CO-006"
	 * Request JSON裡缺少tik資訊．
	 */
	public static final String CORE_006 = "CO-006";
	
	/**
	 * CORE_002 = "CO-007"
	 */
	public static final String CORE_007 = "CO-007";
	
	/**
	 * CORE_002 = "CO-008"
	 */
	public static final String CORE_008 = "CO-008";
	
	/**
	 * CORE_500 = "CO-500"
	 */
	public static final String CORE_500 = "CO-500";
	
	
	
	/**
	 * String JO_001 = "JO-001";
	 */
	public static final String JO_001 = "JO-001";
	
	/**
	 *  String JO_100 = "JO-100";
	 */
	public static final String JO_100 = "JO-100";
	
	
	/**
	 * String M0-001
	 */
	public static final String MAIN_001 = "M0-001";
	
	/**
	 * String M0-002
	 */
	public static final String MAIN_002 = "M0-002";
	
	/*
	 * String U_001
	 */
	public static final String UM_001 = "UM_001";
	
	
	private static final Map<String, String> map = new HashMap<String, String>();
	
	static {
		//Core代碼設定
		map.put(SUCCES_000, "程式執行成功.");
		map.put(CORE_001, "Request JSON裡缺少ver資訊.");
		map.put(CORE_002, "Request JSON裡缺少tim資訊.");
		map.put(CORE_003, "Request JSON裡缺少device資訊.");
		map.put(CORE_004, "Request JSON裡缺少loginId資訊.");
		map.put(CORE_005, "Request JSON裡缺少debitAcc資訊.");
		map.put(CORE_006, "Request JSON裡缺少tik資訊.");
		
		//JSON COntroller的代碼設定
		map.put(JO_001, "JSON Controller出現錯誤.");
		map.put(JO_100, "JSON UTIL錯誤.");
		
	}

	public static final String getCodeMessage(String code) {
		String msg = map.get(code);
		if( Util.isEmpty(msg) ){
			return CODE_ERROR;
		}
		return msg;
	}

}
