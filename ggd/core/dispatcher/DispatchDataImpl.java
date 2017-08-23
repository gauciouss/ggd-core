package ggd.core.dispatcher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.JsonNode;

import baytony.util.Util;
import ggd.core.CoreException;
import ggd.core.util.JSONUtil;

/**
 * 
 *   {
	  "user": {
	    "loginId": "A111111111",
	    "accounts": "U0592x0000013,F0180006666666,G0F0180009999999,G0F0180000980944,G0F0180000996003,59209999998,592a9999996,592m9999998,F0180009999998,C05920000660",
	    "name": "",
	    "debitAcc": "",
	    "tik": "49e0b34c-bf76-4b98-9b22-1e8b156054bf"
	  },
	  "tim": "1459920169070",
	  "ver": "1.0.01",
	  "ip": "", 
	  "device": "", ANDROID/IPHONE/IPAD 
	  "deviceId": "", “MF產生的UUID”
	  "uuid": "", “Cordova產生的UUID”
	  "osVersion": "" “OS版本編號”
	}
 * 
 * @author baytony
 *
 */
public class DispatchDataImpl implements DispatchData {

	private static final long serialVersionUID = -634343846675509098L;
	private final static Logger log = LoggerFactory.getLogger(DispatchDataImpl.class);

	private final String arg;
	private final String folder;
	private final String jsp;
	private UserInfo userInfo;
	private boolean json;

	public DispatchDataImpl(String folder, String jsp, String arg, String ip) {
		this.folder = folder;
		this.jsp = jsp;
		this.arg = arg;
		if (!Util.isEmpty(arg)) {
			//如果arg不為空直，試著進行JSON PARSER.
			JsonNode root = null;
			try {
				root = JSONUtil.parser(arg);
				log.trace("JsonNode Created! Start Parser USER_INFO.");
				userInfo = new UserInfoImpl(root, ip);
				json = true;
				log.trace("{}", toString());
			} catch (CoreException e) {
				log.warn("USER_INFO Parser ERROR. code : {}", e.getCode());
			} catch (Exception e) {
				//JSON PARSER失敗，當作一般字串處理.
				userInfo = null;
				json = false;
				log.warn("DispatchData paser ERROR! arg : {}. msg : {}", arg, e.getMessage(), e);
			}
		}
	}
	
	@Override
	public boolean isArgJson() {
		return json;
	}

	@Override
	public String getArg() {
		return arg;
	}

	public String getFolder() {
		return folder;
	}

	public String getJsp() {
		return jsp;
	}

	@Override
	public UserInfo getUserInfo() {
		return userInfo;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DispatchDataImpl [arg=");
		builder.append(arg);
		builder.append(", folder=");
		builder.append(folder);
		builder.append(", jsp=");
		builder.append(jsp);
		builder.append(", userInfo=");
		builder.append(userInfo);
		builder.append(", json=");
		builder.append(json);
		builder.append("]");
		return builder.toString();
	}


}
