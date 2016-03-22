package com.zanbeicontroller.net;

import java.util.HashMap;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import com.zanbei.R;
import com.zanbei.config.Command;
import com.zanbei.date.JsonVoParser;
import com.zanbei.vo.BaseVo;



import android.os.Message;
/**
 * <pre>
 * 业务名:
 * 功能说明: 
 * 编写日期:	2015年5月11日
 * 作者:	zgz
 * 
 * 历史记录
 * 1、修改日期：
 *    修改人：
 *    修改内容：
 * </pre>
 */  
public class Operation {
	private static final String SUCCESS = "1";
	@SuppressWarnings("unchecked")
	public Message executeGeneral(Command cmd) {
		HashMap<String, String> hashMap = (HashMap<String, String>) cmd.param;
		String  jsonvo=CallServer.getInstance().callServer(cmd.method,hashMap, cmd.context);
		Message msg = Message.obtain();
		msg.what = cmd.commandID;
		BaseVo vo = JsonVoParser.getInstance().getBasevo(jsonvo);

		if((null != jsonvo) && !"".equals(jsonvo) && vo != null){
			if(SUCCESS.equals(vo.getSucc())){
				cmd.message=vo.getMes();
				cmd.success=true;
			}else{
				cmd.message=vo.getMes();
				//	        	cmd.stateCode=vo.getCode();
				cmd.success=false;
			}
		}else{
			cmd.message=cmd.context.getString(R.string.network_is_futility);
			cmd.success=false;
			cmd.stateCode="100001";
		}
		msg.obj = cmd;
		return msg;
	}
	/**
	 * 登录
	 * 
	 * @param cmd
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Message executeLogin(Command cmd) {
		HashMap<String, String> hashMap = (HashMap<String, String>) cmd.param;
		String jsonString = CallServer.getInstance().callServer(cmd.method,
				hashMap, cmd.context);
		Message msg = Message.obtain();
		msg.what = cmd.commandID;
//		UserLoginBodyVo vo = JsonVoParser.getInstance().getUserLoginBodyVo(jsonString);

		BaseVo baseVo = JsonVoParser.getInstance().getBasevo(jsonString);
		if ((null != jsonString) && !"".equals(jsonString) && baseVo != null) {
			if (baseVo.getSucc()) {
				cmd.success = true;
				cmd.resData = baseVo;
			} else {
				cmd.message = baseVo.getMes();
				cmd.success = false;
			}
		} else {
			if (baseVo != null) {
				cmd.message = baseVo.getMes();
				cmd.success = false;
			} else {
				cmd.success = false;
				cmd.message = cmd.context
						.getString(R.string.the_network_is_dead);
			}
		}
		msg.obj = cmd;
		return msg;
	}

//	/**
//	 *
//	 * 首页数据加载
//	 * @param cmd
//	 * @return
//	 */
//	@SuppressWarnings("unchecked")
//	public Message executeHomeData(Command cmd) {
//		HashMap<String, String> hashMap = (HashMap<String, String>) cmd.param;
//		String jsonString = CallServer.getInstance().callServerldGet(cmd.method,
//				hashMap, cmd.context);
//		Message msg = Message.obtain();
//		msg.what = cmd.commandID;
//		HomePageBodyVo vo = JsonVoParser.getInstance().gethoHomePageBodyVo(jsonString);
//		BaseVo baseVo = JsonVoParser.getInstance().getBasevo(jsonString);
//		if ((null != jsonString) && !"".equals(jsonString) && baseVo != null) {
//			if (baseVo.getSuccess()) {
//				cmd.success = true;
//				cmd.resData = vo;
//			} else {
//				cmd.message = baseVo.getMessage();
//				cmd.success = false;
//			}
//		} else {
//			if (baseVo != null) {
//				cmd.message = baseVo.getMessage();
//				cmd.success = false;
//			} else {
//				cmd.success = false;
//				cmd.message = cmd.context
//						.getString(R.string.the_network_is_dead);
//			}
//		}
//		msg.obj = cmd;
//		return msg;
//
//	}
//	/**
//	 *
//	 * 助学宝页数据加载
//	 * @param cmd
//	 * @return
//	 */
//	@SuppressWarnings("unchecked")
//	public Message executeZXBData(Command cmd) {
//		HashMap<String, String> hashMap = (HashMap<String, String>) cmd.param;
//		String jsonString = CallServer.getInstance().callServerldGet(cmd.method,
//				hashMap, cmd.context);
//		Message msg = Message.obtain();
//		msg.what = cmd.commandID;
//		ZxbEntityVo zxbEntityVo = JsonVoParser.getInstance().getzxbEntityVo(jsonString);
//		BaseVo baseVo = JsonVoParser.getInstance().getBasevo(jsonString);
//		if ((null != jsonString) && !"".equals(jsonString) && baseVo != null) {
//			if (baseVo.getSuccess()) {
//				cmd.success = true;
//				cmd.resData = zxbEntityVo;
//			} else {
//				cmd.message = baseVo.getMessage();
//				cmd.success = false;
//			}
//		} else {
//			if (baseVo != null) {
//				cmd.message = baseVo.getMessage();
//				cmd.success = false;
//			} else {
//				cmd.success = false;
//				cmd.message = cmd.context
//						.getString(R.string.the_network_is_dead);
//			}
//		}
//		msg.obj = cmd;
//		return msg;
//
//	}
//	/**
//	 *
//	 * 助学宝页item数据加载
//	 * @param cmd
//	 * @return
//	 */
//	@SuppressWarnings("unchecked")
//	public Message executeZxbItemData(Command cmd) {
//		HashMap<String, String> hashMap = (HashMap<String, String>) cmd.param;
//		String jsonString = CallServer.getInstance().callServerldGet(cmd.method,
//				hashMap, cmd.context);
//		Message msg = Message.obtain();
//		msg.what = cmd.commandID;
//		ZxbItemEntityVo zxbItemEntityVo = JsonVoParser.getInstance().getzxbItemEntityVo(jsonString);
//		BaseVo baseVo = JsonVoParser.getInstance().getBasevo(jsonString);
//		if ((null != jsonString) && !"".equals(jsonString) && baseVo != null) {
//			if (baseVo.getSuccess()) {
//				cmd.success = true;
//				cmd.resData = zxbItemEntityVo;
//			} else {
//				cmd.message = baseVo.getMessage();
//				cmd.success = false;
//			}
//		} else {
//			if (baseVo != null) {
//				cmd.message = baseVo.getMessage();
//				cmd.success = false;
//			} else {
//				cmd.success = false;
//				cmd.message = cmd.context
//						.getString(R.string.the_network_is_dead);
//			}
//		}
//		msg.obj = cmd;
//		return msg;
//
//	}
//	/**
//	 *
//	 * 获取摇一摇额度
//	 * @param cmd
//	 * @return
//	 */
//	@SuppressWarnings("unchecked")
//	public Message executeShakeLimit(Command cmd) {
//		HashMap<String, String> hashMap = (HashMap<String, String>) cmd.param;
//		String jsonString = CallServer.getInstance().callServerldGet(cmd.method,
//				hashMap, cmd.context);
//		Message msg = Message.obtain();
//		msg.what = cmd.commandID;
//		ShakeLimitEntityVo shakeLimitEntityVo = JsonVoParser.getInstance().getShakeLimitEntityVo(jsonString);
//		//		ZxbItemEntityVo zxbItemEntityVo = JsonVoParser.getInstance().getzxbItemEntityVo(jsonString);
//		BaseVo baseVo = JsonVoParser.getInstance().getBasevo(jsonString);
//		if ((null != jsonString) && !"".equals(jsonString) && baseVo != null) {
//			if (baseVo.getSuccess()) {
//				cmd.success = true;
//				cmd.resData = shakeLimitEntityVo;
//			} else {
//				cmd.message = baseVo.getMessage();
//				cmd.success = false;
//			}
//		} else {
//			if (baseVo != null) {
//				cmd.message = baseVo.getMessage();
//				cmd.success = false;
//			} else {
//				cmd.success = false;
//				cmd.message = cmd.context
//						.getString(R.string.the_network_is_dead);
//			}
//		}
//		msg.obj = cmd;
//		return msg;
//
//	}
//	/**
//	 *
//	 * 首页考证分类信息
//	 * @param cmd
//	 * @return
//	 */
//	@SuppressWarnings("unchecked")
//	public Message executeClassyExam(Command cmd) {
//		HashMap<String, String> hashMap = (HashMap<String, String>) cmd.param;
//		String jsonString = CallServer.getInstance().callServer(cmd.method,
//				hashMap, cmd.context);
//		Message msg = Message.obtain();
//		msg.what = cmd.commandID;
//		HomePageBottomEntityVo homePageBottomEntityVo = JsonVoParser.getInstance().getHomePageBottomEntityVo(jsonString);
//		BaseVo baseVo = JsonVoParser.getInstance().getBasevo(jsonString);
//		if ((null != jsonString) && !"".equals(jsonString) && baseVo != null) {
//			if (baseVo.getSuccess()) {
//				cmd.success = true;
//				cmd.resData = homePageBottomEntityVo;
//			} else {
//				cmd.message = baseVo.getMessage();
//				cmd.success = false;
//			}
//		} else {
//			if (baseVo != null) {
//				cmd.message = baseVo.getMessage();
//				cmd.success = false;
//			} else {
//				cmd.success = false;
//				cmd.message = cmd.context
//						.getString(R.string.the_network_is_dead);
//			}
//		}
//		msg.obj = cmd;
//		return msg;
//
//	}
//	/**
//	 *
//	 * WebUrl
//	 * @param cmd
//	 * @return
//	 */
//	@SuppressWarnings("unchecked")
//	public Message executeGetWebUrl(Command cmd) {
//		HashMap<String, String> hashMap = (HashMap<String, String>) cmd.param;
//		String jsonString = CallServer.getInstance().callServerldGet(cmd.method,
//				hashMap, cmd.context);
//		Message msg = Message.obtain();
//		msg.what = cmd.commandID;
//		ExamPageEntityVo expEntityVo = JsonVoParser.getInstance().getExamPageEntityVo(jsonString);
//		BaseVo baseVo = JsonVoParser.getInstance().getBasevo(jsonString);
//		if ((null != jsonString) && !"".equals(jsonString) && baseVo != null) {
//			if (baseVo.getSuccess()) {
//				cmd.success = true;
//				cmd.resData = expEntityVo;
//			} else {
//				cmd.message = baseVo.getMessage();
//				cmd.success = false;
//			}
//		} else {
//			if (baseVo != null) {
//				cmd.message = baseVo.getMessage();
//				cmd.success = false;
//			} else {
//				cmd.success = false;
//				cmd.message = cmd.context
//						.getString(R.string.the_network_is_dead);
//			}
//		}
//		msg.obj = cmd;
//		return msg;
//
//	}
//
//	/**
//	 * 获取手机验证码
//	 * 
//	 * @param cmd
//	 * @return
//	 */
//	@SuppressWarnings("unchecked")
//	public Message executeGetPhoneVerifycode(Command cmd) {
//		HashMap<String, String> hashMap = (HashMap<String, String>) cmd.param;
//		String jsonString = CallServer.getInstance().callServer(cmd.method,
//				hashMap, cmd.context);
//		Message msg = Message.obtain();
//		msg.what = cmd.commandID;
//		BaseVo baseVo = JsonVoParser.getInstance().getBasevo(jsonString);
//		if ((null != jsonString) && !"".equals(jsonString) && baseVo != null) {
//			if (baseVo.getSuccess()) {
//				cmd.success = true;
//				cmd.message = baseVo;
//			} else {
//				cmd.message = baseVo.getMessage();
//				cmd.success = false;
//			}
//		} else {
//			if (baseVo != null) {
//				cmd.message = baseVo.getMessage();
//				cmd.success = false;
//			} else {
//				cmd.success = false;
//				cmd.stateCode = "100001";
//				cmd.message = cmd.context
//						.getString(R.string.the_network_is_dead);
//			}
//		}
//		msg.obj = cmd;
//		return msg;
//
//	}
//	/**
//	 * 用户注册
//	 * 
//	 * @param cmd
//	 * @return
//	 */
//	@SuppressWarnings("unchecked")
//	public Message executeRegist(Command cmd) {
//		HashMap<String, String> hashMap = (HashMap<String, String>) cmd.param;
//		String jsonString = CallServer.getInstance().callServer(cmd.method,
//				hashMap, cmd.context);
//		Message msg = Message.obtain();
//		msg.what = cmd.commandID;
//		BaseVo baseVo = JsonVoParser.getInstance().getBasevo(jsonString);
//		if ((null != jsonString) && !"".equals(jsonString) && baseVo != null) {
//			if (baseVo.getSuccess()) {
//				cmd.success = true;
//				cmd.message = baseVo;
//			} else {
//				cmd.message = baseVo.getMessage();
//				cmd.success = false;
//			}
//		} else {
//			if (baseVo != null) {
//				cmd.message = baseVo.getMessage();
//				cmd.success = false;
//			} else {
//				cmd.success = false;
//				cmd.stateCode = "100001";
//				cmd.message = cmd.context
//						.getString(R.string.the_network_is_dead);
//			}
//		}
//		msg.obj = cmd;
//		return msg;
//		
//	}
//
//	/**
//	 * 忘记密码
//	 * 
//	 * @param cmd
//	 * @return
//	 */
//	@SuppressWarnings("unchecked")
//	public Message executeForgetPwd(Command cmd) {
//		HashMap<String, String> hashMap = (HashMap<String, String>) cmd.param;
//		String jsonString = CallServer.getInstance().callServer(cmd.method,
//				hashMap, cmd.context);
//		Message msg = Message.obtain();
//		msg.what = cmd.commandID;
//		BaseVo baseVo = JsonVoParser.getInstance().getBasevo(jsonString);
//		if ((null != jsonString) && !"".equals(jsonString) && baseVo != null) {
//			if (baseVo.getSuccess()) {
//				cmd.success = true;
//				cmd.message = baseVo;
//			} else {
//				cmd.message = baseVo.getMessage();
//				cmd.success = false;
//			}
//		} else {
//			if (baseVo != null) {
//				cmd.message = baseVo.getMessage();
//				cmd.success = false;
//			} else {
//				cmd.success = false;
//				cmd.message = cmd.context
//						.getString(R.string.the_network_is_dead);
//			}
//		}
//		msg.obj = cmd;
//		return msg;
//
//	}
//
//	/**
//	 * 获取所有课程
//	 * 
//	 * @param cmd
//	 * @return
//	 */
//	@SuppressWarnings("unchecked")
//	public Message executeGetAllCourse(Command cmd) {
//		HashMap<String, String> hashMap = (HashMap<String, String>) cmd.param;
//		String jsonString = CallServer.getInstance().callServer(cmd.method,
//				hashMap, cmd.context);
//		Message msg = Message.obtain();
//		msg.what = cmd.commandID;
//		BaseVo baseVo = JsonVoParser.getInstance().getBasevo(jsonString);
//		if ((null != jsonString) && !"".equals(jsonString) && baseVo != null) {
//			if (baseVo.getSuccess()) {
//				cmd.success = true;
//				cmd.resData = baseVo;
//			} else {
//				cmd.message = baseVo.getMessage();
//				cmd.success = false;
//			}
//		} else {
//			if (baseVo != null) {
//				cmd.message = baseVo.getMessage();
//				cmd.success = false;
//			} else {
//				cmd.success = false;
//				cmd.message = cmd.context
//						.getString(R.string.the_network_is_dead);
//			}
//		}
//		msg.obj = cmd;
//		return msg;
//
//	}
//	/**
//	 * 获取试听课程
//	 * 
//	 * @param cmd
//	 * @return
//	 */
//	@SuppressWarnings("unchecked")
//	public Message executeGetAuditionCourse(Command cmd) {
//		HashMap<String, String> hashMap = (HashMap<String, String>) cmd.param;
//		String jsonString = CallServer.getInstance().callServer(cmd.method,
//				hashMap, cmd.context);
//		Message msg = Message.obtain();
//		msg.what = cmd.commandID;
//		CourseEntityVo courseEntityVo = JsonVoParser.getInstance().getCourseEntityVo(jsonString);
//		BaseVo baseVo = JsonVoParser.getInstance().getBasevo(jsonString);
//		if ((null != jsonString) && !"".equals(jsonString) && baseVo != null) {
//			if (baseVo.getSuccess()) {
//				cmd.success = true;
//				cmd.resData = courseEntityVo;
//			} else {
//				cmd.message = baseVo.getMessage();
//				cmd.success = false;
//			}
//		} else {
//			if (baseVo != null) {
//				cmd.message = baseVo.getMessage();
//				cmd.success = false;
//			} else {
//				cmd.success = false;
//				cmd.message = cmd.context
//						.getString(R.string.the_network_is_dead);
//			}
//		}
//		msg.obj = cmd;
//		return msg;
//
//	}
//
//	/**
//	 * 获取已购买课程
//	 * 
//	 * @param cmd
//	 * @return
//	 */
//	@SuppressWarnings("unchecked")
//	public Message executeGetPurchaseCourse(Command cmd) {
//		HashMap<String, String> hashMap = (HashMap<String, String>) cmd.param;
//		String jsonString = CallServer.getInstance().callServer(cmd.method,
//				hashMap, cmd.context);
//		Message msg = Message.obtain();
//		msg.what = cmd.commandID;
//		MyPurchaseCourseEntityVo purchaseCourseEntityVo = JsonVoParser.getInstance().getMyPurchaseCourseEntityVo(jsonString);
//		BaseVo baseVo = JsonVoParser.getInstance().getBasevo(jsonString);
//		if ((null != jsonString) && !"".equals(jsonString) && baseVo != null) {
//			if (baseVo.getSuccess()) {
//				cmd.success = true;
//				cmd.resData = purchaseCourseEntityVo;
//			} else {
//				cmd.message = baseVo.getMessage();
//				cmd.success = false;
//			}
//		} else {
//			if (baseVo != null) {
//				cmd.message = baseVo.getMessage();
//				cmd.success = false;
//			} else {
//				cmd.success = false;
//				cmd.message = cmd.context
//						.getString(R.string.the_network_is_dead);
//			}
//		}
//		msg.obj = cmd;
//		return msg;
//
//	}
//	/**
//	 * 获取收藏课程
//	 * 
//	 * @param cmd
//	 * @return
//	 */
//	@SuppressWarnings("unchecked")
//	public Message executeGetCollectCourse(Command cmd) {
//		HashMap<String, String> hashMap = (HashMap<String, String>) cmd.param;
//		String jsonString = CallServer.getInstance().callServer(cmd.method,
//				hashMap, cmd.context);
//		Message msg = Message.obtain();
//		msg.what = cmd.commandID;
//		CollectCourseEntityVo collectCourseEntityVo = JsonVoParser.getInstance().getCollectCourseEntityVo(jsonString);
//		BaseVo baseVo = JsonVoParser.getInstance().getBasevo(jsonString);
//		if ((null != jsonString) && !"".equals(jsonString) && baseVo != null) {
//			if (baseVo.getSuccess()) {
//				cmd.success = true;
//				cmd.resData = collectCourseEntityVo;
//			} else {
//				cmd.message = baseVo.getMessage();
//				cmd.success = false;
//			}
//		} else {
//			if (baseVo != null) {
//				cmd.message = baseVo.getMessage();
//				cmd.success = false;
//			} else {
//				cmd.success = false;
//				cmd.message = cmd.context
//						.getString(R.string.the_network_is_dead);
//			}
//		}
//		msg.obj = cmd;
//		return msg;
//
//	}
//	/**
//	 * 收藏课程
//	 * 
//	 * @param cmd
//	 * @return
//	 */
//	@SuppressWarnings("unchecked")
//	public Message executeRequestCollectCourse(Command cmd) {
//		HashMap<String, String> hashMap = (HashMap<String, String>) cmd.param;
//		String jsonString = CallServer.getInstance().callServer(cmd.method,
//				hashMap, cmd.context);
//		Message msg = Message.obtain();
//		msg.what = cmd.commandID;
//		BaseVo baseVo = JsonVoParser.getInstance().getBasevo(jsonString);
//		if ((null != jsonString) && !"".equals(jsonString) && baseVo != null) {
//			if (baseVo.getSuccess()) {
//				cmd.success = true;
//				cmd.resData = baseVo;
//			} else {
//				cmd.message = baseVo.getMessage();
//				cmd.success = false;
//			}
//		} else {
//			if (baseVo != null) {
//				cmd.message = baseVo.getMessage();
//				cmd.success = false;
//			} else {
//				cmd.success = false;
//				cmd.message = cmd.context
//						.getString(R.string.the_network_is_dead);
//			}
//		}
//		msg.obj = cmd;
//		return msg;
//
//	}
//	/**
//	 * 删除收藏item
//	 * 
//	 * @param cmd
//	 * @return
//	 */
//	@SuppressWarnings("unchecked")
//	public Message executeDelFavCourse(Command cmd) {
//		HashMap<String, String> hashMap = (HashMap<String, String>) cmd.param;
//		String jsonString = CallServer.getInstance().callServer(cmd.method,
//				hashMap, cmd.context);
//		Message msg = Message.obtain();
//		msg.what = cmd.commandID;
//		BaseVo baseVo = JsonVoParser.getInstance().getBasevo(jsonString);
//		if ((null != jsonString) && !"".equals(jsonString) && baseVo != null) {
//			if (baseVo.getSuccess()) {
//				cmd.success = true;
//				cmd.resData = baseVo;
//			} else {
//				cmd.message = baseVo.getMessage();
//				cmd.success = false;
//			}
//		} else {
//			if (baseVo != null) {
//				cmd.message = baseVo.getMessage();
//				cmd.success = false;
//			} else {
//				cmd.success = false;
//				cmd.message = cmd.context
//						.getString(R.string.the_network_is_dead);
//			}
//		}
//		msg.obj = cmd;
//		return msg;
//
//	}
//	/**
//	 * 获取课程详情
//	 * 
//	 * @param cmd
//	 * @return
//	 */
//	@SuppressWarnings("unchecked")
//	public Message executeGetParticularCourse(Command cmd) {
//		HashMap<String, String> hashMap = (HashMap<String, String>) cmd.param;
//		String jsonString = CallServer.getInstance().callServer(cmd.method,
//				hashMap, cmd.context);
//		Message msg = Message.obtain();
//		msg.what = cmd.commandID;
//		ParticularCourseEntityVo  particularCourseEntityVo = JsonVoParser.getInstance().getParticularCourseEntityvo(jsonString);
//		BaseVo baseVo = JsonVoParser.getInstance().getBasevo(jsonString);
//		if ((null != jsonString) && !"".equals(jsonString) && baseVo != null) {
//			if (baseVo.getSuccess()) {
//				cmd.success = true;
//				cmd.resData = particularCourseEntityVo;
//			} else {
//				cmd.message = baseVo.getMessage();
//				cmd.success = false;
//			}
//		} else {
//			if (baseVo != null) {
//				cmd.message = baseVo.getMessage();
//				cmd.success = false;
//			} else {
//				cmd.success = false;
//				cmd.message = cmd.context
//						.getString(R.string.the_network_is_dead);
//			}
//		}
//		msg.obj = cmd;
//		return msg;
//
//	}
//	/**
//	 * 获取课程讨论
//	 * 
//	 * @param cmd
//	 * @return
//	 */
//	@SuppressWarnings("unchecked")
//	public Message executeGetDiscussCourse(Command cmd) {
//		HashMap<String, String> hashMap = (HashMap<String, String>) cmd.param;
//		String jsonString = CallServer.getInstance().callServer(cmd.method,
//				hashMap, cmd.context);
//		Message msg = Message.obtain();
//		msg.what = cmd.commandID;
//		DiscussCourseEntityVo discussCourseEntityVo = JsonVoParser.getInstance().getDiscussCourseEntityVo(jsonString);
//		BaseVo baseVo = JsonVoParser.getInstance().getBasevo(jsonString);
//		if ((null != jsonString) && !"".equals(jsonString) && baseVo != null) {
//			if (baseVo.getSuccess()) {
//				cmd.success = true;
//				cmd.resData = discussCourseEntityVo;
//			} else {
//				cmd.message = baseVo.getMessage();
//				cmd.success = false;
//			}
//		} else {
//			if (baseVo != null) {
//				cmd.message = baseVo.getMessage();
//				cmd.success = false;
//			} else {
//				cmd.success = false;
//				cmd.message = cmd.context
//						.getString(R.string.the_network_is_dead);
//			}
//		}
//		msg.obj = cmd;
//		return msg;
//
//	}
//	/**
//	 * 发表课程讨论
//	 * 
//	 * @param cmd
//	 * @return
//	 */
//	@SuppressWarnings("unchecked")
//	public Message executeSendDiscussCourse(Command cmd) {
//		HashMap<String, String> hashMap = (HashMap<String, String>) cmd.param;
//		String jsonString = CallServer.getInstance().callServer(cmd.method,
//				hashMap, cmd.context);
//		Message msg = Message.obtain();
//		msg.what = cmd.commandID;
//		//		DiscussCourseEntityVo discussCourseEntityVo = JsonVoParser.getInstance().getDiscussCourseEntityVo(jsonString);
//		BaseVo baseVo = JsonVoParser.getInstance().getBasevo(jsonString);
//		if ((null != jsonString) && !"".equals(jsonString) && baseVo != null) {
//			if (baseVo.getSuccess()) {
//				cmd.success = true;
//				cmd.resData = baseVo;
//			} else {
//				cmd.message = baseVo.getMessage();
//				cmd.success = false;
//			}
//		} else {
//			if (baseVo != null) {
//				cmd.message = baseVo.getMessage();
//				cmd.success = false;
//			} else {
//				cmd.success = false;
//				cmd.message = cmd.context
//						.getString(R.string.the_network_is_dead);
//			}
//		}
//		msg.obj = cmd;
//		return msg;
//
//	}
}
