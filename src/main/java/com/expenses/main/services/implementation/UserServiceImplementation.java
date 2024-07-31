package com.expenses.main.services.implementation;

import com.expenses.main.dao.UserRepository;
import com.expenses.main.models.Users;
import com.expenses.main.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "userService")
public class UserServiceImplementation implements UserService {

    @Autowired
    private UserRepository userRepository;

    public Page<Users> findAll(Pageable pageable) {
        Page<Users> listUsers = userRepository.findAll(pageable);
        return listUsers;
    }
}
