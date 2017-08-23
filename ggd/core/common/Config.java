package ggd.core.common;

/**
 * 
 * 這個介面裡定義了系統所有可能的程式執行代碼, 錯誤及正常的.
 * @author baytony
 *
 */
public interface Config {
	
	public String getValue(String key);
	
	public String getValue(String key, String defaultValue);
	
	public String getConfigName();
	
	public boolean isEmptyConfig();
}
