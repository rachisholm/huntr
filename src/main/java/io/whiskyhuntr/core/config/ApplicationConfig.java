package io.whiskyhuntr.core.config;

import com.netflix.config.ConfigurationManager;
import com.netflix.config.DynamicPropertyFactory;
import com.netflix.config.DynamicStringProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.io.IOException;

@Configuration
@Slf4j
public class ApplicationConfig {

    public static String getUser(){
        return getStringConfig("auth.user.name", "roots");
    }

    public static String getPassword(){
        return getStringConfig("auth.user.password", "platform");
    }

    public static String getStringConfig(String key, String defaultValue){
        final DynamicStringProperty property = DynamicPropertyFactory.getInstance().getStringProperty(key,
                defaultValue);
        return property.get();
    }


}
