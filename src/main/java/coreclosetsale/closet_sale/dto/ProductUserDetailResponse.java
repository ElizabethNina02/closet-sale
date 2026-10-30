package coreclosetsale.closet_sale.dto;

public record ProductUserDetailResponse (
    ProductResponse product,
    String firstName,
    String lastName,
    String urlImage,
    String districtName, 
    String provinceName, 
    String departmentName,
    String whatsappNumber
){}
