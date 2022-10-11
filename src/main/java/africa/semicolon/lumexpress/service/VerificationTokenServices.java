package africa.semicolon.lumexpress.service;

import africa.semicolon.lumexpress.data.model.VerificationToken;

public interface VerificationTokenServices {
    VerificationToken createToken(String userEmail);
}
