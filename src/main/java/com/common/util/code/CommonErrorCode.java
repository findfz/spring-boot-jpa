package com.common.util.code;

/**
 * Author：xiongzhan
 * Description：自定义公用错误码
 * Date: 2018-07-28 23:07
 */
public enum CommonErrorCode implements ErrorCode {
	
	SYSTEM_ERROR(1, "系统异常"),


	NO_SESSION(401, "未授权的访问！"),
	INNER_ERROR(500, "系统内部错误:{0}"),

    ;

	
	private int code;
	private String errorMsg;

	CommonErrorCode(int code, String errorMsg) {
		this.code = code;
		this.errorMsg = errorMsg;
	}

	public int getCode() {
		return code;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

}
