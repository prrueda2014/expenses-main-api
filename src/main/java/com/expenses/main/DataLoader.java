package com.expenses.main;

import com.expenses.main.dao.UserRepository;
import com.expenses.main.enums.Roles;
import com.expenses.main.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
//        User adminUser = new User();
//        adminUser.setFirstname("Paolo");
//        adminUser.setLastname("Rueda");
//        adminUser.setUsername("pao");
//        adminUser.setPassword(passwordEncoder.encode("pao"));
//        adminUser.setRole(Roles.ADMIN);
//        adminUser.setEmail("pao@email.com");
//        userRepository.save(adminUser);
//
//        User userUser = new User();
//        userUser.setFirstname("Apple");
//        userUser.setLastname("Rueda");
//        userUser.setUsername("apple");
//        userUser.setPassword(passwordEncoder.encode("apple"));
//        userUser.setRole(Roles.USER);
//        userUser.setEmail("apple@email.com");
//        userRepository.save(userUser);
    }
}
