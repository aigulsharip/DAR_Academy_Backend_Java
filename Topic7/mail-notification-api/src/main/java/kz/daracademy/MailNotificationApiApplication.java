package kz.daracademy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MailNotificationApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(MailNotificationApiApplication.class, args);
    }

    /*
    @Autowired
    private EmailSenderService senderService;


    @EventListener (ApplicationReadyEvent.class)
    public void sendEmail () {
        senderService.sendEmail("aigul.sharip@nu.edu.kz",
                "This is Subject",
                "This is body of email");
    }

     */



}
