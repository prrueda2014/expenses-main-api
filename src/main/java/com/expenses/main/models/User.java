package com.expenses.main.models;

import com.expenses.main.enums.Roles;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
@Data
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private long userId;

    @Column
    private String firstname;

    @Column
    private String lastname;

    @Column(unique = true)
    private String username;

    @Column
    private String password;

    @Column
    private String email;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "role")
    private Roles role = Roles.USER;

}
