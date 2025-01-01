package com.project.ConversationForest.service;


import com.project.ConversationForest.domain.Member;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class MailService {

    private final JavaMailSender javaMailSender;

    public boolean sendMimeMessage(String email) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        int number = 0;

        try{
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, false, "UTF-8");
            System.out.println(email);
            // 메일을 받을 수신자 설정
            mimeMessageHelper.setTo(email);
            // 메일의 제목 설정
            mimeMessageHelper.setSubject("이메일 인증 안내 메일입니다.");

            // html 문법 적용한 메일의 내용
            String content = "";
            content += "<h1>안녕하세요</h1>";
            content += "<h1>이메일 인증 안내 메일입니다.</h1>";
            content += "<br>";
            content += "<br>";
            content += "<div align='center' style='border:1px solid black'>";
            content += "<h3 style='color:blue'>회원가입 인증코드 입니다</h3>";
            content += "<div style='font-size:130%'>";
            content += "<strong>" + number + "</strong></div><br/>" ; // 메일에 인증번호 ePw 넣기
            content += "</div>";

            // 메일의 내용 설정
            mimeMessageHelper.setText(content, true);

            javaMailSender.send(mimeMessage);

            log.info("메일 발송 성공!");
            return true;
        } catch (Exception e) {
            log.info("메일 발송 실패!");
            return false;
        }
    }
}