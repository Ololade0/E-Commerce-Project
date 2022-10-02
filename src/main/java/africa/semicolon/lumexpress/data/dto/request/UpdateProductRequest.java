package africa.semicolon.lumexpress.data.dto.request;

import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class UpdateProductRequest {
    private BigDecimal price;
    private int quantity;
    private Long productId;
    private String description;
}
