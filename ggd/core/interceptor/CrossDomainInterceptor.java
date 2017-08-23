package ggd.core.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class CrossDomainInterceptor extends HandlerInterceptorAdapter {
	
	//
	// 為解決 Worklight 網頁模擬器呼叫 ajax Cross Domain 的問題
	// 在 Header 加入以下資訊
	//
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {

		//開啟所有AJAX Cross Domain呼叫的權限
		//String clientOrigin = request.getHeader("origin");
		
		response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, DELETE, OPTIONS");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type");
        response.setHeader("Access-Control-Max-Age", "86400");
		
		return true;
	}
}