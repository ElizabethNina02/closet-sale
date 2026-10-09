package coreclosetsale.closet_sale.models;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class ProductCreateRequest {
    private String titulo;
    private BigDecimal precio;
    private ConditionProduct condicion;
    private StatusProduct estado;
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
    

}
