package coreclosetsale.closet_sale.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import coreclosetsale.closet_sale.dto.AuthRequest;
import coreclosetsale.closet_sale.dto.AuthResponse;
import coreclosetsale.closet_sale.services.AuthService;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController 
@RequiredArgsConstructor 
@RequestMapping ("/api/auth")
@CrossOrigin(origins = "http://localhost:5173") 
public class AuthController {

    private final AuthService authService;

    @PostMapping("/token")
    public AuthResponse login(@RequestBody AuthRequest authRequest) {
        return authService.authenticate(authRequest);
    }
}