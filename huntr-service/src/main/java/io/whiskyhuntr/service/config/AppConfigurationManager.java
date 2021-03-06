package io.whiskyhuntr.service.config;

import com.netflix.config.ConcurrentCompositeConfiguration;
import com.netflix.config.ConfigurationManager;
import com.netflix.config.DynamicPropertyFactory;
import com.netflix.config.DynamicStringProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.io.IOException;

@Configuration
@Slf4j
@Qualifier("appConfig")
public class AppConfigurationManager {
    @PostConstruct
    public void init(){
        //Load auth properties manually
        try {
            ConfigurationManager.loadCascadedPropertiesFromResources("auth");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static String getUser(){
        return getStringConfig("auth.user.name", "roots");
    }

    public static String getPassword(){
        return getStringConfig("auth.user.password", "platform");
    }

    public static String getStringConfig(String key){
        return getStringConfig(key, null);
    }

    public static String getStringConfig(String key, String defaultValue){
        final DynamicStringProperty property = DynamicPropertyFactory.getInstance().getStringProperty(key,
                defaultValue);
        return property.get();
    }

    public static void setConfig(String key, Object value){
        ((ConcurrentCompositeConfiguration) ConfigurationManager
                .getConfigInstance()).setOverrideProperty(key, value);
    }


}
