package cn.david.listview.domain;

import java.io.Serializable;

public class ChatMessage implements Serializable{
	private String userId;//��ID�ܹ�֪���û�ͼƬ���ڵ�λ��
	private String msgRecTime;
	private String msgContent;
	private boolean sendMsg;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getMsgRecTime() {
		return msgRecTime;
	}
	public void setMsgRecTime(String msgRecTime) {
		this.msgRecTime = msgRecTime;
	}
	public String getMsgContent() {
		return msgContent;
	}
	public void setMsgContent(String msgContent) {
		this.msgContent = msgContent;
	}
	public boolean isSendMsg() {
		return sendMsg;
	}
	public void setSendMsg(boolean sendMsg) {
		this.sendMsg = sendMsg;
	}
	
	
}
