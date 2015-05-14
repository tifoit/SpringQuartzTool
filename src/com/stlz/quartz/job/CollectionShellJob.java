package com.stlz.quartz.job;

/**
 * @Title: CollectionShellJob.java
 * @Package: com.stlz.quartz.job
 * @Desc: Collection Shell Job
 * @Copyright: 
 * @author: liuzhuang
 * @date: 2013/04/25
 * @Email: liuzhuang@umpay.com
 */

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.stlz.quartz.bean.ShellBean;
import com.stlz.quartz.service.AutoShellService;
import com.stlz.quartz.service.impl.CollectionShellServiceImpl;

public class CollectionShellJob extends QuartzJobBean {

	private static Log logger = LogFactory.getLog(CollectionShellJob.class);

	private AutoShellService autoss;
	private ShellBean shellBean;

	public CollectionShellJob() {
		autoss = new CollectionShellServiceImpl();
	}

	protected void executeInternal(JobExecutionContext arg0)
			throws JobExecutionException {
		logger.info("Job: Shell脚本定时执行任务就绪......");

		try {
			autoss.execute(shellBean);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void setShellBean(ShellBean shellBean) {
		this.shellBean = shellBean;
	}
}
