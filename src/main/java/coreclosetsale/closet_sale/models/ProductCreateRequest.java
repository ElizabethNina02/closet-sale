package coreclosetsale.closet_sale.models;

import java.math.BigDecimal;
import java.util.UUID;


public class ProductCreateRequest {
    private String titulo;
    private String descripcion;
    private BigDecimal precio;
    private ConditionProduct condicion;
    private StatusProduct estado;
    private UUID categoriaId;
    private UUID vendedorId;
    private ProductFileCreateRequest[] files; // Array de archivos asociados al producto

    public String getTitulo() {
        return titulo;
    }
    public BigDecimal getPrecio() {
        return precio;
    }
    public ConditionProduct getCondicion() {
        return condicion;
    }
    public StatusProduct getEstado() {
        return estado;
    } 
    
    public UUID getCategoriaId() {
        return categoriaId;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }
    public void setCondicion(ConditionProduct condicion) {
        this.condicion = condicion;
    }
    public void setEstado(StatusProduct estado) {
        this.estado = estado;
    }
    public void setCategoriaId(UUID categoriaId) {
        this.categoriaId = categoriaId;
    }
    public UUID getVendedorId() {
        return vendedorId;
    }
    public void setVendedorId(UUID vendedorId) {
        this.vendedorId = vendedorId;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public ProductFileCreateRequest[] getFiles() {
        return files;
    }
    public void setFiles(ProductFileCreateRequest[] files) {
        this.files = files;
    }
}
