package coreclosetsale.closet_sale.services;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import coreclosetsale.closet_sale.dto.AuthRequest;
import coreclosetsale.closet_sale.dto.AuthResponse;
import coreclosetsale.closet_sale.dto.DistrictDetail;
import coreclosetsale.closet_sale.dto.RegisterResponse;
import coreclosetsale.closet_sale.dto.UserResponse;
import coreclosetsale.closet_sale.models.User;
import coreclosetsale.closet_sale.repositories.DistrictRepository;
import coreclosetsale.closet_sale.repositories.UserRepository;

@Service 
public class AuthService {
    private final AuthenticationManager authenticationManager;
    private final JwtTokenService jwtTokenService;
    private final DistrictRepository districtRepository;
    private final UserRepository userRepository;

    public AuthService(AuthenticationManager authenticationManager, JwtTokenService jwtTokenService, UserRepository userRepository, DistrictRepository districtRepository) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenService = jwtTokenService;
        this.userRepository = userRepository;
        this.districtRepository = districtRepository;
    }

    public RegisterResponse authenticate(AuthRequest authRequest) {
        // 1. Acceso moderno usando los métodos nativos del Record (sin "get")
        var token = new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword());
        
        // 2. Autenticación con el AuthenticationManager de Spring Security
        Authentication authentication = authenticationManager.authenticate(token);

        // 3. Generación y extracción de tiempos del JWT
        String jwtToken = jwtTokenService.generateToken(authentication);
        Long expiresAt = jwtTokenService.extractExpirationTime(jwtToken);


        var authResponse = new AuthResponse(jwtToken, authentication.getName(), expiresAt);

        // 1. Extraemos la entidad User pura de la base de datos
        User user = userRepository.findByUsername(authRequest.getUsername()).get();
        DistrictDetail detail = districtRepository.getDistrictDetail(user.getDistrict().getId());

        // 2. 🚨 CONVERSIÓN CLAVE: Creamos el UserResponse usando los datos de la entidad User
        // (Ajusta los parámetros según lo que pida el constructor de tu UserResponse)
        var userResponse = new UserResponse(
            user.getId(), 
            user.getUsername(),
            user.getEmail(),
            user.getFirstName(), 
            user.getLastName(), 
            user.getWhatsappNumber(), 
            user.getUrlImage(), 
            user.getUniqueNameImage(),
            detail.districtName(),
            detail.provinceName(),
            detail.departmentName()
        );
         // 4. Retorno usando el constructor posicional del Record AuthResponse
        return new RegisterResponse(userResponse, authResponse);
    }

}
