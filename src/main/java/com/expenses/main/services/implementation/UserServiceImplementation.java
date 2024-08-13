package com.expenses.main.services.implementation;

import com.expenses.main.dao.UserRepository;
import com.expenses.main.enums.Roles;
import com.expenses.main.exceptions.UserNotFoundException;
import com.expenses.main.models.User;
import com.expenses.main.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service(value = "userService")
public class UserServiceImplementation implements UserService, UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    public Page<User> findAll(Pageable pageable) {
        Page<User> listUsers = userRepository.findAll(pageable);
        return listUsers;
    }

    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public String delete(Long id) throws UserNotFoundException {
        return null;
    }

    @Override
    public User findById(Long id) throws UserNotFoundException {
        return null;
    }

    @Override
    public User update(Long id, User user) throws UserNotFoundException {
        return null;
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username).map(user -> {
            return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthority(user));
        }).orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));
    }

    private List<SimpleGrantedAuthority> getAuthority(User user) throws UsernameNotFoundException {
        Roles userRole = Arrays.stream(Roles.values()).filter(role -> {
            return role.name().equalsIgnoreCase(user.getRole().name());
        }).findFirst().orElse(null);
        return Arrays.asList(new SimpleGrantedAuthority(String.format("ROLE_%s", userRole.name())));
    }
}
