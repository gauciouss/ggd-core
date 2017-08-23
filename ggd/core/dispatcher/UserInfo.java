package ggd.core.dispatcher;

import java.io.Serializable;

import com.fasterxml.jackson.databind.JsonNode;

public interface UserInfo extends Serializable{

	/**
	 * @return
	 */
	public String getVer();
	
	/**
	 * @return
	 */
	public String getIp();
	
	/**
	 * @return
	 */
	public String getTim();
	
	public String getDevice();
	
	public String getDeviceId();
	
	public String getUuid();
	
	public String getOsVersion();
	
	/**
	 * @return
	 */
	public User getUser();
	
	/**
	 * @return
	 */
	public JsonNode getParams();
	
}
