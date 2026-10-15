package coreclosetsale.closet_sale.services;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import coreclosetsale.closet_sale.dto.AuthRequest;
import coreclosetsale.closet_sale.dto.AuthResponse;

@Service 
public class AuthService {
     private final AuthenticationManager authenticationManager;
    private final JwtTokenService jwtTokenService;

    public AuthService(AuthenticationManager authenticationManager, JwtTokenService jwtTokenService) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenService = jwtTokenService;
    }

    public AuthResponse authenticate(AuthRequest authRequest) {
        // 1. Acceso moderno usando los métodos nativos del Record (sin "get")
        var token = new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword());
        
        // 2. Autenticación con el AuthenticationManager de Spring Security
        Authentication authentication = authenticationManager.authenticate(token);

        // 3. Generación y extracción de tiempos del JWT
        String jwtToken = jwtTokenService.generateToken(authentication);
        Long expiresAt = jwtTokenService.extractExpirationTime(jwtToken);

        // 4. Retorno usando el constructor posicional del Record AuthResponse
        return new AuthResponse(jwtToken, authentication.getName(), expiresAt);
    }

}
