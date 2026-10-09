package coreclosetsale.closet_sale.services;

import java.util.List;
import java.util.UUID;

import coreclosetsale.closet_sale.models.Product;
import coreclosetsale.closet_sale.models.ProductCreateRequest;

public interface ProductService {
    List<Product> getAllProducts();
    Product getProductById(UUID id);
    Product createProduct(ProductCreateRequest product);
    Product updateProduct(UUID id, Product product);
    void deleteProduct(UUID id);
}
