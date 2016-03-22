/*******************************************************************************
 * Copyright (c) 2015 by dennis Corporation all right reserved.
 * 2015年5月6日 
 * 
 *******************************************************************************/
package com.zanbei.config;

import android.os.Environment;

/**
 * <pre>
 * 业务名:
 * 功能说明: 
 * 编写日期:	2016年3月7日11:12:06
 * 作者:	dc
 * 
 * 历史记录
 * 1、修改日期：
 *    修改人：
 *    修改内容：
 * </pre>
 */
public class Constants {
	/**
	 * 初始化用户信息键
	 */

	public static final String INIT_USER_INFO = "userInfo";

	public static final String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDe85G79FkpCymgQ3jPZ5qftwFsuNpMGka8+3/JpVfe728tqAO+DQHrDroaNqu6tW6XdfhBvUir7DgLq0ZE1Zlz/HwLphLhy9a0ZEoeq3SzSw9PFQAYVc9ayIclTgcfaF6T6ENGm1NodnE9YQ24N8KoaheYdc9e1woyHnecBZodBwIDAQAB";

	// 设备(运营商)
	public static int OPERATOR;
	// 屏幕宽高
	public static int SCREEN_WIDTH = 0;
	public static int SCREEN_HEIGHT = 0;
	// 版本号CODE
	public static int VERSIONCODE;
	// 版本号NAME
	public static String VERSIONNAME;
	// 系统版本
	public static int SYSTEM_VERSION;
	// 初始化请求标识
	public static int INIT_POST_IDENTIFIER = 100;
	public static int SHILI = ++INIT_POST_IDENTIFIER;
	public static int CONNECTION_TIME_OUT = 25 * 1000;
	// 发广播，带数据，有key
	public static String KEY_DATA = "key_data";

	public static final String SDCARD_ROOT = Environment
			.getExternalStorageDirectory().getAbsolutePath();

	//public static final String APK_PATH = SDCARD_ROOT + "/fangzhoujk/apk";
	// 取消请求标识
	public static final int CANCEL_POST_IDENTIFIER = ++INIT_POST_IDENTIFIER;
	public static final int INVESTMENTS_LIST = ++INIT_POST_IDENTIFIER;// 测试接口二
	public static final int TEXT = ++INIT_POST_IDENTIFIER;
	public static final int LOGIN = ++INIT_POST_IDENTIFIER;
	public static final int REIGSTER = ++INIT_POST_IDENTIFIER;
	public static final int PATIENTREIGSTER = ++INIT_POST_IDENTIFIER;
	public static final int DOC_LOGIN = ++INIT_POST_IDENTIFIER;
	// 发送邮箱
	public static final int SEND_EMAILCODE = ++INIT_POST_IDENTIFIER;
	// 忘记密码发送邮箱
	public static final int SENDFORGETPWDEMAIL = ++INIT_POST_IDENTIFIER;

	// 忘记密码逐步验证
	public static final int FOR_GET_PWORD = ++INIT_POST_IDENTIFIER;

	public static final int DOCTOR_FOR_GET_PWORD = ++INIT_POST_IDENTIFIER;

	// 发送邮箱验证码
	public static final int SEND_EMAIL_VERIFY_CODE = ++INIT_POST_IDENTIFIER;
	// 注销
	public static final int LOG_OFF = ++INIT_POST_IDENTIFIER;

	public static final int SEND_BOUND_EMAIL_CODE = ++INIT_POST_IDENTIFIER;
	public static final int SEND_PHONECODE = ++INIT_POST_IDENTIFIER;
	public static final int UPLOAD_PIC = ++INIT_POST_IDENTIFIER;

	// 意见反馈
	public static final int SUGGESTION = ++INIT_POST_IDENTIFIER;
	// 问卷调查列表
	// 我的消息
	public static final int MESSAGE = ++INIT_POST_IDENTIFIER;
	// 历史服务
	public static final int SERVERHISTORY = ++INIT_POST_IDENTIFIER;
	// 服务历史详情

