package mylab.notification.di.annot;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import static org.junit.jupiter.api.Assertions.*;
import mylab.notification.di.annot.config.NotificationConfig;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(
		classes = NotificationConfig.class,
		loader = AnnotationConfigContextLoader.class)
public class NotificationConfigTest {
	
	@Autowired
	NotificationManager notificationManager;
	
	@Test
	void testNotificationManager( ) {
		assertNotNull(notificationManager);
		
		assertNotNull(notificationManager.getEmailService());
		EmailNotificationService email = (EmailNotificationService)notificationManager.getEmailService();
		assertEquals("smtp.gmail.com",email.getSmtpServer());
		assertEquals(587,email.getPort());
		
		assertNotNull(notificationManager.getSmsService());
		SmsNotificationService sms = (SmsNotificationService)notificationManager.getSmsService();
		assertEquals("SKT",sms.getProvider());
		
		notificationManager.sendNotificationByEmail("테스트 이메일");
		notificationManager.sendNotificationBySms("테스트 SMS");
		
		
	}
	
	

}
