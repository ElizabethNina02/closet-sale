package coreclosetsale.closet_sale.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import coreclosetsale.closet_sale.models.Category;

public interface CategoryRepository extends JpaRepository<Category, UUID> {
    Optional<Category> findById(UUID id);
}
