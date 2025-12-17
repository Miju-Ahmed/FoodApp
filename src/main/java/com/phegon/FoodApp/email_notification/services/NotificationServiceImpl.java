package com.phegon.FoodApp.email_notification.services;

import java.nio.charset.StandardCharsets;

import javax.management.RuntimeErrorException;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.phegon.FoodApp.email_notification.dtos.NotificationDTO;
import com.phegon.FoodApp.email_notification.entity.Notification;
import com.phegon.FoodApp.email_notification.repository.NotificationRepository;

import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationServiceImpl implements NotificationService {


    private final JavaMailSender javaMailSender;
    private final NotificationRepository notificationRepository;


    @Override
    @Async
    public void sendEmail(NotificationDTO notificationDTO){

        log.info("Inside sendEmail()");
        try{

            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(
                mimeMessage, 
                MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                StandardCharsets.UTF_8.name());

            helper.setTo(notificationDTO.getRecipient());
            helper.setSubject(notificationDTO.getSubject());
            helper.setText(notificationDTO.getBody(), notificationDTO.isHtml());

            javaMailSender.send(mimeMessage);

            //Save to Database
            Notification notificationToSave = Notification.builder()
                                            .subject(notificationDTO.getSubject())
                                            .recipient(notificationDTO.getRecipient())
                                            .body(notificationDTO.getBody())
                                            .type(notificationDTO.getType().EMAIL)
                                            .isHtml(notificationDTO.isHtml())
                                            .build();

            notificationRepository.save(notificationToSave);

            log.info("Save to notification table");

        }catch(Exception e){
            throw new RuntimeErrorException(null, e.getMessage());
        }

    }

}
