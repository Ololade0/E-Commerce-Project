package africa.semicolon.lumexpress.data.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateProductRequest {
    private String productName;
    private BigDecimal price;
    private String category;
    private int quantity;
    private MultipartFile image;
}
