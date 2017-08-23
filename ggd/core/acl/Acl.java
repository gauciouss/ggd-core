package ggd.core.acl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Acl {

	private final String setting;
	private final Pattern matcher;
	
	public Acl(String setting) {
		this.setting = setting;
		this.matcher = Pattern.compile(setting);
	}
	
	public boolean match(String path){
		Matcher ma = matcher.matcher(path);
		return ma.find();
	}

	public Pattern getMatcher() {
		return matcher;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Acl [setting=");
		builder.append(setting);
		builder.append(", matcher=");
		builder.append(matcher);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((setting == null) ? 0 : setting.hashCode());
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
		Acl other = (Acl) obj;
		if (setting == null) {
			if (other.setting != null)
				return false;
		} else if (!setting.equals(other.setting))
			return false;
		return true;
	}
	
	
	
}
