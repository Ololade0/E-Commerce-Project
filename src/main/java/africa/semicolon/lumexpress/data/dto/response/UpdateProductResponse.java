package africa.semicolon.lumexpress.data.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
@Setter
@Getter
@Builder
public class UpdateProductResponse {
    private String message;
    private int statusCode;
    private String productName;
    private String description;
    private BigDecimal price;


}
