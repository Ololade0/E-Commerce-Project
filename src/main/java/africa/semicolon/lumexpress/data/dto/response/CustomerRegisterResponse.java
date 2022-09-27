package africa.semicolon.lumexpress.data.dto.response;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerRegisterResponse {
    private String message;
    private int code;
    private Long userId;
}
