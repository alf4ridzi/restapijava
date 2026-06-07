package com.lowcontext.restapijava.seeders;

import com.github.javafaker.Faker;
import com.lowcontext.restapijava.models.User;
import com.lowcontext.restapijava.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Seeder implements CommandLineRunner {

    private final UserRepository userRepository;

    @Autowired
    public Seeder(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) {
        userSeeder();
    }

    public void userSeeder() {
        Faker faker = new Faker();

        User user = new User();

        String email =
            faker.name().firstName().toLowerCase() +
            faker.name().lastName().toLowerCase() +
            "@gmail.com";

        String name = faker.name().firstName() + " " + faker.name().lastName();

        user.setEmail(email);
        user.setName(name);
        user.setPasssword("lowcontext123");

        this.userRepository.save(user);
    }
}
