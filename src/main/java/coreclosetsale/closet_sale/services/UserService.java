package coreclosetsale.closet_sale.services;

import java.util.UUID;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import coreclosetsale.closet_sale.dto.AuthResponse;
import coreclosetsale.closet_sale.dto.RegisterRequest;
import coreclosetsale.closet_sale.dto.RegisterResponse;
import coreclosetsale.closet_sale.dto.UserResponse;
import coreclosetsale.closet_sale.models.User;
import coreclosetsale.closet_sale.repositories.UserRepository;

@Service 
public class UserService {

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenService jwtTokenService;

    // Inyección de dependencias por constructor
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder,AuthenticationManager authenticationManager, JwtTokenService jwtTokenService) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenService = jwtTokenService;
    }

    @Transactional 
    public RegisterResponse register(RegisterRequest registerRequest) {
        // 1. Validar si el nombre de usuario o email ya está tomado
        if (userRepository.existsByUsername(registerRequest.username())) {
            throw new IllegalArgumentException("El nombre de usuario ya está en uso");
        }

        // 2. Crear la entidad y encriptar la contraseña antes de guardar
        var user = new User();
        user.setId(UUID.randomUUID());
        user.setUsername(registerRequest.username());
        user.setEmail(registerRequest.email());
        user.setLastname(registerRequest.lastName());
        user.setFirstname(registerRequest.firstName());
        user.setWhatsappNumber(registerRequest.whatsappNumber());
        user.setPassword(passwordEncoder.encode(registerRequest.password()));
        user.setUrlImage(registerRequest.urlImage());
        user.setUniqueNameImage(registerRequest.uniqueNameImage());
        
        // Guardamos la contraseña plana temporalmente para autenticar más abajo
        String rawPassword = registerRequest.password(); 
        user.setPassword(passwordEncoder.encode(rawPassword));

        User savedUser = userRepository.save(user);

        // 3. Mapear la respuesta del usuario (UserResponse)
        var userResponse = new UserResponse(
            savedUser.getId(), 
            savedUser.getUsername(), 
            savedUser.getEmail(), 
            savedUser.getFirstname(), // O getFirstname() según tu entidad
            savedUser.getLastname(), 
            savedUser.getWhatsappNumber(),
            savedUser.getUrlImage(),
            savedUser.getUniqueNameImage()
        );

        // 4. Autenticar AUTOMÁTICAMENTE al usuario recién creado
        var authToken = new UsernamePasswordAuthenticationToken(registerRequest.username(), rawPassword);
        Authentication authentication = authenticationManager.authenticate(authToken);

        // 5. Generar el JWT para este usuario
        String jwtToken = jwtTokenService.generateToken(authentication);
        Long expiresAt = jwtTokenService.extractExpirationTime(jwtToken);
        
        var authResponse = new AuthResponse(jwtToken, authentication.getName(), expiresAt);

        // 6. Retornar la respuesta unificada
        return new RegisterResponse(userResponse, authResponse);  
    }

    public UserResponse findById(UUID id) {
    return userRepository.findById(id)
        .map(user -> new UserResponse(
            user.getId(), 
            user.getUsername(), 
            user.getEmail(), 
            user.getFirstname(), // Asegúrate de que coincida con el nombre en tu entidad (ej. firstname o firstName)
            user.getLastname(),
            user.getWhatsappNumber(),
            user.getUrlImage(),
            user.getUniqueNameImage()
        ))
        .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado con el ID: " + id));
}
}