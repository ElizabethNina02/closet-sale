package coreclosetsale.closet_sale.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import coreclosetsale.closet_sale.models.Product;

public interface ProductRepository extends JpaRepository<Product, UUID> {

    
} 