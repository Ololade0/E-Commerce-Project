package africa.semicolon.lumexpress.service.cloud;

import com.cloudinary.Cloudinary;

import com.cloudinary.utils.ObjectUtils;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;
@Service
@AllArgsConstructor
public class CloudinaryServiceImpl implements CloudService {

    private final Cloudinary cloudinary ;

    @Override
    public String upload(byte[] imageBytes, Map<?, ?> map) throws IOException {
        var uploadResponse = cloudinary.uploader().upload(imageBytes, ObjectUtils.emptyMap());
        return uploadResponse.get("url").toString();
    }

}


