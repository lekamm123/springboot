package com.in28minutes.springboot.configration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("basic")
public class basicConfigration {
	@Override
	public String toString() {
		return "basicConfigration [value=" + value + ", message=" + message + ", id=" + id + ", isValue()=" + isValue()
				+ ", getMessage()=" + getMessage() + ", getId()=" + getId() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	public boolean isValue() {
		return value;
	}
	public void setValue(boolean value) {
		this.value = value;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	private boolean value;
	private String message;
	private int id;

}
