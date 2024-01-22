package by.pvt.project;

import by.pvt.project.contract.MailSenderService;
import by.pvt.project.dto.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EnableJpaRepositories("by.pvt.project.repository")
public class StartApp {
    @Autowired
    private MailSenderService mailSenderService;

    public static void main(String[] args) {
        SpringApplication.run(StartApp.class, args);
    }

}
