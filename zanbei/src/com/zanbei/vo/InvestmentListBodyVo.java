package com.zanbei.vo;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonSetter;


public class InvestmentListBodyVo extends BaseVo {
	/**
	 * 
	 */
	private static final long serialVersionUID = -640111533706747802L;
	/**
	 * 
	 */
	private InvestmentListVo body;

	@JsonProperty(value = "body")
	public InvestmentListVo getBody() {
		return body;
	}

	@JsonSetter(value = "body")
	public void setBody(InvestmentListVo body) {
		this.body = body;
	}

}
