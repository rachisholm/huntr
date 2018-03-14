package io.whiskyhuntr.core.services;

import io.swagger.annotations.Api;
import io.whiskyhuntr.core.config.AppConfigurationManager;
import io.whiskyhuntr.core.resources.ConfigurationResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value="configuration", description="configure the hunter")
public class ConfigurationService implements ConfigurationResource {

    public String getConfigValue(String key){
        return AppConfigurationManager.getStringConfig(key, "");
    }

    public String updateConfig(String key, String value){
        AppConfigurationManager.setConfig(key, value);
        return key;
    }
}
