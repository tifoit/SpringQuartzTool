package com.stlz.quartz.service.impl;

/**
 * @Title: CllectionShellServiceImpl.java
 * @Package: com.stlz.quartz.service.impl
 * @Desc: execute collection Shell script
 * @Copyright:
 * @author: liuzhuang
 * @date: 2013/04/25
 * @Email: liuzhuang@umpay.com
 */

import java.io.IOException;

import org.apache.log4j.Logger;

import com.stlz.quartz.service.AutoShellService;

public class CollectionShellServiceImpl extends AutoShellService {

	private static Logger logger = Logger
			.getLogger(CollectionShellServiceImpl.class.getName());

	public CollectionShellServiceImpl(AutoShellService ass) {
		super();
		this.ass = ass;
	}

	AutoShellService ass;
	String shellCommand = "/home/cmccpay/tool/daily.sh";

	public void executeShell() {
		try {
			logger.info("Job1 : {�ռ���������Ѳ������Ϣ}��shell�ű���ʼִ��...");
			logger.info("ShellCommand : " + shellCommand);
			ass.execute(shellCommand);
			logger.info("Job1 : ���� {�ռ���������Ѳ������Ϣ}��shell�ű�ִ�н���.");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
