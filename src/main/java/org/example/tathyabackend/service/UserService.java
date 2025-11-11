package org.example.tathyabackend.service;

import jakarta.servlet.http.HttpServletResponse;
import org.example.tathyabackend.dtos.UserRegisterDto;


public interface UserService {
     String registerUser(UserRegisterDto userRegisterDto);
    String login(String email, String password, HttpServletResponse response);
    void logout(HttpServletResponse response);
}
