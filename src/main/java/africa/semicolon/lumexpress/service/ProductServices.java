package africa.semicolon.lumexpress.service;

import africa.semicolon.lumexpress.data.dto.request.AddProductRequest;
import africa.semicolon.lumexpress.data.dto.request.UpdateProductRequest;
import africa.semicolon.lumexpress.data.dto.response.AddProductResponse;
import africa.semicolon.lumexpress.data.model.Product;
import org.springframework.data.domain.Page;

import java.io.IOException;

public interface ProductServices {
    AddProductResponse addProduct(AddProductRequest createProductRequest) throws IOException;
    String updateProductDetails(UpdateProductRequest updateProductRequest);
    Product getProductById(Long id);
    Page<Product> getAllProducts();
    String deleteProduct(Long id);

}
