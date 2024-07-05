package com.tynu.enums;


import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * DATE: 2022/12/11
 * Author: 李毫
 * Description:
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum CameraStatusEnum {
	NORMAL(0,"在线"),
	OFFLINE(1,"离线");

	private Integer statusCode;
	private String statusMsg;

	public static CameraStatusEnum getInstance(Integer statusCode){
		for (CameraStatusEnum value: values()){
			if (value.getStatusCode().equals(statusCode)){
				return value;
			}
		}
		return null;
	}

	CameraStatusEnum(Integer statusCode, String statusMsg){
		this.statusCode = statusCode;
		this.statusMsg = statusMsg;
	}

	public Integer getStatusCode(){
		return statusCode;
	}

	public String getStatusMsg(){
		return statusMsg;
	}

	public void setStatusCode(Integer statusCode){
		this.statusCode = statusCode;
	}

	public void setStatusMsg(String statusMsg){
		this.statusMsg = statusMsg;
	}
}
