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

import com.stlz.quartz.bean.ShellBean;
import com.stlz.quartz.service.AutoShellService;
import com.stlz.quartz.util.JavaShellUtil;

public class CollectionShellServiceImpl implements AutoShellService {

	private static Logger logger = Logger
			.getLogger(CollectionShellServiceImpl.class.getName());

	private JavaShellUtil jsu;

	public CollectionShellServiceImpl() {
		jsu = new JavaShellUtil();
	}

	public void execute(ShellBean shellbean) throws IOException {
		//shell command result
		int success = 0;
		try {
			logger.info("Job : {" + shellbean.getDescription()
					+ "}��Shell�ű���ʼִ��...");
			logger.info("ShellCommand : " + shellbean.getScript());
			jsu.executeShell(shellbean.getScript());
			if (success == 1)
				logger.info("Job : {" + shellbean.getDescription()
						+ "}��Shell�ű�ִ�н���, ִ�гɹ�.");
			else
				logger.info("Job : {" + shellbean.getDescription()
						+ "}��Shell�ű�ִ�н���, ִ��ʧ��.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
