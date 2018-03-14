package core.services;

import io.swagger.annotations.Api;
import io.whiskyhuntr.contracts.HunterContract;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value="hunter", description="happy hunting")
public class HunterService implements HunterContract {

    public String get(){
        return "Greetings from Spring Boot!";

    }
}
