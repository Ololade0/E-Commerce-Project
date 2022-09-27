package africa.semicolon.lumexpress.data.repository;

import africa.semicolon.lumexpress.data.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
