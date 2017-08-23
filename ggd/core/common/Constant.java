package ggd.core.common;

/**
 * Constant介面裡定義了系統常用的String常數.
 * 
 * @author tonyyang
 *
 */
public interface Constant {

	/**
	 * 設定程式目前執行的主機
	 */
	public static final Machine MACHINE = Machine.DEVELOP;

	/**
	 * 設定程式是否部署在測試機上．true=測試機，false=正式機
	 */
	public static final boolean TEST_MODE = (MACHINE == Machine.DEVELOP || MACHINE == Machine.TEST);

	// ********常用的String常數********
	/**
	 * POINT="."
	 */
	public static final String POINT = ".";
	/**
	 * PIPE="[|]"
	 */
	public static final String PIPE = "[|]";
	/**
	 * ERASE_BLANK =" +"
	 */
	public static final String ERASE_BLANK = " +";
	/**
	 * UNDERLINE="_"
	 */
	public static final String UNDERLINE = "_";
	/**
	 * 空字串
	 */
	public static final String EMPTY = "";
	/**
	 * 空白字串
	 */
	public static final String BLANK = " ";

	/**
	 * 報價用的DASH字串. 原本是用"--"後來改成空字串.
	 */
	public static final String DASH = "--";
	/**
	 * SLASH = "/"
	 */
	public static final String SLASH = "/";
	/**
	 * BREAKLINE = "\n"
	 */
	public static final String BREAKLINE = "\n";
	/**
	 * BLANK_PIPE = "\\s+[|]"
	 */
	public static final String BLANK_PIPE = "\\s+[|]";
	/**
	 * BIG5
	 */
	public static final String BIG5 = "BIG5";
	/**
	 * UTF-8
	 */
	public static final String UTF8 = "UTF-8";
	
	/**
	 * ISO-8859-1
	 */
	public static final String ISO88591 = "ISO-8859-1";
	
	/**
	 * _0 = "0";
	 */
	public static final String _0 = "0";
	/**
	 * _N1 = "-1";
	 */
	public static final String _N1 = "-1";
	/**
	 * _1 = "1";
	 */
	public static final String _1 = "1";
	/**
	 * _01 = "01";
	 */
	public static final String _01 = "01";

	/**
	 * _02 = "02";
	 */
	public static final String _02 = "02";

	/**
	 * _03 = "03";
	 */
	public static final String _03 = "03";

	/**
	 * _04 = "04";
	 */
	public static final String _04 = "04";

	/**
	 * _05 = "05";
	 */
	public static final String _05 = "05";

	/**
	 * _06 = "06";
	 */
	public static final String _06 = "06";

	/**
	 * _07 = "07";
	 */
	public static final String _07 = "07";

	/**
	 * _11 = "11";
	 */
	public static final String _11 = "11";

	/**
	 * _12 = "12";
	 */
	public static final String _12 = "12";

	/**
	 * _21 = "21";
	 */
	public static final String _21 = "21";

	/**
	 * _22 = "22";
	 */
	public static final String _22 = "22";

	/**
	 * _31 = "31";
	 */
	public static final String _31 = "31";

	/**
	 * _32 = "32";
	 */
	public static final String _32 = "32";
	/**
	 * _00 = 00
	 */
	public static String _00 = "00";

