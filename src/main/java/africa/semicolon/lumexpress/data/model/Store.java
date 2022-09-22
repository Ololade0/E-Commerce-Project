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
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @OneToMany(fetch = FetchType.LAZY)
    private Set<Product> products ;
}
