package africa.semicolon.lumexpress.service.cloud;

import java.io.IOException;
import java.util.Map;

public interface CloudService {
    String upload(byte[] imageBytes, Map<?, ?> map) throws IOException;
}
