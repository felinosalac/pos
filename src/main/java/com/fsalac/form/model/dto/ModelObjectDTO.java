package com.fsalac.form.model.dto;

import java.io.Serializable;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.ToStringBuilder;


@SuppressWarnings("serial")
public class ModelObjectDTO  implements Serializable{

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	
	public String replaceNull(String value){
		return !StringUtils.isEmpty(value) ? value : "";
	}
	
}
