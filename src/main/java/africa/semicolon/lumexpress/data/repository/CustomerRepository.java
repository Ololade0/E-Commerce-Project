package africa.semicolon.lumexpress.data.repository;

import africa.semicolon.lumexpress.data.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
