package com.oldmee.nutz.mainModule.service;

public interface EmailService {
    boolean send(String to, String subject, String html);
}