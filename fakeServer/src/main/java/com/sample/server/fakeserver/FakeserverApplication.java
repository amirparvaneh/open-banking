package com.sample.server.fakeserver;

import com.sample.server.fakeserver.entity.User;
import com.sample.server.fakeserver.repository.UserRep;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class FakeserverApplication {
    public static void main(String[] args) {
        SpringApplication.run(FakeserverApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(UserRep userRepository) throws Exception {
        return (String[] args) -> {
            User user1 = new User("ali","russel","sina","76432111");
            User user2 = new User("sss","bad","sarmaye","34434334");
            userRepository.save(user1);
            userRepository.save(user2);
            userRepository.findAll().forEach(user -> System.out.println(user));
        };
    }
}
