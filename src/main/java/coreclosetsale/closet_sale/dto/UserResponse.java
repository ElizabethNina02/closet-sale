package coreclosetsale.closet_sale.dto;

import java.util.UUID;

import coreclosetsale.closet_sale.models.District;

public record UserResponse(UUID id, String username, String email, String firstName, String lastName, String whatsappNumber, String urlImage, String uniqueNameImage, String districtName, String provinceName, String departmentName) {}