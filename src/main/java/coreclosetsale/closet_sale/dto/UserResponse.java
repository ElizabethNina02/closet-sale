package coreclosetsale.closet_sale.dto;

import java.util.UUID;

public record UserResponse(UUID id, String username, String email, String firstName, String lastName, String whatsappNumber, String urlImage, String uniqueNameImage) {}