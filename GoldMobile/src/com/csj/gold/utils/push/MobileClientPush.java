package com.csj.gold.utils.push;

import org.junit.Test;

import cn.jpush.api.JPushClient;
import cn.jpush.api.common.APIConnectionException;
import cn.jpush.api.common.APIRequestException;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Message;
import cn.jpush.api.push.model.Options;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.audience.AudienceTarget;
import cn.jpush.api.push.model.notification.IosNotification;
import cn.jpush.api.push.model.notification.Notification;
/**
 * 极光推送服务
 * 
 */
public class MobileClientPush {
	
	private static final String APPKEY="041b4aa41a454bdc7105e9c9";
	private static final String MASTERT_SECRET="fc8681e12f1df6d5cffbde0f";
	private static final boolean PRODUCT_MODE=false;//false:开发  ，true：生产
	
	/**
	 * 快捷地构建推送对象：所有平台，所有设备，内容为 ALERT 的通知。
	 * @return
	 */
	private static PushPayload buildPushObject_all_all_alert(String message) {
		return PushPayload.alertAll(message);
	}
	
	/**
	 * 构建推送对象：所有平台，推送目标是别名为 "alias1"，通知内容为 ALERT。
	 * @return
	 */
	private static PushPayload buildPushObject_all_alias_alert(String title,String message) {
		return PushPayload.newBuilder().setPlatform(Platform.all())
				.setAudience(Audience.alias(title))
				.setNotification(Notification.alert(message)).build();
	}
	/**
	 * 构建推送对象：平台是 Android，目标是 tag 为 "tag1" 的设备，内容是 Android 
	 * 通知 ALERT，并且标题为 TITLE。
	 * @return
	 */
	private static PushPayload buildPushObject_android_tag_alertWithTitle(String target,String title,String message) {
		return PushPayload.newBuilder().setPlatform(Platform.android())
				.setAudience(Audience.tag(target))
				.setNotification(Notification.android(title, message, null))
				.build();
	}
	/**
	 * 构建推送对象：平台是 iOS，推送目标是 "tag1", "tag_all" 的交集，
	 * 推送内容同时包括通知与消息 - 通知信息是 ALERT，角标数字为 5，通知声音为 "happy"，
	 * 并且附加字段 from = "JPush"；消息内容是 MSG_CONTENT。通知是 APNs 推送通道的，
	 * 消息是 JPush 应用内消息通道的。APNs 的推送环境是“生产”（如果不显式设置的话，Library 会默认指定为开发）
	 * @return
	 */
	private static PushPayload buildPushObject_ios_tagAnd_alertWithExtrasAndMessage(String target,String targetAll,String messageTitle,String message,String otherTitle,String otherMessage) {
		return PushPayload
				.newBuilder()
				.setPlatform(Platform.ios())
				.setAudience(Audience.tag_and(target, targetAll))
				.setNotification(
						Notification
								.newBuilder()
								.addPlatformNotification(
										IosNotification.newBuilder()
												.setAlert(messageTitle).setBadge(5)
												.setSound("happy.caf")
												.addExtra(otherTitle, otherMessage)
												.build()).build())
				.setMessage(Message.content(message))
				.setOptions(
						Options.newBuilder().setApnsProduction(PRODUCT_MODE).build())
				.build();
	}
	/**
	 * 构建推送对象：平台是 Andorid 与 iOS，推送目标是 （"tag1" 与 "tag2" 的并集）
	 * 且（"alias1" 与 "alias2" 的并集），推送内容是 - 内容为 MSG_CONTENT 的消息，
	 * 并且附加字段 from = JPush。
	 * @return
	 */
	private static PushPayload buildPushObject_ios_audienceMore_messageWithExtras() {
		return PushPayload
				.newBuilder()
				.setPlatform(Platform.android_ios())
				.setAudience(
						Audience.newBuilder()
								.addAudienceTarget(
										AudienceTarget.tag("tag1", "tag2"))
								.addAudienceTarget(
										AudienceTarget
												.alias("alias1", "alias2"))
								.build())
				.setMessage(
						Message.newBuilder().setMsgContent("MSG_CONTENT")
								.addExtra("from", "JPush").build())
								.setOptions(
						Options.newBuilder().setApnsProduction(PRODUCT_MODE).build())
						.build();
	}
	@Test
	public void push() {
		JPushClient jpushClient = new JPushClient(MASTERT_SECRET, APPKEY, 3);

		// For push, all you need do is to build PushPayload object.
		PushPayload payload = buildPushObject_all_all_alert("Test"); //Android And Ios Push
		

		try {
			PushResult result = jpushClient.sendPush(payload);
			System.out.println("Got result - " + result);
//			LOG.info("Got result - " + result);

		} catch (APIConnectionException e) {
			// Connection error, should retry later
			System.out.println("Connection error, should retry later"+e);
//			LOG.error("Connection error, should retry later", e);

		} catch (APIRequestException e) {
			// Should review the error, and fix the request
			System.out.println("Should review the error, and fix the request"+e);
			System.out.println("HTTP Status: " + e.getStatus());
			System.out.println("Error Code: " + e.getErrorCode());
			System.out.println("Error Message: " + e.getErrorMessage());
//			LOG.error("Should review the error, and fix the request", e);
//			LOG.info("HTTP Status: " + e.getStatus());
//			LOG.info("Error Code: " + e.getErrorCode());
//			LOG.info("Error Message: " + e.getErrorMessage());
		}
	}
}
