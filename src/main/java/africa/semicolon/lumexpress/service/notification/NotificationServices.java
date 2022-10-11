package africa.semicolon.lumexpress.service.notification;

import africa.semicolon.lumexpress.data.dto.NotificationRequest;

public interface NotificationServices {
    String send(NotificationRequest request);
}
