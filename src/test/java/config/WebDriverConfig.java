package config;

import org.aeonbits.owner.Config;

import java.net.URL;

@Config.Sources("classpath:${localOrRemove}.properties")
public interface WebDriverConfig extends Config {

    @Key("browserName")//читаем значение
    @DefaultValue("chrome")//обрабатываем дефолтное
    String browserName();//конвертируем результат

    @Key("browserVersion")//читаем значение
    @DefaultValue("100.0")//обрабатываем дефолтное
    String browserVersion();//конвертируем результат

    @Key("isRemote")
    @DefaultValue("false")
    boolean isRemote();

    @Key("baseUrl")//читаем значение
    @DefaultValue("https://github.com")//обрабатываем дефолтное
    String baseUrl();//конвертируем результат

    @Key("remoteUrl")
    String remoteUrl();

}
