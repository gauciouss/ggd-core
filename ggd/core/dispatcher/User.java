package ggd.core.dispatcher;

import java.io.Serializable;

public interface User extends Serializable{

	public String getLoginId();
	
	public String getAccounts();
	
	public String getName();
	
	public String getDebitAcc();
	
	/**
	 * @return
	 */
	public String getTik();
	
}
