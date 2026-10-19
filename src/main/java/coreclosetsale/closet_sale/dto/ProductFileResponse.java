package coreclosetsale.closet_sale.dto;

import java.util.UUID;

public record ProductFileResponse(
    UUID id,
    String url,
    int fileOrder,
    String uniqueName
){}
