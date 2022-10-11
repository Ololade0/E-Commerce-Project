package africa.semicolon.lumexpress.data.repository;

import africa.semicolon.lumexpress.data.model.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface VerificationTokenRepository extends JpaRepository<VerificationToken, Long> {
    //  Optional<VerificationToken> findByToken(String token);
    Optional<VerificationToken> findByUserEmail(String userEmail);

    //  Optional<VerificationToken> findBYToken(String token);
    Optional<VerificationToken> findByToken(String token);


}
