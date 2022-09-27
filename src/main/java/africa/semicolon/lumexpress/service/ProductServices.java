package africa.semicolon.lumexpress.service;

import africa.semicolon.lumexpress.data.dto.request.CreateProductRequest;
import africa.semicolon.lumexpress.data.dto.request.UpdateProductRequest;
import africa.semicolon.lumexpress.data.dto.response.CreateProductResponse;
import africa.semicolon.lumexpress.data.model.Product;

import java.util.List;

public interface ProductServices {
    CreateProductResponse create(CreateProductRequest createProductRequest) ;
    String updateProductDetails(UpdateProductRequest updateProductRequest);
    Product getProductById(Long id);
    List<Product> getAllProducts();
    String deleteProduct(Long id);

}
