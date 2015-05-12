package com.stlz.quartz.service;

/**
 * @Title: AutoShellService.java
 * @Package: com.stlz.quartz.service
 * @Desc: execute shell script
 * @Copyright:
 * @author: liuzhuang
 * @date: 2013/04/25
 * @Email: liuzhuang@umpay.com
 */

import java.io.IOException;

import com.stlz.quartz.util.JavaShellUtil;

public abstract class AutoShellService {
	private JavaShellUtil jsu = new JavaShellUtil();

	public void execute(String shellScript) throws IOException {
		jsu.executeShell(shellScript);
	}

}
