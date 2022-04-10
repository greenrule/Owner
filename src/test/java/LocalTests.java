import config.WebDriverConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LocalTests {


    @Test
    public void localTest() {
        System.setProperty("localOrRemove", "local");

        WebDriverConfig config = ConfigFactory.create(WebDriverConfig.class, System.getProperties());
        assertThat(config.browserName()).isEqualTo("chrome");
        assertThat(config.browserVersion()).isEqualTo("100.0");
        assertThat(config.isRemote()).isEqualTo(false);
        assertThat(config.baseUrl()).isEqualTo("https://github.com");
        assertThat(config.remoteUrl()).isEqualTo("");
    }

    @Test
    public void remoteTest() {
        System.setProperty("localOrRemove", "remote");

        WebDriverConfig config = ConfigFactory.create(WebDriverConfig.class, System.getProperties());
        assertThat(config.browserName()).isEqualTo("chrome");
        assertThat(config.browserVersion()).isEqualTo("100.0");
        assertThat(config.isRemote()).isEqualTo(true);
        assertThat(config.baseUrl()).isEqualTo("https://github.com");
        assertThat(config.remoteUrl()).isEqualTo("https://user1:1234@selenoid.autotests.cloud/wd/hub");
    }
}
