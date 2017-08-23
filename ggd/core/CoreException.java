package ggd.core;

import ggd.core.common.CodeMsg;

public class CoreException extends Exception {

	private static final long serialVersionUID = -157997817233749545L;
	
	private final String code;

	public CoreException(String code) {
		super(CodeMsg.getCodeMessage(code));
		this.code=code;
	}
	
	public CoreException(String code, String defineMsg) {
		super(defineMsg);
		this.code=code;
	} 

	public CoreException(String code,Throwable arg0) {
		super(CodeMsg.getCodeMessage(code), arg0);
		this.code=code;
	}
	
	public String getCode(){
		return code;
	}
	
	
}
