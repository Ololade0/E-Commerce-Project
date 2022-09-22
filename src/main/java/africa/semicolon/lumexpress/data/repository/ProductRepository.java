package africa.semicolon.lumexpress.data.repository;

import africa.semicolon.lumexpress.data.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
