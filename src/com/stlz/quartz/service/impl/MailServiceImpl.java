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

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import com.stlz.quartz.bean.MailBean;
import com.stlz.quartz.service.MailService;

public class MailServiceImpl implements MailService {

	private static Log logger = LogFactory.getLog(MailServiceImpl.class);
	private SimpleDateFormat format = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");

	private JavaMailSenderImpl senderImpl;

	private MimeMessage mailMessage;
	private MimeMessageHelper mimeMessageHelper;

	public MailServiceImpl() {
	}

	public void setSenderImpl(JavaMailSenderImpl senderImpl) {
		this.senderImpl = senderImpl;
	}

	@Override
	public void sendEmail(MailBean mail) {

		try {
			this.mailMessage = this.senderImpl.createMimeMessage();
			// 注意这里的boolean,等于真的时候才能嵌套图片，在构建MimeMessageHelper时候，所给定的值是true表示启用，
			// multipart模式 为true时发送附件 可以设置html格式
			this.mimeMessageHelper = new MimeMessageHelper(this.mailMessage,
					true, "utf-8");

			mimeMessageHelper.setFrom(mail.getFrom());
			mimeMessageHelper.setTo(mail.getAddress());
			mimeMessageHelper.setCc(mail.getMailArray());
			mimeMessageHelper.setSubject(mail.getSubject());
			// true 表示启动HTML格式的邮件
			mimeMessageHelper.setText(mail.getText(), true);

			FileSystemResource file = new FileSystemResource(new File(
					mail.getAttachFile()));
			mimeMessageHelper.addAttachment(mail.getAttachName(), file);

			logger.info("*****************" + format.format(new Date())
					+ "开始发送邮件***************");
			senderImpl.send(mailMessage);
			logger.info("*****************" + format.format(new Date())
					+ "邮件发送完成***************");

		} catch (MailException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}

	}

}
