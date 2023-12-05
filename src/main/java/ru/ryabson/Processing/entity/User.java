package ru.ryabson.Processing.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Entity
@Table(name = "pc_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long userId;

    @Column(name = "name", unique = true)
    private String userName;

    @Column(name = "password")
    private String userPassword;

    @Column(name = "email")
    @Pattern(regexp = ".+@.+\\..+", message = "Некорректный формат электронной почты")
    private String userMail;

}
