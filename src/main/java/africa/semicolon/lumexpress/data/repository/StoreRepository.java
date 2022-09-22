package africa.semicolon.lumexpress.data.repository;

import africa.semicolon.lumexpress.data.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, Long> {
}
