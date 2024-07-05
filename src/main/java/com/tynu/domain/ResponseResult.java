package com.tynu.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.tynu.enums.AppHttpCodeEnum;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseResult<T> implements Serializable {
	private Integer code;
	private String msg;
	private T data;

	/**
	 * 默认成功结果响应
	 */
	public ResponseResult() {
		this.code = AppHttpCodeEnum.SUCCESS.getCode();
		this.msg = AppHttpCodeEnum.SUCCESS.getMsg();
	}

	/**
	 * 响应码+数据
	 * @param code
	 * @param data
	 */
	public ResponseResult(Integer code, T data) {
		this.code = code;
		this.data = data;
	}

	public ResponseResult(Integer code, String msg, T data) {
		this.code = code;
		this.msg = msg;
		this.data = data;
	}

	/**
	 * 不携带数据的返回结果
	 * @param code
	 * @param msg
	 */
	public ResponseResult(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	/**
	 * 错误的结果，返回状态码和错误消息提示
	 * @param code
	 * @param msg
	 * @return
	 */
	public static ResponseResult errorResult(int code, String msg) {
		ResponseResult result = new ResponseResult();
		return result.error(code, msg);
	}


	public static ResponseResult okResult() {
		ResponseResult result = new ResponseResult();
		return result;
	}
	public static ResponseResult okResult(int code, String msg) {
		ResponseResult result = new ResponseResult();
		return result.ok(code, null, msg);
	}

	/**
	 * 自定义data的成功结果
	 * @param data
	 * @return
	 */
	public static ResponseResult okResult(Object data) {
		ResponseResult result = setAppHttpCodeEnum(AppHttpCodeEnum.SUCCESS, AppHttpCodeEnum.SUCCESS.getMsg());
		if(data!=null) {
			result.setData(data);
		}
		return result;
	}

	public static ResponseResult errorResult(AppHttpCodeEnum enums){
		return setAppHttpCodeEnum(enums,enums.getMsg());
	}

	public static ResponseResult errorResult(AppHttpCodeEnum enums, String msg){
		return setAppHttpCodeEnum(enums,msg);
	}

	public static ResponseResult setAppHttpCodeEnum(AppHttpCodeEnum enums){
		return okResult(enums.getCode(),enums.getMsg());
	}

	private static ResponseResult setAppHttpCodeEnum(AppHttpCodeEnum enums, String msg){
		return okResult(enums.getCode(),msg);
	}

	public ResponseResult<?> error(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
		return this;
	}

	public ResponseResult<?> ok(Integer code, T data) {
		this.code = code;
		this.data = data;
		return this;
	}

	public ResponseResult<?> ok(Integer code, T data, String msg) {
		this.code = code;
		this.data = data;
		this.msg = msg;
		return this;
	}

	public ResponseResult<?> ok(T data) {
		this.data = data;
		return this;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}



}
