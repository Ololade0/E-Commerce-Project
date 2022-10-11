package africa.semicolon.lumexpress.data.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.MappedSuperclass;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@MappedSuperclass
public class LumExpressUser {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phoneNumber;
    private String imageUrl;
    private boolean isEnabled;
    private List<Notification> messages = new ArrayList<>();
}

