package com.stlz.quartz.service;

import com.stlz.quartz.bean.MailBean;

public interface MailService {
	void sendEmail(MailBean mail);
}
