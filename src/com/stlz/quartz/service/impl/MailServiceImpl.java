package com.stlz.quartz.service.impl;

/**
 * @Title: MailServiceImpl.java
 * @Package: com.stlz.quartz.service.impl
 * @Desc: Send Email Service implement
 * @Copyright: 
 * @author: liuzhuang
 * @date: 2013/04/25
 * @Email: liuzhuang@umpay.com
 */

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

import com.stlz.quartz.bean.MailBean;
import com.stlz.quartz.service.MailService;

public class MailServiceImpl implements MailService {

	private static Log logger = LogFactory.getLog(MailServiceImpl.class);

	private MailSender mailSender;
	private SimpleMailMessage mailMessage;
	private SimpleDateFormat format = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");

	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}

	public void setMailMessage(SimpleMailMessage mailMessage) {
		this.mailMessage = mailMessage;
	}

	@Override
	public void sendEmail(MailBean mail) {
		SimpleMailMessage message = new SimpleMailMessage(this.mailMessage);
		// message.setTo(mail.getMailArray());
		message.setTo(mail.getAddress());
		String text = message.getText();
		text = StringUtils.replace(text, "%DATE%", format.format(new Date()));
		message.setText(text);
		logger.info("*****************" + format.format(new Date())
				+ "开始发送邮件***************");
		mailSender.send(message);
	}

}
