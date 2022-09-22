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
public class Admin extends LumExpressUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ElementCollection
    private Set<Authority> authorities;

}
