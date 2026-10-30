package coreclosetsale.closet_sale.models;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity 
@Table (name = "districts")
public class District {
    @Id 
    @Column(name="id", updatable = false, nullable = false)
    private Integer id; 

    
    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "province_id", nullable = false)
    private Integer provinceId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    
    
}
