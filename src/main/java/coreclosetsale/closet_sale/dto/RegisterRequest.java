package coreclosetsale.closet_sale.dto;

public record RegisterRequest(String username, String email, String password, String firstName, String lastName, String whatsappNumber, String urlImage, String uniqueNameImage, Integer districtId ) {}

