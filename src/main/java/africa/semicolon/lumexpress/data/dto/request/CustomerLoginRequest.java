package africa.semicolon.lumexpress.data.dto.request;

import africa.semicolon.lumexpress.data.model.Address;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerLoginRequest {
    private String email;
    private String password;


}
