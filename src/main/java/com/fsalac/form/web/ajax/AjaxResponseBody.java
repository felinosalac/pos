package com.fsalac.form.web.ajax;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonView;
import com.fsalac.form.model.dto.PosOrderDTO;

public class AjaxResponseBody {

	@JsonView(Views.Public.class)
	private String msg;

	@JsonView(Views.Public.class)
	private String code;

	@JsonView(Views.Public.class)
	private List<User> result;
	
	@JsonView(Views.Public.class)
	private List<PosOrderDTO> orders;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<User> getResult() {
		return result;
	}

	public void setResult(List<User> result) {
		this.result = result;
	}

	public List<PosOrderDTO> getOrders() {
		return orders;
	}

	public void setOrders(List<PosOrderDTO> orders) {
		this.orders = orders;
	}


	//getters and setters
}