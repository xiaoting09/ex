package com.xiao.ex.service.impl;

import com.xiao.ex.entity.ExConfig;
import com.xiao.ex.service.ConfigService;
import com.xiao.ex.service.MsgService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.List;

/**
 * 邮件消息发送
 *
 * @author 肖亭
 * @since 2017年10月11 17:35
 **/
@Service(value = "emailMsgService")
public class EmailMsgServiceImpl implements MsgService {
    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private ConfigService configService;
    @Value("${mail.username}")
    private String username;

    @Override
    public void sendMsg(String to, String content) {
        JavaMailSender emailConf = getEmailConf();
        if (emailConf == null) {
            emailConf = javaMailSender;
        }
        try {
            MimeMessage message = emailConf.createMimeMessage();
            MimeMessageHelper helper = null;

            helper = new MimeMessageHelper(message, true, "utf-8");
            helper.setSubject("异常通知邮件");
            helper.setFrom(username);
            helper.setTo(to.split(","));
            helper.setText(content);
            javaMailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取配置
     */
    private JavaMailSenderImpl getEmailConf() {
        List<ExConfig> hort = configService.getConf("mail.host");
        List<ExConfig> port = configService.getConf("mail.port");
        List<ExConfig> username = configService.getConf("mail.username");
        List<ExConfig> password = configService.getConf("mail.password");
        if (CollectionUtils.isEmpty(hort) || CollectionUtils.isEmpty(port) ||
                CollectionUtils.isEmpty(username) || CollectionUtils.isEmpty(password)) {
            return null;
        }
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        javaMailSender.setHost(hort.get(0).getValue());
        javaMailSender.setPort(Integer.valueOf(port.get(0).getValue()));
        javaMailSender.setUsername(username.get(0).getValue());
        javaMailSender.setPassword(password.get(0).getValue());
        this.username = username.get(0).getValue();
        return javaMailSender;
    }

}
