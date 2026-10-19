package coreclosetsale.closet_sale.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import coreclosetsale.closet_sale.models.ConditionProduct;
import coreclosetsale.closet_sale.models.StatusProduct;

public record ProductResponse(
    UUID id,
    Long vendedorId,      // Asumiendo que el User también usa UUID
    String titulo,
    String descripcion,
    ConditionProduct condicion,
    BigDecimal precio,
    StatusProduct estado,
    UUID categoriaId,
    List<ProductFileResponse> files
) {}
