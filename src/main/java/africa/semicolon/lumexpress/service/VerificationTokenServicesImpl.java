package africa.semicolon.lumexpress.service;

import africa.semicolon.lumexpress.data.model.VerificationToken;
import africa.semicolon.lumexpress.utils.LumExpressUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class VerificationTokenServicesImpl implements VerificationTokenServices{

    @Override
    public VerificationToken createToken(String userEmail) {
        String tokenString = LumExpressUtils.generateToken();
        VerificationToken verificationToken = VerificationToken.builder()
                .token(tokenString)
                .userEmail(userEmail)
                .createdAt(LocalDateTime.now())
                .expiresAt(LocalDateTime.now().plusMinutes(5))
                .build();

        return verificationToken;
    }


}
