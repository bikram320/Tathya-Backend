package org.example.tathyabackend.service;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.example.tathyabackend.dtos.UserRegisterDto;
import org.example.tathyabackend.model.User;
import org.example.tathyabackend.repository.UserRepository;
import org.example.tathyabackend.util.JwtUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class UserServiceImp implements UserService {

    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;


    @Override
    public String registerUser(UserRegisterDto userRegisterDto) {
        User user = userRepository.findByEmail(userRegisterDto.getEmail());
        if (user != null) {
            return "User with this email already exists.";
        } else {
            User newUser = new User();
            newUser.setName(userRegisterDto.getName());
            newUser.setEmail(userRegisterDto.getEmail());
            newUser.setPassword(String.valueOf(passwordEncoder.encode(userRegisterDto.getPassword())));
            newUser.setDateOfBirth(userRegisterDto.getDateOfBirth());
            userRepository.save(newUser);

            return jwtUtil.generateToken(newUser.getEmail());
        }
    }

    @Override
    public String login(String email, String password, HttpServletResponse response) {
        Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(email, password)
        );

        UserDetails userDetails = (UserDetails) auth.getPrincipal();
        String token = jwtUtil.generateToken(userDetails.getUsername());

        // set cookie (HttpOnly)
        Cookie cookie = new Cookie("jwt", token);
        cookie.setHttpOnly(true);
        cookie.setPath("/");
        cookie.setMaxAge((int) (jwtUtil.getJwtExpirationMs() / 1000));
        response.addCookie(cookie);

        return token;
    }

    @Override
    public void logout(HttpServletResponse response) {
        Cookie cookie = new Cookie("jwt", "");
        cookie.setHttpOnly(true);
        cookie.setPath("/");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
    }
}
