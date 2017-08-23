/**
 * 
 */
package ggd.core.acl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import baytony.util.Util;
import ggd.core.common.Config;
import ggd.core.common.Constant;

/**
 * 提供{@link ViewController}進行Access Control List邏輯檢查的程式.
 * 
 * @author baytony
 *
 */
public class AclManager {

	private final static Logger log = LoggerFactory.getLogger(AclManager.class);
	private final List<Acl> wSettings = new ArrayList<Acl>();
	private Config config;
	private String wGoto;
	
	public AclManager(Config config, List<String> wList) {
		if(!config.isEmptyConfig()){
			this.config = config;
			init(wList);
		} else {
			log.info("******** No ACL data found! ********");
		}
	}

	private void init(List<String> wList){
		log.trace("init ACL data.");
		wGoto = config.getValue(Constant.ACL_WHITE_LIST_DEF_GOTO);
		log.trace("init ACL data. wGoto : {}.", wGoto);
		//白名單處理
		if( !Util.isEmpty(wList) ){
			for(String as : wList){
				if(Util.isEmpty(as)){
					continue;
				}
				wSettings.add(new Acl(as));
			}
			log.info("System start with white list set. {}.", toString());
			return ;
		} else {
			log.info("NO white list is set!");
		}
		log.info("******** No ACL data found! ********");
		
	}
	
	public String checkAcl(String path){
		if(!Util.isEmpty(wSettings)){
			log.trace("Check {} in white list.", path);
			for(Acl a : wSettings){
				if(a != null && a.match(path)){
					log.info("Match {} white list. {}.", path, a);
					return null;
				}
			}
			return wGoto;
		}
		return null;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AclManager [config=");
		builder.append(config);
		builder.append(", wGoto=");
		builder.append(wGoto);
		builder.append(", wSettings=");
		builder.append(wSettings);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
