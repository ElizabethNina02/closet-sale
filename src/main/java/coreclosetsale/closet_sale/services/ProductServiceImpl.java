package coreclosetsale.closet_sale.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import coreclosetsale.closet_sale.models.Category;
import coreclosetsale.closet_sale.models.Product;
import coreclosetsale.closet_sale.models.ProductCreateRequest;
import coreclosetsale.closet_sale.models.User;
import coreclosetsale.closet_sale.repositories.CategoryRepository;
import coreclosetsale.closet_sale.repositories.ProductRepository;
import coreclosetsale.closet_sale.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;


@Service 
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;

    ProductServiceImpl(ProductRepository repository, UserRepository userRepository, CategoryRepository categoryRepository) {
        this.productRepository = repository;
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    @Transactional 
    public Product createProduct(ProductCreateRequest request) {
        Product product = new Product();
        product.setId(UUID.randomUUID()); // Generamos el UUID en Java
        product.setTitulo(request.getTitulo());
        product.setPrecio(request.getPrecio());
        product.setCondicion(request.getCondicion());
        product.setEstado(request.getEstado());

        Category category = categoryRepository.getReferenceById(request.getCategoriaId());
        product.setCategoria(category);

        // 2. Vinculamos el Vendedor de forma óptima usando solo su ID
        // getReferenceById() crea un Proxy ligero con el ID, cumpliendo con la estructura orientada a objetos de JPA.
        User vendedorProxy = userRepository.getReferenceById(request.getVendedorId());
        product.setVendedorId(vendedorProxy);

        // 3. Guardamos en SQL Server
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(UUID id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(UUID id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Product updateProduct(UUID id, Product product) {
        Optional<Product> existingProduct = productRepository.findById(id);
        if(existingProduct.isPresent()){
            Product updatedProduct = existingProduct.get();
            updatedProduct.setCondicion(product.getCondicion());
            updatedProduct.setEstado(product.getEstado());
            updatedProduct.setPrecio(product.getPrecio());
            updatedProduct.setTitulo(product.getTitulo());
            return productRepository.save(updatedProduct);
        }
        return null;
    }
    
}
