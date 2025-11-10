package org.example.tathyabackend.service;

import org.example.tathyabackend.dtos.UserRegisterDto;

import java.util.Date;

public interface UserService {
    public  String registerUser(UserRegisterDto userRegisterDto);
}
