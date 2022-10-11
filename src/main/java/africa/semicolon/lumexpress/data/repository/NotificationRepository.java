package africa.semicolon.lumexpress.data.repository;

import africa.semicolon.lumexpress.data.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {
}
