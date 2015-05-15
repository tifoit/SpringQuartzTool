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
			// ע�������boolean,�������ʱ�����Ƕ��ͼƬ���ڹ���MimeMessageHelperʱ����������ֵ��true��ʾ���ã�
			// multipartģʽ Ϊtrueʱ���͸��� ��������html��ʽ
			this.mimeMessageHelper = new MimeMessageHelper(this.mailMessage,
					true, "utf-8");

			mimeMessageHelper.setFrom(mail.getFrom());
			mimeMessageHelper.setTo(mail.getAddress());
			mimeMessageHelper.setCc(mail.getMailArray());
			mimeMessageHelper.setSubject(mail.getSubject());
			// true ��ʾ����HTML��ʽ���ʼ�
			mimeMessageHelper.setText(mail.getText(), true);

			FileSystemResource file = new FileSystemResource(new File(
					mail.getAttachFile()));
			mimeMessageHelper.addAttachment(mail.getAttachName(), file);

			logger.info("*****************" + format.format(new Date())
					+ "��ʼ�����ʼ�***************");
			senderImpl.send(mailMessage);
			logger.info("*****************" + format.format(new Date())
					+ "�ʼ��������***************");

		} catch (MailException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}

	}

}