	public static final int SERVERDETAILSLONG = ++INIT_POST_IDENTIFIER;
	public static final int QUESTION = ++INIT_POST_IDENTIFIER;
	// 专家列表
	public static final int DOCTORLIST = ++INIT_POST_IDENTIFIER;

	public static final int HEALTHSTEWARDFRONT = ++INIT_POST_IDENTIFIER;
	// 专家列表搜索
	public static final int DOCTORLIST_SEARCH = ++INIT_POST_IDENTIFIER;
	// 专家收入列表搜索
	public static final int DOCTORINCOMELIST_SEARCH = ++INIT_POST_IDENTIFIER;
	// 专家查看预约服务内容设置
	public static final int DOCTOR_SERVICE_CONTENT_SET_SEARCH = ++INIT_POST_IDENTIFIER;
	// 专家设置预约服务内容设置
	public static final int DOCTOR_SERVICE_CONTENT_SET = ++INIT_POST_IDENTIFIER;
	// 专家邀请人列表搜索
	public static final int DOCTORINVITELIST_SEARCH = ++INIT_POST_IDENTIFIER;
	// 专家列表筛选（省）
	public static final int DOCTORLIST_SCREEN_PROVINCE = ++INIT_POST_IDENTIFIER;
	// 专家列表筛选（类别）
	public static final int DOCTORLIST_SCREEN_OFFICE = ++INIT_POST_IDENTIFIER;
	// 专家列表筛选（级别）
	public static final int DOCTORLIST_SCREEN_LEVEL = ++INIT_POST_IDENTIFIER;

	public static final int QUESTIONCOMMIT = ++INIT_POST_IDENTIFIER;
	public static final int SHOUYE = ++INIT_POST_IDENTIFIER;
	public static final int BUY_RECORD = ++INIT_POST_IDENTIFIER;
	// 医生详情
	public static final int DOCTOR_INFO = ++INIT_POST_IDENTIFIER;
	// 购买服务
	public static final int BUY_SERVICE = ++INIT_POST_IDENTIFIER;
	// 购买会员
	public static final int BUY_VIP = ++INIT_POST_IDENTIFIER;
	// 个人资料编辑
	public static final int USER_EDIT = ++INIT_POST_IDENTIFIER;

	// 添加生理指标
	public static final int ADDHEALTHDATE = ++INIT_POST_IDENTIFIER;
	// 查询生理指标
	public static final int GETHEALTHINDEX = ++INIT_POST_IDENTIFIER;
	// 我的消息操作
	public static final int MESSAGE_SELECT = ++INIT_POST_IDENTIFIER;
	// 专家文章
	public static final int ARTICLE = ++INIT_POST_IDENTIFIER;
	// 新闻资讯
	public static final int NEWS = ++INIT_POST_IDENTIFIER;

	public static final int HISTORY_REPORT = ++INIT_POST_IDENTIFIER;
	// 医生忘记密码
	public static final int DOCTOR_FORGETPWD = ++INIT_POST_IDENTIFIER;
	// 患者忘记密码
	public static final int PATIENT_FORGETPWD = ++INIT_POST_IDENTIFIER;
	// 用户资料查看
	public static final int USERINFOR = ++INIT_POST_IDENTIFIER;

	// 会员等级信息
	public static final int MEMBER_LEVEL = ++INIT_POST_IDENTIFIER;
	// 新闻资讯或专家文章点赞
	public static final int THUMB_UP = ++INIT_POST_IDENTIFIER;

	// 修改医生个人资料
	public static final int DOCTOR_PERSONINFO = ++INIT_POST_IDENTIFIER;
	// 查看医生个人资料
	public static final int DOCTOR_PERSONINFO_SEARCH = ++INIT_POST_IDENTIFIER;

	public static final int NETWORKINTERFACETEST = ++INIT_POST_IDENTIFIER;

	public static final int SERVICEQUERY = ++INIT_POST_IDENTIFIER;

