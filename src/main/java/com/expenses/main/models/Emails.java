package com.expenses.main.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table (name = "emails")
@Data
public class Emails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="email_id")
    private long emailId;

    @Column(name="email_address")
    private String emailAddress;

//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "user_id", nullable = false)
//    private Users users;
}
