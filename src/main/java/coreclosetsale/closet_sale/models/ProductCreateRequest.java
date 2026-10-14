package coreclosetsale.closet_sale.models;

import java.math.BigDecimal;
import java.util.UUID;


public class ProductCreateRequest {
    private String titulo;
    private BigDecimal precio;
    private ConditionProduct condicion;
    private StatusProduct estado;
    private UUID categoriaId;
    private Long vendedorId;
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
    public Long getVendedorId() {
        return vendedorId;
    }
    public void setVendedorId(Long vendedorId) {
        this.vendedorId = vendedorId;
    }

}
