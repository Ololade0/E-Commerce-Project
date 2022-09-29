package africa.semicolon.lumexpress.service;

import africa.semicolon.lumexpress.data.dto.request.AddProductRequest;
import africa.semicolon.lumexpress.data.dto.response.AddProductResponse;
import africa.semicolon.lumexpress.data.model.Product;
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

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ProductServiceImplTest {
    @Autowired
    private ProductServices productServices;
    AddProductRequest createProductRequest;

    @BeforeEach
    void setUp() throws IOException {
        Path path = Paths.get("/home/lolade/Downloads/peakmilk.jpeg");
        MultipartFile file = new MockMultipartFile("peak", Files.readAllBytes(path));
        createProductRequest = AddProductRequest
                .builder().productName("Milk")
                .category("Beverages")
                .price(BigDecimal.valueOf(30.0))
                .quantity(10)
                .image(file)
                .build();
    }

    @Test
    void addProductTest() throws IOException {
        AddProductResponse addProductResponse =    productServices.addProduct(createProductRequest);
        assertThat(addProductResponse).isNotNull();
        assertThat(addProductResponse.getProductId()).isGreaterThan(0L);
        assertThat(addProductResponse.getMessage()).isNotNull();
        assertThat(addProductResponse.getCode()).isEqualTo(201);
    }



    @Test
    void updateProductDetails() {
    }


    @Test
    void getOneProductById() throws IOException {
        var response =
        productServices.addProduct(createProductRequest);
        Product foundProduct = productServices.getProductById(response.getProductId());
        assertThat(foundProduct).isNotNull();
        assertThat(foundProduct.getId()).isEqualTo(response.getProductId());
    }

    @Test
    void getAllProducts() throws IOException {
        Page<Product> productPage = productServices.getAllProducts();
        assertThat(productPage).isNotNull();
        assertThat(productPage.getTotalElements()).isGreaterThan(0);
    }

    @Test
    void deleteProduct() {
    }
}