package coreclosetsale.closet_sale.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import coreclosetsale.closet_sale.dto.DistrictDetail;
import coreclosetsale.closet_sale.models.District;

public interface DistrictRepository  extends JpaRepository<District, Integer> {
    @Query(value = "SELECT * FROM districts WHERE province_id = :id", nativeQuery = true)
    List<District> findByProvinceId(@Param("id") Integer id);

    @Query(value = "SELECT d.id AS 'districtId', d.name as 'districtName', p.name as 'provinceName', dd.name as 'departmentName' FROM districts d INNER JOIN provinces p ON d.province_id = p.id INNER JOIN departments dd on p.department_id = dd.id WHERE d.id = :id", nativeQuery = true)
    DistrictDetail getDistrictDetail(@Param("id") Integer id);
}
