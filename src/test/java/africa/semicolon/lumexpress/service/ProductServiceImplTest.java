package africa.semicolon.lumexpress.service;

import africa.semicolon.lumexpress.data.dto.request.CreateProductRequest;
import africa.semicolon.lumexpress.data.dto.response.CreateProductResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ProductServiceImplTest {
    @Autowired
    private ProductServices productServices;
    CreateProductRequest createProductRequest;

    @BeforeEach
    void setUp() throws IOException {
        Path path = Paths.get("/home/lolade/Downloads/peakmilk.jpeg");
        MultipartFile file = new MockMultipartFile("peak", Files.readAllBytes(path));
        createProductRequest = CreateProductRequest
                .builder().productName("Milk")
                .category("Beverages")
                .price(BigDecimal.valueOf(30.0))
                .quantity(10).image(file)
                .build();
    }

    @Test
    void create() {
        CreateProductResponse createProductResponse =    productServices.create(createProductRequest);
        assertThat(createProductResponse).isNotNull();
        assertThat(createProductResponse.getProductId()).isGreaterThan(0L);
        assertThat(createProductResponse.getMessage()).isNotNull();
        assertThat(createProductResponse.getCode()).isEqualTo(201);
    }



    @Test
    void updateProductDetails() {
    }

    @Test
    void getAllProducts() {
    }

    @Test
    void deleteProduct() {
    }
}