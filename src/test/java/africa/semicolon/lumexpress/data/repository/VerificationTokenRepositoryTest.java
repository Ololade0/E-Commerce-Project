package africa.semicolon.lumexpress.data.repository;

import africa.semicolon.lumexpress.data.model.VerificationToken;
import africa.semicolon.lumexpress.exception.VerificationTokenException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Slf4j
class VerificationTokenRepositoryTest {
    @Autowired
    private VerificationTokenRepository verificationTokenRepository;
    private VerificationToken verificationToken;

    @BeforeEach
    void setUp() {
        verificationToken = new VerificationToken();
        verificationToken.setToken("12345");
        verificationToken.setUserEmail("test@gmail.com");
        verificationTokenRepository.deleteAll();
    }
    @Test
     void findUserEmail(){
        verificationTokenRepository.save(verificationToken);
        VerificationToken foundVerificationToken  = verificationTokenRepository
                .findByUserEmail(verificationToken.getUserEmail())
                .orElseThrow(()-> new VerificationTokenException("Token not found. "));
        log.info("found token :: {}", foundVerificationToken);
        assertThat(foundVerificationToken).isNotNull();
        assertThat(foundVerificationToken.getToken()).isEqualTo(verificationToken.getToken());
    }

    @Test
    void findByTokenTest(){
        verificationTokenRepository.save(verificationToken);
       var  token = verificationTokenRepository.findByToken(verificationToken.getToken())
                .orElseThrow(()-> new VerificationTokenException("Token cannot be found"));
        log.info("found token ::{}", token);
        assertThat(token).isNotNull();
        assertThat(token.getToken()).isEqualTo("12345");


    }
}