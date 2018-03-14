package io.whiskyhuntr.core.config;

import com.netflix.config.AbstractPollingScheduler;
import com.netflix.config.ConcurrentCompositeConfiguration;
import com.netflix.config.ConfigurationManager;
import com.netflix.config.DynamicPropertyFactory;
import com.netflix.config.DynamicStringProperty;
import com.netflix.config.FixedDelayPollingScheduler;
import com.netflix.config.PolledConfigurationSource;
import com.netflix.config.sources.URLConfigurationSource;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.configuration.AbstractConfiguration;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.io.IOException;

@Configuration
@Slf4j
@Qualifier("appConfig")
public class AppConfigurationManager {


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

    public static void setConfig(String key, Object value){
        ((ConcurrentCompositeConfiguration) ConfigurationManager
                .getConfigInstance()).setOverrideProperty(key, value);
    }


}
