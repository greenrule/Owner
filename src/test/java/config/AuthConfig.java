package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "file:C:/Users/Marina/IdeaProjects/auth.properties",
        "classpath:auth.properties"
})

public interface AuthConfig extends Config {

    @Key("baseurl")
    String baseurl();

    @Key("token")
    String token();
}
