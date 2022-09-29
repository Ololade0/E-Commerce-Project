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
//@AllArgsConstructor
public class CloudinaryServiceImpl implements CloudService {
//    @Value("${cloudinary.cloud.name}")
//    private final String CLOUD_NAME;
//
//    @Value("${cloudinary.api.key}")
//    private final  String API_KEY;
//
//    @Value("${cloudinary.api.secret}")
//    private final  String API_SECRET;


    private Cloudinary cloudinary = new Cloudinary(ObjectUtils
            .asMap("cloud_name",
                    "dykaxirq0", "api_key",
                    "223476997743328",
                    "api_secret", "6pFoSWZB34EC30rk5IS5iDRIhUg",
                    "secure", true));


    @Override
    public String upload(byte[] imageBytes, Map<?, ?> map) throws IOException {
        var uploadResponse = cloudinary.uploader().upload(imageBytes, ObjectUtils.emptyMap());
        return uploadResponse.get("url").toString();
    }

}


