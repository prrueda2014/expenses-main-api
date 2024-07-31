package com.expenses.main.services;

import com.expenses.main.models.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {

    Page<Users> findAll(Pageable pageable);
}
