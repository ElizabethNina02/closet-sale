package coreclosetsale.closet_sale.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import coreclosetsale.closet_sale.models.Province;

public interface ProvinceRepository extends JpaRepository<Province, Integer> {

    @Query(value = "SELECT * FROM provinces WHERE department_id = :id", nativeQuery = true)
    List<Province> findByDepartmentId(@Param("id") Integer id);
}
