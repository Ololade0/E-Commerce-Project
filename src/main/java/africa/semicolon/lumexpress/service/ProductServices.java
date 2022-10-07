package africa.semicolon.lumexpress.service;

import africa.semicolon.lumexpress.data.dto.request.AddProductRequest;
import africa.semicolon.lumexpress.data.dto.request.GetAllItemstRequest;
import africa.semicolon.lumexpress.data.dto.request.UpdateProductRequest;
import africa.semicolon.lumexpress.data.dto.response.AddProductResponse;
import africa.semicolon.lumexpress.data.dto.response.UpdateProductResponse;
import africa.semicolon.lumexpress.data.model.Product;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import org.springframework.data.domain.Page;

import java.io.IOException;

public interface ProductServices {
    AddProductResponse addProduct(AddProductRequest createProductRequest) throws IOException;
    UpdateProductResponse updateProductDetails(Long productId, JsonPatch patch) throws JsonProcessingException, JsonPatchException;
    Product getProductById(Long id);
    Page<Product> getAllProducts(GetAllItemstRequest getAllItemstRequest);
    String deleteProduct(Long id);

}
