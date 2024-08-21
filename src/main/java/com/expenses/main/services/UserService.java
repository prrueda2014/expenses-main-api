package com.expenses.main.services;

import com.expenses.main.exceptions.UserNotFoundException;
import com.expenses.main.models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface UserService {

    Page<User> findAll(Pageable pageable);

    User save (User user);

    String delete(Long id) throws UserNotFoundException;

    Optional<User> findById(Long id) throws UserNotFoundException;

    User update(Long id, User user) throws UserNotFoundException;

}
