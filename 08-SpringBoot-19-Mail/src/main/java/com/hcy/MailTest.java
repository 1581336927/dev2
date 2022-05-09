package com.hcy;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Date;

@SpringBootTest
public class MailTest {
    @Autowired
    private JavaMailSender sender;

    @Test
    void testSimple(){
        //简短的邮件信息
        SimpleMailMessage message=new SimpleMailMessage();

            //发送人
            message.setFrom("3473532212@qq.com");
            //接收人
            message.setTo("1795852696@qq.com");

            //抄送人
            message.setCc("2227302797@qq.com");

            //秘密抄送,只有发送者和密抄者才能看到
            message.setBcc("2312697938@qq.com");
            //邮件主题
            message.setSubject("您有一条新的邮件请注意查收");
            //邮件内容
            message.setText("韩哥说您长得太丑了，请速速前往韩国去改头换面");
            //发送邮件
            sender.send(message);

    }

    @Test
    void testHtml(){
        //创建一个邮件对象
        MimeMessage mimeMessage = sender.createMimeMessage();


        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
        try {
           messageHelper.setFrom("3473532212@qq.com");
            //设置发送的时间
            messageHelper.setSentDate(new Date());

            messageHelper.setTo("1795852696@qq.com");

            messageHelper.setCc(new String[]{
                    "2227802797@qq.com"
            });

            messageHelper.setBcc("2857129735@qq.com");

            messageHelper.setSubject("重金求子");

            messageHelper.setText("<font color='red'>我想和你生个猴子😚</font>",true);

            sender.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
