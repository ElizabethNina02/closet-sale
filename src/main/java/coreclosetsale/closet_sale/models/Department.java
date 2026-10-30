package coreclosetsale.closet_sale.models;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity 
@Table (name = "departments")
public class Department {
    @Id 
    @Column(name="id", updatable = false, nullable = false)
    private Integer id; 

    
    @Column(name = "name", nullable = false, length = 100)
    private String name;

    
    @Column(name = "country_Id", nullable = false, length = 100)
    private UUID countryId;

    
    @OneToMany(mappedBy = "departmentId", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Province> provinces;


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


    public UUID getCountryId() {
        return countryId;
    }


    public void setCountryId(UUID countryId) {
        this.countryId = countryId;
    }


    public List<Province> getProvinces() {
        return provinces;
    }


    public void setProvinces(List<Province> provinces) {
        this.provinces = provinces;
    }


    
}
