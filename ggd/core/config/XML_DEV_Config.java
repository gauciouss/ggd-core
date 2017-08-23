package ggd.core.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource(value = {
		"file:/Users/gauciouss/projects/masterlink/futures-eopen/53-source/eopen_ap_config/URL.dev.xml",
		"file:/Users/gauciouss/projects/masterlink/futures-eopen/53-source/eopen_ap_config/Common.xml",
		"file:/Users/gauciouss/projects/masterlink/futures-eopen/53-source/eopen_ap_config/Display.xml",
		"file:/Users/gauciouss/projects/masterlink/futures-eopen/53-source/eopen_ap_config/auth_core.xml", 
		"file:/Users/gauciouss/projects/masterlink/futures-eopen/53-source/eopen_ap_config/db.xml"})
public class XML_DEV_Config {

}