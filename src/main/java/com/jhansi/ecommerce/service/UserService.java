package com.jhansi.ecommerce.service;

import com.jhansi.ecommerce.dto.RegisterRequest;
import com.jhansi.ecommerce.entity.User;
import com.jhansi.ecommerce.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.jhansi.ecommerce.dto.LoginRequest;
import java.util.Optional;
import com.jhansi.ecommerce.security.JwtService;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public UserService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder,
                       JwtService jwtService) {

        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }
    public String register(RegisterRequest request) {

        User user = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role("USER")
                .build();

        userRepository.save(user);

        return "User Registered Successfully";
    }

    public String login(LoginRequest request) {

        Optional<User> userOptional =
                userRepository.findByEmail(request.getEmail());

        if(userOptional.isEmpty()) {
            return "User Not Found";
        }

        User user = userOptional.get();

        if(passwordEncoder.matches(
                request.getPassword(),
                user.getPassword())) {

            return jwtService.generateToken(user.getEmail());
        }

        return "Invalid Password";
    }
}