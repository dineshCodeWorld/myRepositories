package com.infy.teslapro.event;

import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import com.infy.teslapro.entity.Token;
import com.infy.teslapro.entity.User;
import com.infy.teslapro.exception.UserNotFoundException;
import com.infy.teslapro.repository.TokenRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@org.springframework.transaction.annotation.Transactional
public class EventListener implements ApplicationListener<RegistrationCompleteEvent>
{
	String token;
	@Autowired
	private JavaMailSender mailSender;
	
    @Value("${email.id}")
    private String mailId;
	
	@Autowired
    private TokenRepository tokenRepository;
	@Override
	public void onApplicationEvent(RegistrationCompleteEvent event) {
      User user = event.getUser();
      token = UUID.randomUUID().toString();
      Token token1 = new Token(token, user);
      tokenRepository.save(token1);
      String url = event.getUrl() + "/validateToken?token=" + token;
      String body = "Please click on the link to verify your account: " + url;
      try {
		sendSimpleMail(user.getEmail(),"verification Link",body);
	} catch (UserNotFoundException e) {
		log
		.info(e.getMessage());
	}
	}
	
	public void sendSimpleMail(String email, String subject, String body) throws UserNotFoundException {
		try {
     SimpleMailMessage mailMessage = new SimpleMailMessage();
     mailMessage.setFrom(mailId);
     mailMessage.setTo(email);
     mailMessage.setSubject(subject);
     mailMessage.setText(body);
     mailSender.send(mailMessage);
		log.info("mail send");
		}catch (Exception e) {
			throw new UserNotFoundException("something went wrong");
		}
	}

}