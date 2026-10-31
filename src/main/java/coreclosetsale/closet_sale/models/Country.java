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
@Table (name = "countries")
public class Country {
    @Id 
    @Column(name="id", updatable = false, nullable = false,columnDefinition = "uuid")
    private UUID id;

    
    @Column(name = "name", nullable = false, length = 100)
    private String name;


    @Column(name = "nationality", nullable = false, length = 100)
    private String nationality;

    @OneToMany(mappedBy = "countryId", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Department> departments;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
}
