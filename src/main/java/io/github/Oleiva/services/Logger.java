package io.github.Oleiva.services;

/**
 * Created by Oleh Ivashko on 07.06.2016.
 */

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.MessageFormat;
import java.util.Properties;


@Component
public class Logger {

    @Autowired
    private JavaMailSender mailSender;


    /**
     * Service for logging application errors
     *
     * @Author hard coded and  crypted by Oleh Ivashko
     * @Created 6/5/2016
     */


    @Bean
    public JavaMailSender setMailSender() {
        JavaMailSenderImpl msi = new JavaMailSenderImpl();
        msi.setHost("smtp.gmail.com");
        msi.setPort(465);
        msi.setUsername("sparktestapp@gmail.com");
        msi.setPassword("spark4testapp");
        Properties p = new Properties();
        p.put("mail.transport.protocol", "smtps");
        p.put("mail.smtp.auth", "true");
        p.put("mail.smtp.starttls.enable", "true");
        p.put("mail.smtps.ssl.checkserveridentity", "true");
        p.put("mail.smtps.ssl.trust", "*");
        p.put("mail.smtp.starttls.required", "true");
        p.put("mail.debug", "false");
        msi.setJavaMailProperties(p);
        this.mailSender = msi;
        return msi;
    }

    public void alert(String message) {
        mailSender.send(prepare(MessageFormat.format("OpenBet return {0} error", message)));
    }

    private MimeMessagePreparator prepare(String message) {
        System.out.println(message);
        return mimeMessage -> {
            MimeMessageHelper message1 = new MimeMessageHelper(mimeMessage);
            message1.setTo(StringUtils.split("Oleg.ivashko@yandex.ua", ","));
            message1.setFrom("sparktestapp@gmail.com");
            message1.setSubject("Alert");
            String body = "<html><body><h2></h2><p>" + message+"<p>"+"ip "+getStatistic()+"</p>"+ "</p></body></html>";
            message1.setText(body, true);
        };
    }

    public String getStatistic() throws MalformedURLException {
        String ip ="";
        try {
            URL whatismyip = new URL("http://checkip.amazonaws.com");
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    whatismyip.openStream()));

            ip = in.readLine(); //you get the IP as a String
//            System.out.println(ip);
        }catch (ExceptionInInitializerError ex){

        } catch (IOException e) {
            e.printStackTrace();
        }

        return ip;

    }

}
