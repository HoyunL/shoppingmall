package shop.shoppingmall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableJpaAuditing
@SpringBootApplication
public class ShoppingmallApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShoppingmallApplication.class, args);
    }

}
