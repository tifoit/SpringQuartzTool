package com.stlz.quartz.bean;

/**
 * @Title: MailBean.java
 * @Package: com.stlz.quartz.bean
 * @Desc: MailBean Setting
 * @Copyright:
 * @author: liuzhuang
 * @date: 2013/04/25
 * @Email: liuzhuang@umpay.com
 */

public class MailBean {

	private String from;
	private String address;
	private String[] mailArray;
	private String attachFile;
	private String attachName;
	private String subject;
	private String text;

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String[] getMailArray() {
		return mailArray;
	}

	public void setMailArray(String[] mailArray) {
		this.mailArray = mailArray;
	}

	public String getAttachFile() {
		return attachFile;
	}

	public void setAttachFile(String attachFile) {
		this.attachFile = attachFile;
	}

	public String getAttachName() {
		return attachName;
	}

	public void setAttachName(String attachName) {
		this.attachName = attachName;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
