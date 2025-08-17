package mylab.notification.di.annot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import mylab.notification.di.annot.EmailNotificationService;
import mylab.notification.di.annot.NotificationManager;
import mylab.notification.di.annot.NotificationService;
import mylab.notification.di.annot.SmsNotificationService;

@Configuration
public class NotificationConfig {
	
	@Autowired
	NotificationManager notificationManager;
	
	@Bean
	public NotificationService emailNotificationService(String smtpServer, int port) {
		return new EmailNotificationService(smtpServer,port);
	}
	@Bean
	public NotificationService smsNotificationService(String provider) {
		return new SmsNotificationService(provider);
	}
	@Bean 
	public NotificationManager notificationManager() {
		return new NotificationManager(emailNotificationService("smtp.gmail.com",587),smsNotificationService("SKT"));
	}
	
}
