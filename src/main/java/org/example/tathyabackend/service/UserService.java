package org.example.tathyabackend.service;

import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpServletResponse;
import org.example.tathyabackend.dtos.UserRegisterDto;
import org.example.tathyabackend.dtos.VerifyOtpRequest;


public interface UserService {
     String registerUser(UserRegisterDto userRegisterDto) throws MessagingException;
    String login(String email, String password, HttpServletResponse response);
    void logout(HttpServletResponse response);
    String verifyUserAndSave(VerifyOtpRequest verifyOtpRequest, HttpServletResponse response);
}
