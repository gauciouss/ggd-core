package ggd.core.config;
 
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import ggd.core.acl.AclManager;
import ggd.core.common.Config;
 
/**
 * 
 * 	
 * 
 * @author baytony
 *
 */
@Configuration
@ComponentScan({"masterlink.futures.eopen", "masterlink.futures.ms", "masterlink.futures.ap"})
public class DispatcherConfig {
	
	private static final Logger log = LoggerFactory.getLogger(DispatcherConfig.class);
	
	public static final String EOPEN_ACL = "EOPEN_ACL";
	
	@Resource(name = XML_Config.COMMON_CONFIG)
	private Config common;
	
	@Resource(name = XML_Config.URL_CONFIG)
	private Config url;
	
	@Resource(name="ACL_WHITE_LIST")
	private List<String> wList;
	
	@Bean(name={EOPEN_ACL})
	public AclManager getACL() {
		return new AclManager(common, wList);
	}
	
	
 
}