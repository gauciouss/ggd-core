package ggd.core.entity;

import baytony.util.Util;
import ggd.core.common.CodeMsg;
import ggd.core.common.Constant;

public class ServiceResponse {
	
	private final Header header;
	private final Object body;


	public ServiceResponse(Header header, Object body) {
		if(header == null){
			this.header = new Header();
		} else {
			this.header = header;
		}
		this.body = body;
	}
	
	public Header getHeader() {
		return header;
	}

	public Object getBody() {
		if(body == null){
			return Constant.EMPTY;
		}
		return body;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ServiceResponse [header=");
		builder.append(header);
		builder.append(", body=");
		builder.append(body);
		builder.append("]");
		return builder.toString();
	}

	public static class Header {
		private String code;
		private String msg = Constant.EMPTY;
		private String ext = Constant.EMPTY;
		private String remoteIP = Constant.EMPTY;
		private String inTime = Constant.EMPTY;
		private String outTime = Constant.EMPTY;
		private String exeTime = Constant.EMPTY;

		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}

		public String getMsg() {
			if ( Util.isEmpty(msg) ) {
				this.msg = CodeMsg.getCodeMessage(code);
			}
			if(Util.isEmpty(msg)){
				return Constant.EMPTY;
			}
			return msg;
		}

		public void setMsg(String msg) {
			this.msg = msg;
		}

		public String getExt() {
			if(Util.isEmpty(ext)){
				return Constant.EMPTY;
			}
			return ext;
		}

		public void setExt(String ext) {
			this.ext = ext;
		}

		public String getRemoteIP() {
			if(Util.isEmpty(remoteIP)){
				return Constant.EMPTY;
			}
			return remoteIP;
		}

		public void setRemoteIP(String remoteIP) {
			this.remoteIP = remoteIP;
		}

		public String getInTime() {
			if(Util.isEmpty(inTime)){
				return Constant.EMPTY;
			}
			return inTime;
		}

		public void setInTime(String inTime) {
			this.inTime = inTime;
		}

		public String getOutTime() {
			if(Util.isEmpty(outTime)){
				return Constant.EMPTY;
			}
			return outTime;
		}

		public void setOutTime(String outTime) {
			this.outTime = outTime;
		}

		public String getExeTime() {
			if(Util.isEmpty(exeTime)){
				return Constant.EMPTY;
			}
			return exeTime;
		}

		public void setExeTime(String exeTime) {
			this.exeTime = exeTime;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Header [code=");
			builder.append(code);
			builder.append(", msg=");
			builder.append(msg);
			builder.append(", ext=");
			builder.append(ext);
			builder.append(", remoteIP=");
			builder.append(remoteIP);
			builder.append(", inTime=");
			builder.append(inTime);
			builder.append(", outTime=");
			builder.append(outTime);
			builder.append(", exeTime=");
			builder.append(exeTime);
			builder.append("]");
			return builder.toString();
		}
	}
}
