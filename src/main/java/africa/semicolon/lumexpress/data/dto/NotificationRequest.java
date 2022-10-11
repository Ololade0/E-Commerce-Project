package africa.semicolon.lumexpress.data.dto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NotificationRequest {
    private Long userId;
    private String message;
}
