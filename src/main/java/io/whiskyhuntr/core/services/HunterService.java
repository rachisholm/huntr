package io.whiskyhuntr.core.services;

import io.swagger.annotations.Api;
import io.whiskyhuntr.core.resources.HunterResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value="hunter", description="happy hunting")
public class HunterService implements HunterResource{

    public String get(){
        return "Greetings from Spring Boot!";

    }
}
