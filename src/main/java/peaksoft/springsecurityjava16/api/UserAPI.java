package peaksoft.springsecurityjava16.api;

import org.springframework.web.bind.annotation.*;
import peaksoft.springsecurityjava16.dto.AuthResponse;
import peaksoft.springsecurityjava16.dto.LoginRequest;
import peaksoft.springsecurityjava16.dto.UserRegisterRequest;
import peaksoft.springsecurityjava16.services.UserService;

@RestController
@RequestMapping("/auth")
public class UserAPI {

    private final UserService userService;

    public UserAPI(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public AuthResponse signIn(@RequestBody LoginRequest request){
        return userService.signIn(request);
    }

    @PostMapping("/register")
    public AuthResponse signUp(@RequestBody UserRegisterRequest registerRequest){
        return userService.signUp(registerRequest);
    }
}
