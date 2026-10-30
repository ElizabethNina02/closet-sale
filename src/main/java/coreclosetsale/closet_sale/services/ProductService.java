package coreclosetsale.closet_sale.services;

import java.util.List;
import java.util.UUID;

import coreclosetsale.closet_sale.dto.ProductResponse;
import coreclosetsale.closet_sale.dto.ProductUserDetailResponse;
import coreclosetsale.closet_sale.models.Product;
import coreclosetsale.closet_sale.models.ProductCreateRequest;

public interface ProductService {
    List<ProductResponse> getAllProducts();
    ProductUserDetailResponse getProductById(UUID id);
    Product createProduct(ProductCreateRequest product);
    Product updateProduct(UUID id, ProductCreateRequest product);
    void deleteProduct(UUID id);
}
