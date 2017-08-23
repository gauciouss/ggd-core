package ggd.core.dispatcher;

import com.fasterxml.jackson.databind.JsonNode;

import ggd.core.CoreException;
import ggd.core.common.CodeMsg;
import ggd.core.common.Constant;
import ggd.core.util.JSONUtil;

public class UserImpl implements User{

	private static final long serialVersionUID = -2387049334466925159L;
	private static final String EMPTY = Constant.EMPTY;
	
	private final String loginId;
	private final String accounts;
	private final String name;
	private final String debitAcc;
	private final String tik;
	
	public UserImpl(JsonNode root) throws CoreException {
		this.loginId = JSONUtil.getString(root, Constant.LOGIN_ID, CodeMsg.getCodeMessage(CodeMsg.CORE_004));
		this.debitAcc = JSONUtil.getString(root, Constant.DEBIT_ACC, CodeMsg.getCodeMessage(CodeMsg.CORE_005));
		this.tik = JSONUtil.getString(root, Constant.TIK, CodeMsg.getCodeMessage(CodeMsg.CORE_006));
		this.accounts = JSONUtil.getStringDef(root, Constant.ACCOUNTS, EMPTY);
		this.name = JSONUtil.getStringDef(root, Constant.NAME, EMPTY);

	}
	public String getLoginId() {
		return loginId;
	}
	public String getAccounts() {
		return accounts;
	}
	public String getName() {
		return name;
	}
	public String getDebitAcc() {
		return debitAcc;
	}
	public String getTik() {
		return tik;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UserImpl [loginId=");
		builder.append(loginId);
		builder.append(", accounts=");
		builder.append(accounts);
		builder.append(", name=");
		builder.append(name);
		builder.append(", debitAcc=");
		builder.append(debitAcc);
		builder.append(", tik=");
		builder.append(tik);
		builder.append("]");
		return builder.toString();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((accounts == null) ? 0 : accounts.hashCode());
		result = prime * result
				+ ((debitAcc == null) ? 0 : debitAcc.hashCode());
		result = prime * result + ((loginId == null) ? 0 : loginId.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((tik == null) ? 0 : tik.hashCode());
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
		UserImpl other = (UserImpl) obj;
		if (accounts == null) {
			if (other.accounts != null)
				return false;
		} else if (!accounts.equals(other.accounts))
			return false;
		if (debitAcc == null) {
			if (other.debitAcc != null)
				return false;
		} else if (!debitAcc.equals(other.debitAcc))
			return false;
		if (loginId == null) {
			if (other.loginId != null)
				return false;
		} else if (!loginId.equals(other.loginId))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (tik == null) {
			if (other.tik != null)
				return false;
		} else if (!tik.equals(other.tik))
			return false;
		return true;
	}
	
}
