package com.zanbei.vo;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonSetter;
 
/**
 * <pre>
 * 业务名:
 * 功能说明: 
 * 编写日期:	2015年11月20日17:44:42
 * 作者:	DC
 * 
 * 历史记录
 * 1、修改日期：
 *    修改人：
 *    修改内容：
 * </pre>
 */
public class BaseVo implements Serializable{ 
	private static final long serialVersionUID = -1629011640663014271L;
	
	private boolean succ;
	// 错误信息
	private String mes;

	@JsonSetter(value = "mes")
	public String getMes() {
		return mes;
	}
	@JsonSetter(value = "mes")
	public void setMes(String mes) {
		this.mes = mes;
	}
	@JsonProperty(value = "succ") 
	public boolean getSucc() {
		return succ;
	}
	@JsonSetter(value = "succ") 
	public void setSucc(boolean succ) {
		this.succ = succ;
	}
 
  }
