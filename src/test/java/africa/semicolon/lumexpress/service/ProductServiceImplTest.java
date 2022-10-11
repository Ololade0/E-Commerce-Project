package africa.semicolon.lumexpress.service;

import africa.semicolon.lumexpress.data.dto.request.AddProductRequest;
import africa.semicolon.lumexpress.data.dto.request.GetAllItemstRequest;
import africa.semicolon.lumexpress.data.dto.request.UpdateProductRequest;
import africa.semicolon.lumexpress.data.dto.response.AddProductResponse;
import africa.semicolon.lumexpress.data.dto.response.UpdateProductResponse;
import africa.semicolon.lumexpress.data.model.Product;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jackson.jsonpointer.JsonPointer;
import com.github.fge.jackson.jsonpointer.JsonPointerException;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import com.github.fge.jsonpatch.RemoveOperation;
import com.github.fge.jsonpatch.ReplaceOperation;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
class ProductServiceImplTest {
    @Autowired
    private ProductServices productServices;
  private AddProductRequest addProductRequest;
  private AddProductResponse addProductResponse;

    @BeforeEach
    void setUp() throws IOException {
        Path path = Paths.get("/home/lolade/Downloads/peakmilk.jpeg");
        MultipartFile file = new MockMultipartFile("peak", Files.readAllBytes(path));

        addProductRequest = AddProductRequest
                .builder().productName("Milk")
                .category("Beverages")
                .price(BigDecimal.valueOf(30.0))
                .quantity(10)
                .image(file)
                .build();
    }

    @Test
    void addProductTest() throws IOException {
        AddProductResponse addProductResponse =    productServices.addProduct(addProductRequest);
        assertThat(addProductResponse).isNotNull();
        assertThat(addProductResponse.getProductId()).isGreaterThan(0L);
        assertThat(addProductResponse.getMessage()).isNotNull();
        assertThat(addProductResponse.getCode()).isEqualTo(201);
    }

    @Test
    void updateProductDetails() throws IOException, JsonPointerException, JsonPatchException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode value = mapper.readTree("10.00");
        JsonPatch patch = new JsonPatch(List.of(new ReplaceOperation(new JsonPointer("/price"), value)));


        UpdateProductResponse updateResponse = productServices.updateProductDetails(1L, patch);
        assertThat(updateResponse).isNotNull();
        assertThat(updateResponse.getStatusCode()).isEqualTo(201);
     //   assertThat(productServices.getProductById(1L).getPrice()).isEqualTo(10.00);

    }
//private UpdateProductRequest buildUpdateRequest(){
//        return UpdateProductRequest
//                .builder().price(BigDecimal.valueOf(40.0))
//                .description("its just a milo")
//                .quantity(10)
//                .productId(1L)
//                .build();
//}


    @Test
    void getOneProductById() throws IOException {
        var response =
        productServices.addProduct(addProductRequest);
        Product foundProduct = productServices.getProductById(response.getProductId());
        assertThat(foundProduct).isNotNull();
        assertThat(foundProduct.getId()).isEqualTo(response.getProductId());
    }

    @Test
    void getAllProducts() throws IOException {
        productServices.addProduct(addProductRequest);
        var getAllItemstRequest = buildGetItemRequest();
        Page<Product> productPage = productServices.getAllProducts(getAllItemstRequest);
        log.info("page contents::{}", productPage);
        assertThat(productPage).isNotNull();
        assertThat(productPage.getTotalElements()).isGreaterThan(0);
    }
    private GetAllItemstRequest buildGetItemRequest(){
        return GetAllItemstRequest
                .builder().numberOfItemsProductsPerPage(8)
                .pageNumber(1)
                .build();
    }

    @Test
    void deleteProduct() {
    }
}