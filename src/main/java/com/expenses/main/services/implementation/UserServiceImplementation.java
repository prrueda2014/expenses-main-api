package com.expenses.main.services.implementation;

import com.expenses.main.dao.UserRepository;
import com.expenses.main.exceptions.RecordNotFoundException;
import com.expenses.main.exceptions.UserNotFoundException;
import com.expenses.main.models.User;
import com.expenses.main.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service(value = "userService")
public class UserServiceImplementation implements UserService {

    @Autowired
    private UserRepository userRepository;

    public Page<User> findAll(Pageable pageable) {
        Page<User> listUsers = userRepository.findAll(pageable);
        return listUsers;
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public String delete(Long id) throws UserNotFoundException {
        return userRepository.findById(id).map(user -> {
            userRepository.delete(user);
            return String.format("User %s %s has been successfully deleted!", user.getFirstname(), user.getLastname());
        }).orElseThrow(() -> new UserNotFoundException("User not found!"));
    }

    @Override
    public Optional<User> findById(Long id) throws UserNotFoundException {
        return userRepository.findById(id);
    }

    @Override
    public User update(Long id, User requestUser) throws UserNotFoundException {
        return userRepository.findById(id).map(user -> {
            user.setFirstname(requestUser.getFirstname());
            user.setLastname(requestUser.getLastname());
            user.setUsername(requestUser.getUsername());
            user.setEmail(requestUser.getEmail());
            return userRepository.save(user);
        }).orElseThrow(() -> new UserNotFoundException("User not found!"));
    }

}