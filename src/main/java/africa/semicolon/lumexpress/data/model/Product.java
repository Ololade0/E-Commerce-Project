package africa.semicolon.lumexpress.data.model;

import lombok.*;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.List;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder

public class Product {
    @Id
    private Long id;
    private String name;
    private BigDecimal price;
    private int quantity;

    @ElementCollection
    private List<Category> category;
    private String imageUrl;
}
