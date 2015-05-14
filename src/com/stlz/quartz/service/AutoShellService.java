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

import com.stlz.quartz.bean.ShellBean;

public interface AutoShellService {
	public void execute(ShellBean sbean) throws IOException;
}
