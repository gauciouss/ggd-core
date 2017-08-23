package ggd.core.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import ggd.core.common.Constant;
import ggd.core.dispatcher.DispatchData;
import ggd.core.entity.ServiceResponse;

/**
 * 系統內所有Controller共通的基礎類別(Template Patter), 提供共通功能. 
 * @author tonyyang
 *
 */
public abstract class CommonController {
	
	/**
	 * 定義Controller的型態.
	 * @author tonyyang
	 *
	 */
	public static enum TYPE{
		/**
		 * 有顯示畫面的JSP型態.
		 */
		VIEW,
		/**
		 * 沒有顯示畫面的json資料交換型態.
		 */
		JSON,
		/**
		 * 沒有顯示畫面的XML資料交換型態.
		 */
		XML
	}

	private static final Logger log = LoggerFactory.getLogger(CommonController.class);
	protected static final ThreadLocal<DispatchData> local = new ThreadLocal<DispatchData>();
	/**
	 * 預設轉導的錯誤頁面路徑
	 */
	public static final String ERROR = "/error/error";
	/**
	 * 
	 */
	public static final String CATAGORY = "category";
	/**
	 * 
	 */
	public static final String COMMAND = "command";
	/**
	 * 設定RequestMapping裡path對應.
	 */
	public static final String PATH = "/{"+ CATAGORY +"}/{"+ COMMAND +"}";
	
	/**
	 * 子類別負責實作getType的函數, 通知{@link CommonController}開如何處理相關{@link CommonController#handleException(Throwable, HttpServletRequest)}.
	 * @return
	 */
	public abstract TYPE getType();
	
	/**
	 * 當程式在處理Request時, 發生非預期的錯誤(Exception)，這Controller的子類別將統一由這支程式負責處理、回傳的資訊與紀錄LOG, 避免讓客戶看到500 error畫面.
	 * 程式預設會導向{@link CommonController#ERRORR}路徑的頁面.
	 * 
	 * @param ex
	 * @param request
	 * @return
	 */
	@ExceptionHandler(Throwable.class)
	public Object handleException(Throwable ex, HttpServletRequest request) {
		switch (getType()) {
		case XML:
			return handleXmlException(ex, request);
		case VIEW:
			return handleViewException(ex, request);
		default:
			return handleJsonException(ex, request);
		}
	}
	
	/**
	 * 處理以JSP為基礎, 所產生的{@code Throwable}錯誤. 他會產生一個預設的畫面.
	 * @param ex
	 * @param request
	 * @return
	 */
	public ModelAndView handleViewException(Throwable ex, HttpServletRequest request) {
		log.error("handleViewException ERROR in {}.", request.getRequestURL(), ex);
		ModelAndView view = new ModelAndView(ERROR);
		view.addObject(Constant.DISPATCH_DATA, local.get());
		view.addObject(Constant.EXCEPTION_MSG, request.getRequestURI() + ":" +ex.getMessage());
		return view;
	}
	
	/**
	 * 處理以JSON為基礎的資料交換WS, 所產生的{@code Throwable}錯誤.
	 * @param ex
	 * @param request
	 * @return
	 */
	public ServiceResponse handleJsonException(Throwable ex, HttpServletRequest request) {
		log.error("handleJsonException ERROR in {}.", request.getRequestURL(), ex);
		ServiceResponse.Header header = new ServiceResponse.Header();
		header.setCode("JO-001");
		header.setExt(ex.getMessage());
		return  new ServiceResponse(header, "");
	}
	
	/**
	 * 處理以XML為基礎的資料交換WS, 所產生的{@code Throwable}錯誤.
	 * 
	 * 注意: 這隻程式尚未實作完成.
	 * @param ex
	 * @param request
	 * @return
	 */
	@Deprecated
	public ServiceResponse handleXmlException(Throwable ex, HttpServletRequest request) {
		log.error("handleXmlException ERROR in {}.", request.getRequestURL(), ex);
		ServiceResponse.Header header = new ServiceResponse.Header();
		header.setCode("JO-001");
		header.setExt(ex.getMessage());
		return  new ServiceResponse(header, "");
	}
	
	

}
