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
					+ "}的Shell脚本开始执行...");
			logger.info("ShellCommand : " + shellbean.getScript());
			jsu.executeShell(shellbean.getScript());
			if (success == 1)
				logger.info("Job : {" + shellbean.getDescription()
						+ "}的Shell脚本执行结束, 执行成功.");
			else
				logger.info("Job : {" + shellbean.getDescription()
						+ "}的Shell脚本执行结束, 执行失败.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
