package org.example.tathyabackend.controller;

import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.example.tathyabackend.dtos.LoginRequest;
import org.example.tathyabackend.dtos.UserRegisterDto;
import org.example.tathyabackend.dtos.VerifyOtpRequest;
import org.example.tathyabackend.service.MailService;
import org.example.tathyabackend.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@AllArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final MailService mailService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserRegisterDto userRegisterDto) throws MessagingException {
        String message = userService.registerUser(userRegisterDto);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
    @PostMapping("/register/verify-otp")
    public ResponseEntity<?> verifyOtpAndSaveUser(@RequestBody VerifyOtpRequest verifyOtpRequest, HttpServletResponse response) {
        return ResponseEntity.ok(userService.verifyUserAndSave(verifyOtpRequest, response));
    }

    @PostMapping("/register/resend-otp")
    public ResponseEntity<?> resendOtp(@RequestParam String email) throws MessagingException {
         mailService.resendOtp(email);
         return new ResponseEntity<>("OTP resent successfully", HttpStatus.OK);
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest, HttpServletResponse response) {
        String token = userService.login(loginRequest.getEmail(), loginRequest.getPassword(), response);
        return new ResponseEntity<>(token, HttpStatus.OK);
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout(HttpServletResponse response) {
        userService.logout(response);
        return ResponseEntity.ok().body("Logged out");
    }

}
