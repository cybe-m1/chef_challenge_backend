package chefchallenge.backend.ingredients;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class IngredientsApplication {

    public static void main(String[] args) {
        SpringApplication.run(IngredientsApplication.class, args);
    }

}
