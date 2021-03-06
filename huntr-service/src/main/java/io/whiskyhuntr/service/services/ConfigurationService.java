package io.whiskyhuntr.service.services;

import io.swagger.annotations.Api;
import io.whiskyhuntr.contracts.ConfigurationContract;
import io.whiskyhuntr.service.config.AppConfigurationManager;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value="configuration", description="configure the hunter")
public class ConfigurationService implements ConfigurationContract {

    public String getConfigValue(String key){
        return AppConfigurationManager.getStringConfig(key, "");
    }

    public String updateConfig(String key, String value){
        AppConfigurationManager.setConfig(key, value);
        return key;
    }
}
