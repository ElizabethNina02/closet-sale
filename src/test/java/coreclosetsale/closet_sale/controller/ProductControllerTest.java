package coreclosetsale.closet_sale.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import coreclosetsale.closet_sale.models.Product;
import coreclosetsale.closet_sale.models.ProductCreateRequest;
import coreclosetsale.closet_sale.repositories.ProductRepository;
import coreclosetsale.closet_sale.repositories.UserRepository;
import coreclosetsale.closet_sale.services.ProductServiceImpl;

@ExtendWith(MockitoExtension.class) // Habilita el uso de Mockito en JUnit 5
public class ProductControllerTest {
    @Mock
    private UserRepository userRepository;

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImpl productService; // La clase que implementa tu interfaz

    @Test
    public void testCreateProduct_Exitoso() {
        // 1. ARRANGES (Preparación de datos ficticios)
        UUID vendedorId = UUID.randomUUID();
    }
       
}
