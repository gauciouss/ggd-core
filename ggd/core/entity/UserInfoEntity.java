package ggd.core.entity;

import java.io.Serializable;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class UserInfoEntity implements Serializable {

	private static final long serialVersionUID = 47006481298178051L;
	
	private static final ObjectMapper mapper = new ObjectMapper();

	/**
	 * 身分證字號
	 */
	private String id;

	/**
	 * login成功後,Server給的token ( 這邊會與底下的tim做加密壓碼 )
	 */
	private String tik;

	/**
	 * 時間long值
	 */
	private String tim;

	/**
	 * android / IPhone / IPad
	 */
	private String device;

	/**
	 * 手機裝置id
	 */
	private String deviceId;

	/**
	 * cordova針對手持裝置產生的代碼
	 */
	private String uuid;

	/**
	 * 手持裝置的作業系統版本
	 */
	private String osVersion;

	/**
	 * 元富i理財APP的版本編號
	 */
	private String ver;
	
	public UserInfoEntity() {
	}

	public UserInfoEntity(String id, String tik, String tim, String device,
			String deviceId, String uuid, String osVersion, String ver) {
		super();
		this.id = id;
		this.tik = tik;
		this.tim = tim;
		this.device = device;
		this.deviceId = deviceId;
		this.uuid = uuid;
		this.osVersion = osVersion;
		this.ver = ver;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTik() {
		return tik;
	}

	public void setTik(String tik) {
		this.tik = tik;
	}

	public String getTim() {
		return tim;
	}

	public void setTim(String tim) {
		this.tim = tim;
	}

	public String getDevice() {
		return device;
	}

	public void setDevice(String device) {
		this.device = device;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getOsVersion() {
		return osVersion;
	}

	public void setOsVersion(String osVersion) {
		this.osVersion = osVersion;
	}

	public String getVer() {
		return ver;
	}

	public void setVer(String ver) {
		this.ver = ver;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((device == null) ? 0 : device.hashCode());
		result = prime * result
				+ ((deviceId == null) ? 0 : deviceId.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((osVersion == null) ? 0 : osVersion.hashCode());
		result = prime * result + ((tik == null) ? 0 : tik.hashCode());
		result = prime * result + ((tim == null) ? 0 : tim.hashCode());
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
		UserInfoEntity other = (UserInfoEntity) obj;
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (osVersion == null) {
			if (other.osVersion != null)
				return false;
		} else if (!osVersion.equals(other.osVersion))
			return false;
		if (tik == null) {
			if (other.tik != null)
				return false;
		} else if (!tik.equals(other.tik))
			return false;
		if (tim == null) {
			if (other.tim != null)
				return false;
		} else if (!tim.equals(other.tim))
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UserInfoEntity [id=");
		builder.append(id);
		builder.append(", tik=");
		builder.append(tik);
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
		builder.append(", ver=");
		builder.append(ver);
		builder.append("]");
		return builder.toString();
	}
	
	
	public String toJson() {
		try {
			return mapper.writeValueAsString(this);
		} catch (JsonProcessingException e) { 
			e.printStackTrace();
		}
		return null;
	}

}
