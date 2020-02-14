package com.ecommerce.main.dto;

public class ValidateUser {
	
	private String code;
	private String message;
	private String value;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "ValidateUser [code=" + code + ", message=" + message + ", value=" + value + "]";
	}
}
