package ggd.core.config;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import baytony.util.net.http.HttpProxy;
import ggd.core.common.Config;
import ggd.core.common.ConfigImpl;

/**
 * 這支程式主要在管理系統設定檔{@link Config}物件的產生
 * 
 * @author baytony
 *
 */
@Configuration
public class XML_Config {
	
	private static final Logger log = LoggerFactory.getLogger(XML_Config.class);
	
	public static final String URL_CONFIG = "URL_CONFIG";
	public static final String DISPLAY_CONFIG = "DISPLAY_CONFIG";
	public static final String COMMON_CONFIG = "COMMON_CONFIG";
	public static final String HTTP_PROXY = "HTTP_PROXY";

	@Resource(name="URL_HOST_MAP")
	private Map<String, String> host;
	
	@Resource(name="URL_PATH_MAP")
	private Map<String, String> path;
	
	@Resource(name="COMMON_MAP")
	private Map<String, String> common;
	
	@Resource(name="DISPLAY_MAP")
	private Map<String, String> display;
	
	@Bean(name={URL_CONFIG})
	public Config getURL() {
		HashMap< String, String> map = new HashMap<String, String>();
		map.putAll(host);
		map.putAll(path);
		Config c = new ConfigImpl(URL_CONFIG, map);
		log.info("{} : {}", URL_CONFIG, c);
		return c;
	}
	
	@Bean(name={DISPLAY_CONFIG})
	public Config getDisplay() {
		HashMap< String, String> map = new HashMap<String, String>();
		map.putAll(display);
		Config c = new ConfigImpl(DISPLAY_CONFIG, map);
		log.info("{} : {}", DISPLAY_CONFIG, c);
		return c;
	}
	
	@Bean(name={COMMON_CONFIG})
	public Config getCommon() {
		HashMap< String, String> map = new HashMap<String, String>();
		map.putAll(common);
		Config c = new ConfigImpl(COMMON_CONFIG, map);
		log.info("{} : {}", COMMON_CONFIG, c);
		return c;
	}
	
	@Bean(name={HTTP_PROXY})
	public HttpProxy getHttpProxy() {
		return new HttpProxy();
	} 
}
