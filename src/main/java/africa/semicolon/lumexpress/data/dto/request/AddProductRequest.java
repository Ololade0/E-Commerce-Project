package africa.semicolon.lumexpress.data.dto.request;

import lombok.*;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Validated
@Builder
@Setter
@Getter
public class AddProductRequest {
    private String productName;
    private BigDecimal price;
    private String category;
    private int quantity;
@NotNull
    private MultipartFile image;
}
