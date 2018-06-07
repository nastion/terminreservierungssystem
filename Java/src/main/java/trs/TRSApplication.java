package trs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"trs.controller", "trs.data", "trs.repositories", "trs.view", "example.hello"})
public class TRSApplication {
    public static void main(String[] args) {
        SpringApplication.run(TRSApplication.class, args);
    }



}