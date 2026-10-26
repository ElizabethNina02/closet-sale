package coreclosetsale.closet_sale.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import coreclosetsale.closet_sale.models.District;

public interface DistrictRepository  extends JpaRepository<District, Integer> {
    @Query(value = "SELECT * FROM districts WHERE department_id = :id", nativeQuery = true)
    List<District> findByDepartmentId(@Param("id") Integer id);
}
