package coreclosetsale.closet_sale.controllers;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import coreclosetsale.closet_sale.dto.RegisterRequest;
import coreclosetsale.closet_sale.dto.RegisterResponse;
import coreclosetsale.closet_sale.dto.UserResponse;
import coreclosetsale.closet_sale.services.UserService;
import jakarta.validation.Valid;

@RestController
@RequestMapping ("/api/auth")
// Permite que tu aplicación de React (asumiendo puerto 5173 o 3000) pueda consumir el endpoint sin bloqueos de CORS
@CrossOrigin (origins = "*") 
public class UserController {

    private final UserService userService;

    // Inyección de dependencias por constructor
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping ("/register")
    public ResponseEntity<RegisterResponse> registerUser(@Valid @RequestBody RegisterRequest registerRequest) {
        // Ejecuta el servicio y retorna un estado HTTP 201 Created junto con la data segura
        RegisterResponse response = userService.register(registerRequest);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // Captura excepciones de tipo IllegalArgumentException (como la del usuario duplicado)
    @ExceptionHandler (IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException ex) {
        // Retorna un HTTP 400 Bad Request con el mensaje exacto definido en tu servicio
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable UUID id) {
        UserResponse response = userService.findById(id);
        return ResponseEntity.ok(response); // Retorna HTTP 200 OK con los datos del usuario
    }
}
