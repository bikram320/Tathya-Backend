package org.example.tathyabackend.service;

import lombok.AllArgsConstructor;
import org.example.tathyabackend.dtos.UserRegisterDto;
import org.example.tathyabackend.model.User;
import org.example.tathyabackend.repository.UserRepository;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class UserServiceImp implements UserService {

    private final UserRepository userRepository;

    @Override
    public String registerUser(UserRegisterDto userRegisterDto) {
        User user = userRepository.findByEmail(userRegisterDto.getEmail());
        if (user != null) {
            return "User with this email already exists.";
        } else {
            User newUser = new User();
            newUser.setName(userRegisterDto.getName());
            newUser.setEmail(userRegisterDto.getEmail());
            newUser.setPassword(userRegisterDto.getPassword());
            newUser.setDateOfBirth(userRegisterDto.getDateOfBirth());
            userRepository.save(newUser);
            return "User registered successfully.";
        }
    }
}
