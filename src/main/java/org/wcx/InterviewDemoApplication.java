package org.wcx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class InterviewDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(InterviewDemoApplication.class, args);
    }

}
