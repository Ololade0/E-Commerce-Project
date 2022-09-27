package africa.semicolon.lumexpress.data.dto.request;

import africa.semicolon.lumexpress.data.model.Address;
import lombok.*;

import javax.persistence.Entity;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerRegisterRequest {
    private String country;
    private String email;
    private String password;
    private Address address;


}
