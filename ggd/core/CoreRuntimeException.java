package ggd.core;

import ggd.core.common.CodeMsg;

public class CoreRuntimeException extends RuntimeException {

	private static final long serialVersionUID = 4459739950722996615L;

	private final String code;

	public CoreRuntimeException(String code) {
		super(CodeMsg.getCodeMessage(code));
		this.code = code;
	}

	public CoreRuntimeException(String code, Throwable arg0) {
		super(CodeMsg.getCodeMessage(code), arg0);
		this.code = code;
	}

	public String getCode() {
		return code;
	}

}
