import config.AuthConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.assertThat;

public class AuthTest {
    Path props = Paths.get("C:/Users/Marina/IdeaProjects/auth.properties");

    @BeforeEach
    public void clearFile() throws Exception {
        Files.deleteIfExists(props);
    }

    @Test
    public void testLocalFile() {
        AuthConfig config = ConfigFactory.create(AuthConfig.class, System.getProperties());
        assertThat(config.baseurl()).isEqualTo("https://github.com");
        assertThat(config.token()).isEqualTo("123abc");
    }

    @Test
    public void testRemoteFile() throws Exception {
        String token = "baseurl=https://github.com\ntoken=555abc";

        Files.write(props, token.getBytes(StandardCharsets.UTF_8));
        AuthConfig config = ConfigFactory.create(AuthConfig.class, System.getProperties());

        assertThat(config.baseurl()).isEqualTo("https://github.com");
        assertThat(config.token()).isEqualTo("555abc");
    }
}
