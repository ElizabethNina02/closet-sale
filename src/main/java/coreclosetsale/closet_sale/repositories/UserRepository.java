package coreclosetsale.closet_sale.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import coreclosetsale.closet_sale.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}