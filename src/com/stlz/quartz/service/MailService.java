package com.stlz.quartz.service;

/**
 * @Title: MailService.java
 * @Package: com.stlz.quartz.service
 * @Desc: Send Email Service inteface
 * @Copyright: 
 * @author: liuzhuang
 * @date: 2013/04/25
 * @Email: liuzhuang@umpay.com
 */

import com.stlz.quartz.bean.MailBean;

public interface MailService {
	void sendEmail(MailBean mail);
}
