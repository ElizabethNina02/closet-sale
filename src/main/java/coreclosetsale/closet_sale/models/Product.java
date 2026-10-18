package coreclosetsale.closet_sale.models;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity 
@Table (name = "products")
public class Product {
    @Id 
    @Column(name="id", updatable = false, nullable = false,columnDefinition = "UNIQUEIDENTIFIER")
    private UUID id; 

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vendedor_id", nullable = false)
    private User vendedorId;

    // Relación con la Categoría
   /*  @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoria_id", nullable = false)
    private Categoria categoria;

    // Relación con la Marca
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "marca_id", nullable = false)
    private Marca marca;*/

    @Column(name = "titulo", nullable = false, length = 155)
    private String titulo;

    @Column(name = "descripcion", nullable = false, length = 255)
    private String descripcion;

    @Enumerated(EnumType.STRING)
    @Column(name = "condicion", nullable = false)
    private ConditionProduct condicion; // Nuevo, Usado, etc.

    @Column(name = "precio", nullable = false, precision = 10, scale = 2)
    private BigDecimal precio; // Mapea mejor el tipo 'numeric' de SQL

    @Enumerated(EnumType.STRING)
    @Column(name = "estado", nullable = false)
    private StatusProduct estado;

    @ManyToOne(fetch = FetchType.LAZY) 
    @JoinColumn(name = "category_id", nullable = false) 
    private Category categoriaId;

    @OneToMany(mappedBy = "productId", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference // Parte complementaria para serializar el JSON de forma limpia
    private List<ProductFile> files;

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setCondicion(ConditionProduct condicion) {
        this.condicion = condicion;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public void setEstado(StatusProduct estado) {
        this.estado = estado;
    }

    public String getTitulo() {
        return titulo;
    }

    public ConditionProduct getCondicion() {
        return condicion;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public StatusProduct getEstado() {
        return estado;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public void setVendedorId(User vendedorId) {
        this.vendedorId = vendedorId;
    }

    public void setCategoria(Category categoria) {
        this.categoriaId = categoria;
    }
    

    public List<ProductFile> getFiles() {
        return files;
    }

    public void setFiles(List<ProductFile> files) {
        this.files = files;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