	// 以下是DispatchData相關常數.
	/**
	 * ACTION = "act"
	 */
	public static final String ACTION = "act";
	/**
	 * 
	 */
	public static final String TYPE = "typ";
	/**
	 * TYPE = "typ"
	 */
	public static final String PARAMS = "par";
	/**
	 * USER = "user"
	 */
	public static final String USER = "user";
	/**
	 * VER = "ver"
	 */
	public static final String VER = "ver";
	/**
	 * SRC = "src"
	 */
	public static final String SRC = "src";
	/**
	 * TIK = "tik"
	 */
	public static final String TIK = "tik";
	/**
	 * IP = "ip"
	 */
	public static final String IP = "ip";
	/**
	 * TIM = "tim"
	 */
	public static final String TIM = "tim";
	/**
	 * DEVICE = "device"
	 */
	public static final String DEVICE = "device";
	/**
	 * DEVICE_ID = "deviceId"
	 */
	public static final String DEVICE_ID = "deviceId";
	/**
	 * UUID = "uuid"
	 */
	public static final String UUID = "uuid";
	/**
	 * LOGIN_ID = "loginId"
	 */
	public static final String LOGIN_ID = "loginId";
	/**
	 * OS_VERSION = "osVersion"
	 */
	public static final String OS_VERSION = "osVersion";
	/**
	 * ACCOUNTS = "accounts"
	 */
	public static final String ACCOUNTS = "accounts";
	/**
	 * NAME = "name"
	 */
	public static final String NAME = "name";
	/**
	 * DEBIT_ACC = "debitAcc"
	 */
	public static final String DEBIT_ACC = "debitAcc";

	/**
	 * MLF_AP_HOST = "MLF_AP_HOST"
	 */
	public static final String MLF_AP_HOST = "MLF_AP_HOST";

	/**
	 * MLF_AP_HOST = "MIDDLE_EJB_HOST"
	 */
	public static final String MIDDLE_EJB_HOST = "MIDDLE_EJB_HOST";

	/**
	 * LOGIN = "LOGIN";
	 */
	public static final String LOGIN = "LOGIN";

	/**
	 * LOGOUT = "LOGOUT";
	 */
	public static final String LOGOUT = "LOGOUT";

	/**
	 * LOGIN_DEF_GOTO = "LOGIN_DEF_GOTO"
	 */
	public static final String LOGIN_DEF_GOTO = "LOGIN_DEF_GOTO";

	/**
	 * ACL_WHITE_LIST_DEF_GOTO = "ACL_WHITE_LIST_DEF_GOTO"
	 */
	public static final String ACL_WHITE_LIST_DEF_GOTO = "ACL_WHITE_LIST_DEF_GOTO";

	/**
	 * ACL_BLACK_LIST_DEF_GOTO = "ACL_BLACK_LIST_DEF_GOTO"
	 */
	public static final String ACL_BLACK_LIST_DEF_GOTO = "ACL_BLACK_LIST_DEF_GOTO";

	/**
	 * TICKET_TIMEOUT_MINS = "TICKET_TIMEOUT_MINS"
	 */
	public static final String TICKET_TIMEOUT_MINS = "TICKET_TIMEOUT_MINS";

	/**
	 * ACL_GOTO = "ACL_GOTO"
	 */
	public static final String ACL_GOTO = "ACL_GOTO";
	
	
	
	
	public static final String MAIN_PATH_HOST = "MAIN_PATH_HOST";
	

	// ---------以下常數是ModelView及Request & JSP用的---------
	/**
	 * DISPATCH_DATA = Constant.class + "_DISPATCH_DATA"
	 */
	public static final String DISPATCH_DATA = Constant.class
			+ "_DISPATCH_DATA";

	/**
	 * SESSION = Constant.class + "_SESSION"
	 */
	public static final String SESSION = Constant.class + "_SESSION";
	
	

	/**
	 * USER_INFO = Constant.class + "_USER_INFO"
	 */
	public static final String USER_INFO = Constant.class + "_USER_INFO";

	/**
	 * COMMON_CONFIG = Constant.class + "_COMMON_CONFIG";
	 */
	public static final String COMMON_CONFIG = Constant.class
			+ "_COMMON_CONFIG";

	/**
	 * DISPLAY_CONFIG = Constant.class + "_DISPLAY_CONFIG";
	 */
	public static final String DISPLAY_CONFIG = Constant.class
			+ "_DISPLAY_CONFIG";

	/**
	 * URL_CONFIG = Constant.class + "_URL_CONFIG";
	 */
	public static final String URL_CONFIG = Constant.class + "_URL_CONFIG";

	/**
	 * JSON_RESPONSE = Constant.class + "_JSON_RESPONSE";
	 */
	public static final String JSON_RESPONSE = Constant.class
			+ "_JSON_RESPONSE";

	/**
	 * ARG = "arg"
	 */
	public static final String ARG = "arg";

