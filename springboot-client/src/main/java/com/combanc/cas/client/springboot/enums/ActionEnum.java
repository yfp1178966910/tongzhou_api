package com.combanc.cas.client.springboot.enums;

/**
 * Created with Intellij IDEA
 * @author qhl
 * Date 2018/6/1
 * Time 15:31
 */
public enum ActionEnum {

	/** 添加*/
	create("添加"),
	update("修改"),
	delete("删除");

	
	private String code;
	private String name;	
	ActionEnum(String name) {
		this.code = this.name();
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
