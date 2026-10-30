package coreclosetsale.closet_sale.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import coreclosetsale.closet_sale.dto.DistrictDetail;
import coreclosetsale.closet_sale.dto.ProductFileResponse;
import coreclosetsale.closet_sale.dto.ProductResponse;
import coreclosetsale.closet_sale.dto.ProductUserDetailResponse;
import coreclosetsale.closet_sale.models.Category;
import coreclosetsale.closet_sale.models.Product;
import coreclosetsale.closet_sale.models.ProductCreateRequest;
import coreclosetsale.closet_sale.models.ProductFile;
import coreclosetsale.closet_sale.models.ProductFileCreateRequest;
import coreclosetsale.closet_sale.models.User;
import coreclosetsale.closet_sale.repositories.CategoryRepository;
import coreclosetsale.closet_sale.repositories.DistrictRepository;
import coreclosetsale.closet_sale.repositories.ProductRepository;
import coreclosetsale.closet_sale.repositories.UserRepository;
import jakarta.transaction.Transactional;


@Service 
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;
    private final DistrictRepository districtRepository;

    ProductServiceImpl(ProductRepository repository, UserRepository userRepository, CategoryRepository categoryRepository, DistrictRepository districtRepository) {
        this.productRepository = repository;
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
        this.districtRepository = districtRepository;
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
        product.setDescripcion(request.getDescripcion());

        Category category = categoryRepository.getReferenceById(request.getCategoriaId());
        product.setCategoria(category);

        // 2. Vinculamos el Vendedor de forma óptima usando solo su ID
        // getReferenceById() crea un Proxy ligero con el ID, cumpliendo con la estructura orientada a objetos de JPA.
        User vendedorProxy = userRepository.getReferenceById(request.getVendedorId());
        product.setVendedorId(vendedorProxy);

        for (ProductFileCreateRequest fileRequest : request.getFiles() != null
                ? request.getFiles()
                : new ProductFileCreateRequest[0]) {
            ProductFile productFile = new ProductFile();
            productFile.setId(UUID.randomUUID());
            productFile.setUrl(fileRequest.getUrl());
            productFile.setFileOrder(fileRequest.getFileOrder());
            productFile.setUniqueName(fileRequest.getUniqueName());
            productFile.setProductId(product);

            
            if (product.getFiles() == null) {
                product.setFiles(new ArrayList<>());
            }
            product.getFiles().add(productFile);
        }

        // 3. Guardamos en SQL Server
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(UUID id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<ProductResponse> getAllProducts() {
        return productRepository.findAll().stream()
             .map((Product product) -> new ProductResponse(
            product.getId(),
            product.getVendedorId() != null ? product.getVendedorId().getId() : null,
            product.getTitulo(),
            product.getDescripcion(),
            product.getCondicion(),
            product.getPrecio(),
            product.getEstado(),
            product.getCategoriaId() != null ? product.getCategoriaId().getId() : null,
            product.getFiles() != null ? product.getFiles().stream()
                .map((ProductFile file) -> new ProductFileResponse(
                    file.getId(),
                    file.getUrl(),
                    file.getFileOrder(),
                    file.getUniqueName()
                )).toList() : List.of()
        ))
        .toList();
    }

    @Override
    public ProductUserDetailResponse getProductById(UUID id) {

        Product product = productRepository.findById(id).get();
        DistrictDetail detaill = districtRepository.getDistrictDetail(product.getVendedorId().getDistrict().getId());


        return new ProductUserDetailResponse(
          new ProductResponse(
            product.getId(),
            product.getVendedorId() != null ? product.getVendedorId().getId() : null,
            product.getTitulo(),
            product.getDescripcion(),
            product.getCondicion(),
            product.getPrecio(),
            product.getEstado(),
            product.getCategoriaId() != null ? product.getCategoriaId().getId() : null,
            product.getFiles() != null ? product.getFiles().stream()
                .map((ProductFile file) -> new ProductFileResponse(
                    file.getId(),
                    file.getUrl(),
                    file.getFileOrder(),
                    file.getUniqueName()
                )).toList() : List.of()
            ),
            product.getVendedorId().getFirstName(),
            product.getVendedorId().getLastName(),
            product.getVendedorId().getUrlImage(),
            detaill.districtName(),
            detaill.provinceName(),
            detaill.departmentName(),
            product.getVendedorId().getWhatsappNumber()
        );
    }

    @Override
    public Product updateProduct(UUID id, ProductCreateRequest product) {
        Optional<Product> existingProduct = productRepository.findById(id);
        if(existingProduct.isPresent()){
            Product updatedProduct = existingProduct.get();
            updatedProduct.setDescripcion(product.getDescripcion());
            updatedProduct.setCondicion(product.getCondicion());
            updatedProduct.setEstado(product.getEstado());
            updatedProduct.setPrecio(product.getPrecio());
            updatedProduct.setTitulo(product.getTitulo());
            Category category = categoryRepository.getReferenceById(product.getCategoriaId());
            updatedProduct.setCategoria(category);

            // Si la lista de archivos actual está vacía o nula, inicializarla
            if (updatedProduct.getFiles() == null) {
                updatedProduct.setFiles(new ArrayList<>());
            } else {
                // Limpiamos los archivos existentes para reemplazarlos con los nuevos
                updatedProduct.getFiles().clear(); 
            }

            // Usamos la misma validación ternaria que tienes en tu método create
            for (ProductFileCreateRequest fileRequest : product.getFiles() != null
                    ? product.getFiles()
                    : new ProductFileCreateRequest[0]) {
                
                ProductFile productFile = new ProductFile();
                // Generamos un nuevo UUID para los archivos entrantes
                productFile.setId(UUID.randomUUID());
                productFile.setUrl(fileRequest.getUrl());
                productFile.setFileOrder(fileRequest.getFileOrder());
                productFile.setUniqueName(fileRequest.getUniqueName());
                
                // 👈 Usamos tu método asignando el objeto updatedProduct completo
                productFile.setProductId(updatedProduct); 

                // Agregamos el archivo mapeado a la lista del producto que se va a guardar
                updatedProduct.getFiles().add(productFile);
            }
            
            return productRepository.save(updatedProduct);
        }
        return null;
    }
    
}