	/**
	 * 例外訊息
	 */
	public static final String EXCEPTION_MSG = "_ex_msg";

	/**
	 * STATUS_CHECK_SUCCESS = "審核成功"
	 */
	public static final String STATUS_CHECK_SUCCESS = "審核成功";

	/**
	 * STATUS_CHECK_FAIL = "審核失敗"
	 */
	public static final String STATUS_CHECK_FAIL = "審核失敗";

	/**
	 * STATUS_CHECKING = "審核中"
	 */
	public static final String STATUS_CHECKING = "審核中";

	/**
	 * STATUS_CANCEL = "取消"
	 */
	public static final String STATUS_CANCEL = "取消";

	/**
	 * CHANNEL_WEB = "網頁"
	 */
	public static final String CHANNEL_WEB = "網頁";

	/**
	 * CHANNEL_MOBILE = "行動"
	 */
	public static final String CHANNEL_MOBILE = "行動";

	/**
	 * CHANNEL_WALKIN = "臨櫃"
	 */
	public static final String CHANNEL_WALKIN = "臨櫃";

	/**
	 * QA = "QA"
	 */

	public static final String QA = "QA";

	/**
	 * QR_CODE ="QR_CODE"
	 */
	public static final String QR_CODE = "QR_CODE";

	/**
	 * ACT_WEB = "ACT_WEB"
	 */
	public static final String ACT_WEB = "ACT_WEB";

	/**
	 * ACT_MOBILE = "ACT_MOBILE"
	 */
	public static final String ACT_MOBILE = "ACT_MOBILE";

	public static final String ACCOUNT_PARAM = "account";

	public static final String BRANK_NAME_PARAM = "brankName";
	
	public static final String COMM_ACCOUNT = "account";
	public static final String COMM_PWD = "password";
	
	public static final String ACCOUNT_NON_AUTH = "無使用權限";
	public static final String ACCOUTN_PWD_ERROR = "帳號或密碼錯誤";
	
	
	
	public static final String AUTH = "auth";
	public static final String AUTH_KEY = "authKey";
	
	public static final String SYS_USER = "系統管理者";
	
	
	public static final String CREDENTIALS_FILE_PATH = "CREDENTIALS_FILE_PATH";
	
	public static final String ADDR = "通訊地址";
	public static final String RESIDENCE_ADDR = "戶籍地址";
	public static final String BILL = "電子對帳單";
	public static final String PHONE = "電話";
	public static final String SMS = "簡訊";
	public static final String EMAIL = "電子郵件";
	
	public static final String IMG_FILE_TYPE = ".jpg";
	public static final String VIDEO_FILE_TYPE = ".mp4";
	
	public static final String AP_RESULT = "apResult";
	
	
	
	public static final String ID_CARD_PIC_1 = "idCardPic1";
	public static final String ID_CARD_PIC_2 = "idCardPic2";
	public static final String SEC_CARD_PIC_1 = "secCardPic1";
	public static final String SEC_CARD_PIC_2 = "secCardPic2";
	public static final String BANK_BOOK_PIC = "bankBookPic";
	public static final String SIGNATURE_PIC = "signaturePic";
	public static final String VIDEO_SCREENSHOT1 = "videoScreenshot1";
	public static final String VIDEO_SCREENSHOT2 = "videoScreenshot2";
	public static final String VIDEO_SCREENSHOT3 = "videoScreenshot3";
	public static final String VIDEO_SCREENSHOT4 = "videoScreenshot4";
	public static final String VIDEO_SCREENSHOT5 = "videoScreenshot5";
	public static final String VIDEO_SCREENSHOT6 = "videoScreenshot6";
	public static final String VIDEO_SCREENSHOT7 = "videoScreenshot7";
	public static final String FOREIGN_CURRENCY_BANK_BOOK_PIC = "foreignCurrencyBankBookPic";

	public static final String WEB_PATH_HOST = "WEB_PATH_HOST";
	
	public static final String ACTION_TYPE = "actionType";
	
	public static final String PAGE_SIZE = "pageSize";
}
