package peaksoft.springsecurityjava16.services;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import peaksoft.springsecurityjava16.config.jwt.JwtService;
import peaksoft.springsecurityjava16.dto.AuthResponse;
import peaksoft.springsecurityjava16.dto.LoginRequest;
import peaksoft.springsecurityjava16.dto.UserRegisterRequest;
import peaksoft.springsecurityjava16.entities.User;
import peaksoft.springsecurityjava16.repositories.UserRepo;

@Service
public class UserService {
    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public UserService(UserRepo userRepo, PasswordEncoder passwordEncoder, JwtService jwtService) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public AuthResponse signIn(LoginRequest request) {
        User user = userRepo.findUserByEmail(request.getEmail()).orElseThrow(
                () -> new RuntimeException(request.getEmail())
        );
        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }
        return new AuthResponse(user.getId(), user.getEmail(), user.getRole(), jwtService.generateToken(user));
    }

    public AuthResponse signUp(UserRegisterRequest registerRequest) {
        User user = new User();
        user.setEmail(registerRequest.getEmail());
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        user.setRole("USER");
        userRepo.save(user);
        return new AuthResponse(user.getId(), user.getEmail(), user.getRole(), jwtService.generateToken(user));
    }
}
