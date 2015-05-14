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

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.stlz.quartz.bean.MailBean;
import com.stlz.quartz.service.MailService;

public class SendEmailJob extends QuartzJobBean {

	private static Log logger = LogFactory.getLog(SendEmailJob.class);

	private MailBean mailBean;
	private MailService mailService;

	protected void executeInternal(JobExecutionContext arg0)
			throws JobExecutionException {
		logger.info("Job: 邮件定时发送任务就绪......");
		mailService.sendEmail(mailBean);

	}

	public void setMailBean(MailBean mailBean) {
		this.mailBean = mailBean;
	}

	public void setMailService(MailService mailService) {
		this.mailService = mailService;
	}

}
