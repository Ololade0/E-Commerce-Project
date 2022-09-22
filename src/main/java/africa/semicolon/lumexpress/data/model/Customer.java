package africa.semicolon.lumexpress.data.model;

import lombok.*;


import javax.persistence.*;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Customer extends LumExpressUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne
    private Cart cart;
    @OneToMany(fetch = FetchType.EAGER)
    private Set<Address> address;
}
