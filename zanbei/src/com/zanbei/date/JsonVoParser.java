package com.zanbei.date;

import com.zanbei.vo.BaseVo;
import com.zanbei.vo.InvestmentListBodyVo;



/**
 * <pre>
 * 业务名:
 * 功能说明: vo解析统一管理类
 * 编写日期:	2015年5月11日
 * 作者:	zgz
 * 
 * 历史记录
 * 1、修改日期：
 *    修改人：
 *    修改内容：
 * </pre>
 */
public class JsonVoParser {
	private static JsonVoParser _jsonVoParser;

	public static JsonVoParser getInstance() {
		if (null == _jsonVoParser) {
			_jsonVoParser = new JsonVoParser();
		}
		return _jsonVoParser;
	} 
	private static JsonBinder jsonBinder = JsonBinder.buildNonNullBinder();

	public BaseVo getBasevo(String jsonvo){
		return jsonBinder.fromJson(jsonvo, BaseVo.class);
	}
   
	/**
	 * 投资或债券转让-列表
	 * 
	 * @param json
	 * @return
	 */
	public InvestmentListBodyVo getInvestmentListBodyVo(String json) {
		return jsonBinder.fromJson(json, InvestmentListBodyVo.class);
	} 
	/*
	 * 登陆的解析
	 */
//	public UserLoginBodyVo getUserLoginBodyVo(String json){
//		return jsonBinder.fromJson(json, UserLoginBodyVo.class);
//	}

//	//首页加载
//	public HomePageBodyVo gethoHomePageBodyVo(String json){
//		return jsonBinder.fromJson(json, HomePageBodyVo.class);
//	}
//	//首页bottom加载
//	public HomePageBottomEntityVo getHomePageBottomEntityVo(String json){
//		return jsonBinder.fromJson(json, HomePageBottomEntityVo.class);
//	}
//	//考证页加载
//	public ExamPageEntityVo getExamPageEntityVo(String json){
//		return jsonBinder.fromJson(json, ExamPageEntityVo.class);
//	}
//	//助学宝页加载
//	public ZxbEntityVo getzxbEntityVo(String json){
//		return jsonBinder.fromJson(json, ZxbEntityVo.class);
//	}
//	//助学宝页Item加载
//	public ZxbItemEntityVo getzxbItemEntityVo(String json){
//		return jsonBinder.fromJson(json, ZxbItemEntityVo.class);
//	}
//	//助学宝页Item加载
//	public ShakeLimitEntityVo getShakeLimitEntityVo(String json){
//		return jsonBinder.fromJson(json, ShakeLimitEntityVo.class);
//	}
//	//试听课程
//	public CourseEntityVo getCourseEntityVo(String json){
//		return jsonBinder.fromJson(json, CourseEntityVo.class);
//	}
//	//课程详情
//	public ParticularCourseEntityVo getParticularCourseEntityvo(String json){
//		return jsonBinder.fromJson(json, ParticularCourseEntityVo.class);
//	}
//	//已购买课程列表
//	public MyPurchaseCourseEntityVo getMyPurchaseCourseEntityVo(String json){
//		return jsonBinder.fromJson(json, MyPurchaseCourseEntityVo.class);
//	}
//	//收藏课程列表
//	public CollectCourseEntityVo getCollectCourseEntityVo(String json){
//		return jsonBinder.fromJson(json, CollectCourseEntityVo.class);
//	}
//	//课程讨论
//	public DiscussCourseEntityVo getDiscussCourseEntityVo(String json){
//		return jsonBinder.fromJson(json, DiscussCourseEntityVo.class);
//	}
	
	//	//赎回债权解析
	//	public CallBondsBodyVo getCallBondsBodyVo(String json){
	//		return jsonBinder.fromJson(json, CallBondsBodyVo.class);
	//	}
	//	//赎回债权信息解析
	//	public CallBondAlertBodyVo getCallBondAlertBodyVo(String json){
	//		return jsonBinder.fromJson(json, CallBondAlertBodyVo.class);
	//	}
	//	//宜定投：账户信息的解析
	//	public AccountBodyVo getAccountBodyVo(String json){
	//		return jsonBinder.fromJson(json, AccountBodyVo.class);
	//	}
	//	//客服信息
	//	public ServerMessageBodyVo getServerMessageBodyVo(String json){
	//		return jsonBinder.fromJson(json, ServerMessageBodyVo.class);
	//	}
	//	//产品详情解析
	//	public ProductDetailsBodyVo getProductDetailsBodyVo(String json){
	//		return jsonBinder.fromJson(json, ProductDetailsBodyVo.class);
	//	}
	//	//用户信息
	//	public CertificateInfoBodyVo getCertificateInfoBodyVo(String json){
	//		return jsonBinder.fromJson(json, CertificateInfoBodyVo.class);
	//	}
	//	//用户信息
	//		public FengfuBuyBody getFengFuBuyInfo(String json){
	//			return jsonBinder.fromJson(json, FengfuBuyBody.class);
	//		}
	//	//宜定投项目首页加载
	//	public EdingtouProjectVo getEdingtouProjectVo(String json){
	//		return jsonBinder.fromJson(json, EdingtouProjectVo.class);
	//	}
}