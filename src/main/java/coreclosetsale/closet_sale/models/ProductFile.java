package coreclosetsale.closet_sale.models;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ProductFiles") // Evita llamarla 'file' a secas porque es palabra reservada en SQL
public class ProductFile {

    @Id 
    @Column(name="id", updatable = false, nullable = false,columnDefinition = "uuid")
    private UUID id; 

    @Column(nullable = false)
    private String url;


    @Column(nullable = false)
    private String uniqueName;
    

    @Column(name = "file_order", nullable = false) // 'order' es palabra reservada en SQL, mejor cambiar el nombre físico
    private int fileOrder;

    // Relación Muchos a Uno: Muchas fotos pertenecen a un Producto
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false) // Esta columna almacena la FK en SQL
    @JsonBackReference // Evita bucles infinitos en el JSON al serializar
    private Product productId;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getFileOrder() {
        return fileOrder;
    }

    public void setFileOrder(int fileOrder) {
        this.fileOrder = fileOrder;
    }

    public Product getProductId() {
        return productId;
    }

    public void setProductId(Product productId) {
        this.productId = productId;
    }

    public String getUniqueName() {
        return uniqueName;
    }

    public void setUniqueName(String uniqueName) {
        this.uniqueName = uniqueName;
    }

}
