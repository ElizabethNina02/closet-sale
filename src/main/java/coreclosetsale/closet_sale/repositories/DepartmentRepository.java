package coreclosetsale.closet_sale.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import coreclosetsale.closet_sale.models.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
    
}
