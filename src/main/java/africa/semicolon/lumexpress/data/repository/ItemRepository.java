package africa.semicolon.lumexpress.data.repository;

import africa.semicolon.lumexpress.data.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
