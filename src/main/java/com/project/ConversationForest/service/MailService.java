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

        try{
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, false, "UTF-8");
            System.out.println(email);
            // 메일을 받을 수신자 설정
            mimeMessageHelper.setTo(email);
            // 메일의 제목 설정
            mimeMessageHelper.setSubject("html 적용 테스트 메일 제목");

            // html 문법 적용한 메일의 내용
            String content = """
                    <!DOCTYPE html>
                                        
                    <body>
                    <div style="margin:100px;">
                        <h1> 메일 인증 메시지입니다. </h1>
                        <br>         
                        <div align="center" style="border:1px solid black;">
                            <h3> 테스트 메일 내용 </h3>
                        </div>
                        <br/>
                    </div>
                                        
                    </body>
                    </html>
                    """;

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