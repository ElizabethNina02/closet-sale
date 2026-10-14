package coreclosetsale.closet_sale.dto;


public record AuthResponse(String token, String username, Long expiresAt) {}
