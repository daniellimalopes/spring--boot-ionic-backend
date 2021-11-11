package com.daniellima.cursomc.resources.Exception;

import java.io.Serializable;

public class StandardError implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer status;
	private String msg;
	private Long timeStamo;

	public StandardError(Integer status, String msg, Long timeStamo) {
		super();
		this.status = status;
		this.msg = msg;
		this.timeStamo = timeStamo;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Long getTimeStamo() {
		return timeStamo;
	}

	public void setTimeStamo(Long timeStamo) {
		this.timeStamo = timeStamo;
	}

}
