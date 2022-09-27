package africa.semicolon.lumexpress.service;

import africa.semicolon.lumexpress.data.dto.request.CreateProductRequest;
import africa.semicolon.lumexpress.data.dto.request.UpdateProductRequest;
import africa.semicolon.lumexpress.data.dto.response.CreateProductResponse;
import africa.semicolon.lumexpress.data.model.Product;
import africa.semicolon.lumexpress.data.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
@Builder
public class ProductServiceImpl implements ProductServices {
    private final ProductRepository productRepository;


    @Override
    public CreateProductResponse create(CreateProductRequest createProductRequest) {

        return null;
    }

    @Override
    public String updateProductDetails(UpdateProductRequest updateProductRequest) {
        return null;
    }

    @Override
    public Product getProductById(Long id) {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public String deleteProduct(Long id) {
        return null;
    }
}
