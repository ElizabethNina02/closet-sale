package coreclosetsale.closet_sale.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import coreclosetsale.closet_sale.models.ProductFile;

public interface ProductFileRepository extends JpaRepository<ProductFile, UUID> {

    
} 
