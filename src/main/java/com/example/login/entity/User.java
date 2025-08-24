package com.example.login.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "t_user")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false, length = 32)
    private String username;

    @Column(nullable = false, length = 64)
    private String password;   // 测试阶段先用明文，后期可加密
}

