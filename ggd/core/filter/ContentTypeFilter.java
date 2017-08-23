package ggd.core.filter;

import java.io.IOException;
import java.io.Reader;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import baytony.util.StringUtil;
import baytony.util.Util;

/**
 * ＩＥ８～１１在Cross Domain下所發出的Ajax有時候ContentType會是空直，這導致Request無法正確的處理.
 * 這個Filter主要是修正這個“該死”的MS BUG, 預設會自動產生application/x-www-form-urlencoded的ContentType.
 * 使用上必須將先關設定加到web.xml裡.
 * 
 * @author baytony
 *
 */
public class ContentTypeFilter implements Filter {

	private static final Logger log = LoggerFactory.getLogger(ContentTypeFilter.class);
	private static final String TYPE = "application/x-www-form-urlencoded";
	private String type = TYPE;

	/**
	 * Default constructor.
	 */
	public ContentTypeFilter() {
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		if (Util.isEmpty(request.getContentType())) {
			log.info("ContentType NULL for user : {}. Overwriting Request.",request.getRemoteAddr());
			request = new Request((HttpServletRequest) request);
		}
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		if (!Util.isEmpty(fConfig.getInitParameter("type"))) {
			type = fConfig.getInitParameter("type");
		}
		log.debug("{} init finish with type {}.", this.getClass().getName(), type);
	}

	private class Request extends HttpServletRequestWrapper {
		
		private final Hashtable<String,String[]> table=new Hashtable<String, String[]>();

		public Request(HttpServletRequest request) {
			super(request);
			try {
				//將ＵＲＬ？後的params也讀進來。如：http://XXX/XX.json?type=0
				loadParams(request);
				loadBody(request);
			}
			catch(Exception e) {
				log.error(StringUtil.getStackTraceAsString(e));
			}
		}
		
		private void loadParams(HttpServletRequest request){
			Enumeration<String> enu = request.getParameterNames();
			while(enu.hasMoreElements()){
				String key = enu.nextElement();
				log.debug("{}.loadParams(). key: {}", this.getClass(), key);
				table.put(key, request.getParameterValues(key));
			}
		}
		
		private void loadBody(HttpServletRequest request) throws Exception{
			String str = this.getBody(request.getReader());
			log.debug("{}.loadBody(). body info: {}", this.getClass(), str);
			if(!StringUtil.isEmptyString(str)) {
				log.trace("start to parse body information.");
				str = str.replaceAll("\"", "");
				String[] keyValues = str.split("&");
				for(String keyValue : keyValues) {
					String[] temp = keyValue.split("=");
					String key = temp[0];
					String value = temp[1];
					String[] vs = {value};
					table.put(key, vs);
				}
			}
		}
		
		private String getBody(Reader reader) throws Exception {
			StringBuilder sb = new StringBuilder();
			char[] charBuffer = new char[128];
	        int bytesRead;
	        while ( (bytesRead = reader.read(charBuffer)) != -1 ) {
	            sb.append(charBuffer, 0, bytesRead);
	        }	
	        return sb.toString();
		}
		
		
		
		@Override
		public Map<String, String[]> getParameterMap() {
			return table;
		}
		
		@Override
		public String getParameter(String name) {
			String[] value = table.get(name);
			log.debug("{}.getParameter(). name: {}, value: {}", this.getClass(), name, value);
			String result = "";
			if(value != null && value.length > 0)
				result = value[0];
			return result;
		}
		
		@Override
		public Enumeration<String> getParameterNames() {
			return table.keys();
		}
		
		@Override
		public String[] getParameterValues(String name) {
			return table.get(name);
		}

		@Override
		public String getContentType() {
			return type;
		}

	}

}
