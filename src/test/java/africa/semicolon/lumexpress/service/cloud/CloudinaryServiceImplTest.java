package africa.semicolon.lumexpress.service.cloud;

;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class CloudinaryServiceImplTest {
    @Autowired
    private CloudService cloudService ;

  private   MultipartFile file ;

    @BeforeEach
    void setUp() throws IOException {
        Path path = Paths.get("/home/lolade/Downloads/peakmilk.jpeg");
         file = new MockMultipartFile("peak", Files.readAllBytes(path));
    }
    @Test
    @DisplayName("Cloudinary upload test")
    public  void  uploadTest(){
        try{
            String response =
            cloudService.upload(file.getBytes(), null);
            assertThat(response).isNotNull();

        }catch (IOException exception){
            exception.printStackTrace();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}