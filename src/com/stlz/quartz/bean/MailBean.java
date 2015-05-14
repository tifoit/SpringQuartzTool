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

	private String address;
	private String[] mailArray;

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

}
