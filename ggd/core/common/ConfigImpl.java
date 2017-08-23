package ggd.core.common;

import java.util.HashMap;
import java.util.Map;

import baytony.util.Util;

public class ConfigImpl implements Config {
	
	protected final Map<String,String> map = new HashMap<String, String>();
	protected final String name;
	
	public ConfigImpl(String name, Map<String,String> map) {
		this.name = name;
		if(!map.isEmpty()){
			this.map.putAll(map);
		}
	}
	
	public String getCodeMessage(String code) {
		return map.get(code);
	}
	
	@Override
	public boolean isEmptyConfig() {
		return Util.isEmpty(map);
	}
	
	@Override
	public String getValue(String key) {
		return this.getValue(key, null);
	}
	
	@Override
	public String getValue(String key, String defaultValue) {
		String res = null;
		if(map.containsKey(key)){
			res = map.get(key);
		}
		if(Util.isEmpty(res)){
			return defaultValue;
		}
		
		return res;
	}

	@Override
	public String getConfigName() {
		return name;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ConfigImpl [map=");
		builder.append(map);
		builder.append(", name=");
		builder.append(name);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		ConfigImpl other = (ConfigImpl) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}
