package africa.semicolon.lumexpress.data.dto.response;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class AddProductResponse {
    private Long productId;
    private String message;
    private int code;

}
