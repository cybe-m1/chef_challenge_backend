package chefchallenge.backend.challenges;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@AutoConfigurationPackage
@SpringBootApplication
public class ChallengesApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChallengesApplication.class, args);
    }

}
