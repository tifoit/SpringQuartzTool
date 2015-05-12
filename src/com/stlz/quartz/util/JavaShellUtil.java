package com.stlz.quartz.util;
/**
 * @Title: JavaShellUtil.java
 * @Package: com.stlz.quartz.util
 * @Desc: java Shell Tool
 * @Copyright: 
 * @author: liuzhuang
 * @date: 2013/04/25
 * @Email: liuzhuang@umpay.com
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

public class JavaShellUtil {
	
	private String shellCommand;
	private String shellCommandNo;

	private static Logger logger = Logger.getLogger(JavaShellUtil.class.getName());

	public int executeShell(String shellCommand) throws IOException {
		int success = 0;
		StringBuffer stringBuffer = new StringBuffer();
		BufferedReader bufferedReader = null;
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:SS ");

		try {
			stringBuffer.append(dateFormat.format(new Date()))
					.append("准备执行Shell命令 ").append(shellCommand)
					.append(" \r\n");
			Process pid = null;
			String[] cmd = { "/bin/bash", "-c", shellCommand };
			pid = Runtime.getRuntime().exec(cmd);
			System.out.println(cmd.toString());
			System.out.println(pid);
			if (pid != null) {
				stringBuffer.append("进程号：").append(pid.toString()).append("\r\n");
				bufferedReader = new BufferedReader(new InputStreamReader(pid.getInputStream()), 1024);
				pid.waitFor();
			} else {
				stringBuffer.append("没有pid\r\n");
			}
			stringBuffer.append(dateFormat.format(new Date())).append("Shell命令执行完毕\r\n执行结果为：\r\n");
			String line = null;
			while (bufferedReader != null
					&& (line = bufferedReader.readLine()) != null) {
				stringBuffer.append(line).append("\r\n");
			}
			System.out.println("stringBuffer:" + stringBuffer);
			logger.info("stringBuffer:" + stringBuffer);
		} catch (Exception ioe) {
			stringBuffer.append("执行Shell命令时发生异常：\r\n").append(ioe.getMessage()).append("\r\n");
			logger.error(ioe.getMessage());
		} finally {
			if (bufferedReader != null) {
				try {
					bufferedReader.close();
					// 将Shell的执行情况输出到日志文件中
					System.out.println("日志全过程:\n" + stringBuffer.toString());
					logger.info("日志全过程:\n" + stringBuffer.toString());
				} catch (Exception e) {
					e.printStackTrace();
					logger.error(e.getMessage());
				} 
			}
			success = 1;
		}
		return success;
	}
}