	// 修改昵称信息
	public static final int NICK_NAME = ++INIT_POST_IDENTIFIER;
	// 医生预约时间设置
	// 支付宝获取订单号
	// 支付宝获取订单号
	public static final int ZFB = ++INIT_POST_IDENTIFIER;
	// 支付第二步(支付宝)
	public static final int CREADORDERNO = ++INIT_POST_IDENTIFIER;
	// 支付第二步(微信)
	public static final int CREADWXORDERNO = ++INIT_POST_IDENTIFIER;
	// 支付第三步 回调
	public static final int PAYCALLBACK = ++INIT_POST_IDENTIFIER;
	// 微信回调
	public static final int PAYWXBACK = ++INIT_POST_IDENTIFIER;
	// 医生预约时间设置
	public static final int SETTIME = ++INIT_POST_IDENTIFIER;
	// 医生预约时间查询
	public static final int QUERYTIME = ++INIT_POST_IDENTIFIER;
	// 上传个人资料
	public static final int UPLOADDATA = ++INIT_POST_IDENTIFIER;

	/**
	 * 医生服务详细查询
	 */
	public static final int SERVERDETAILHISTORY = ++INIT_POST_IDENTIFIER;
	/**
	 * 医生服务设置
	 */
	public static final int CANCELORFINSHSERVER = ++INIT_POST_IDENTIFIER;

	// 咨询或文章详情查询
	public static final int ARTICALS = ++INIT_POST_IDENTIFIER;
	// 上传药物信息
	public static final int YAOWU = ++INIT_POST_IDENTIFIER;
	// 医生端 我的消息
	public static final int DOCMESSAGE = ++INIT_POST_IDENTIFIER;
	// 修改密码
	public static final int UPDATEPSW = ++INIT_POST_IDENTIFIER;
	// 确诊时间
	public static final int CONFIRMTIME = ++INIT_POST_IDENTIFIER;
	// 上传体检报告
	public static final int SAVEPHYSICREPORT = ++INIT_POST_IDENTIFIER;

	/**
	 * 查看聊天详情
	 */
	public static final int SEARCHIMAGETEXTDETAIL = ++INIT_POST_IDENTIFIER;

	/**
	 * 发送聊天消息
	 */
	public static final int SENDMESSAGE = ++INIT_POST_IDENTIFIER;
	public static final int SAVEPHYSICREPORTSS = ++INIT_POST_IDENTIFIER;
	// 登出
	public static final int OUT = ++INIT_POST_IDENTIFIER;

	public static final int HISTORY_MEDICAL = ++INIT_POST_IDENTIFIER;

	// 添加病情描述
	public static final int DESCRIPE = ++INIT_POST_IDENTIFIER;
	public static final int USERINFORMATION = ++INIT_POST_IDENTIFIER;
	public static final int USEMEAL = ++INIT_POST_IDENTIFIER;
	public static final int PHONESYSTEMPARMER = ++INIT_POST_IDENTIFIER;
	public static final int USEREDIT = ++INIT_POST_IDENTIFIER;
	public static final int ALIPAYSEARCH = ++INIT_POST_IDENTIFIER;

	/**
	 * 医生服务价格查询
	 */
	public static final int FINDEXPERTSERVICE = ++INIT_POST_IDENTIFIER;
	/**
	 * 医生服务价格修改
	 */
	public static final int ADJUSTPRICE = ++INIT_POST_IDENTIFIER;

	/**
	 * Action 类
	 */
	public static final class action {
		public static int INTENT_ACTION = 11111111;
		public static final String INTENT_ACTION_MESSAGE_RECEIVED = String
				.valueOf(++INTENT_ACTION);
	}

	/**
	 * 电话预约回拨电话
	 */
	public static final int CALLBACKPHONE = ++INIT_POST_IDENTIFIER;
	
	public static final int GETAPPVERSION = ++INIT_POST_IDENTIFIER;

}
