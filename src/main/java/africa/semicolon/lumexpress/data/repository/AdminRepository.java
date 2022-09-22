package africa.semicolon.lumexpress.data.repository;

import africa.semicolon.lumexpress.data.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
}
