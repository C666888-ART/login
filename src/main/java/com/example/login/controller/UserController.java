package com.example.login.controller;

import com.example.login.entity.User;
import com.example.login.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173")   // 允许前端 HBuilderX 端口
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    public String register(@RequestBody User user) {
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            return "用户名已存在";
        }
        userRepository.save(user);   // 明文保存，仅测试用
        return "注册成功";
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        return userRepository.findByUsername(user.getUsername())
                .filter(u -> u.getPassword().equals(user.getPassword()))
                .map(u -> "登录成功")
                .orElse("用户名或密码错误");
    }
}

