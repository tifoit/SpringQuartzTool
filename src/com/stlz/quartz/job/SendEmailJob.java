package com.stlz.quartz.job;
/**
 * @Title: SendEmailJob.java
 * @Package: com.stlz.quartz.job
 * @Desc: Send Email Job
 * @Copyright: 
 * @author: liuzhuang
 * @date: 2013/04/25
 * @Email: liuzhuang@umpay.com
 */

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.stlz.quartz.bean.MailBean;
import com.stlz.quartz.service.MailService;

public class SendEmailJob extends QuartzJobBean{
	private static Log logger = LogFactory.getLog(SendEmailJob.class);
	private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private MailBean mailBean;
	private MailService mailService;
	public void setMailBean(MailBean mailBean) {
		this.mailBean = mailBean;
	}
	public void setMailService(MailService mailService) {
		this.mailService = mailService;
	}
	protected void executeInternal(JobExecutionContext arg0)
			throws JobExecutionException {
		logger.info("*****************"+format.format(new Date())+"邮件准备就绪***************");
		mailService.sendEmail(mailBean);
	}
}
