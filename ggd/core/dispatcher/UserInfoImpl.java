package ggd.core.dispatcher;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.JsonNode;

import baytony.util.Util;
import ggd.core.CoreException;
import ggd.core.common.CodeMsg;
import ggd.core.common.Constant;
import ggd.core.util.JSONUtil;

/**
 * AAA
 * @author baytony
 *
 */
public class UserInfoImpl implements UserInfo{
	
	private static final long serialVersionUID = 5604718359594540629L;
	private static final String EMPTY = Constant.EMPTY;

	private final String ver;
	private final String ip;
	private final String tim;
	private final String device;
	private final String deviceId;
	private final String uuid;
	private final String osVersion;
	private final User user;
	@JsonIgnore
	private final JsonNode params;
	
	public UserInfoImpl(JsonNode root, String ip) throws CoreException {
		this.ver = JSONUtil.getString(root, Constant.VER, CodeMsg.getCodeMessage(CodeMsg.CORE_001));
		this.tim = JSONUtil.getString(root, Constant.TIM, CodeMsg.getCodeMessage(CodeMsg.CORE_002));
		this.device = JSONUtil.getString(root, Constant.DEVICE, CodeMsg.getCodeMessage(CodeMsg.CORE_003));
		String tmp = JSONUtil.getStringDef(root, Constant.IP, EMPTY);
		if(Util.isEmpty(tmp)){
			this.ip = ip;
		} else {
			this.ip = tmp;
		}
		this.deviceId = JSONUtil.getStringDef(root, Constant.DEVICE_ID, EMPTY);
		this.uuid = JSONUtil.getStringDef(root, Constant.UUID, EMPTY);
		this.osVersion = JSONUtil.getStringDef(root, Constant.OS_VERSION, EMPTY);
		this.user = new UserImpl(root.get(Constant.USER));
		this.params = root.get(Constant.PARAMS);
	}
	public User getUser() {
		return user;
	}
	public String getVer() {
		return ver;
	}
	public String getIp() {
		return ip;
	}
	public String getTim() {
		return tim;
	}
	public String getDevice() {
		return device;
	}
	public String getDeviceId() {
		return deviceId;
	}
	public String getUuid() {
		return uuid;
	}
	public String getOsVersion() {
		return osVersion;
	}
	/**
	 * @return
	 */
	public JsonNode getParams(){
		return params;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UserInfoImpl [user=");
		builder.append(user);
		builder.append(", ver=");
		builder.append(ver);
		builder.append(", ip=");
		builder.append(ip);
		builder.append(", tim=");
		builder.append(tim);
		builder.append(", device=");
		builder.append(device);
		builder.append(", deviceId=");
		builder.append(deviceId);
		builder.append(", uuid=");
		builder.append(uuid);
		builder.append(", osVersion=");
		builder.append(osVersion);
		builder.append(", params=");
		builder.append(params);
		builder.append("]");
		return builder.toString();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((device == null) ? 0 : device.hashCode());
		result = prime * result
				+ ((deviceId == null) ? 0 : deviceId.hashCode());
		result = prime * result + ((ip == null) ? 0 : ip.hashCode());
		result = prime * result
				+ ((osVersion == null) ? 0 : osVersion.hashCode());
		result = prime * result + ((tim == null) ? 0 : tim.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		result = prime * result + ((uuid == null) ? 0 : uuid.hashCode());
		result = prime * result + ((ver == null) ? 0 : ver.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserInfoImpl other = (UserInfoImpl) obj;
		if (device == null) {
			if (other.device != null)
				return false;
		} else if (!device.equals(other.device))
			return false;
		if (deviceId == null) {
			if (other.deviceId != null)
				return false;
		} else if (!deviceId.equals(other.deviceId))
			return false;
		if (ip == null) {
			if (other.ip != null)
				return false;
		} else if (!ip.equals(other.ip))
			return false;
		if (osVersion == null) {
			if (other.osVersion != null)
				return false;
		} else if (!osVersion.equals(other.osVersion))
			return false;
		if (tim == null) {
			if (other.tim != null)
				return false;
		} else if (!tim.equals(other.tim))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		if (uuid == null) {
			if (other.uuid != null)
				return false;
		} else if (!uuid.equals(other.uuid))
			return false;
		if (ver == null) {
			if (other.ver != null)
				return false;
		} else if (!ver.equals(other.ver))
			return false;
		return true;
	}
	
}
