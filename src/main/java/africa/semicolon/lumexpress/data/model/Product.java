package africa.semicolon.lumexpress.data.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@ToString
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private BigDecimal price;
    private int quantity;
    private String description;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<Category> categories = new ArrayList<>();
    private String imageUrl;
}
