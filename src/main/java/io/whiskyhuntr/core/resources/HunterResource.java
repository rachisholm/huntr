package io.whiskyhuntr.core.resources;


import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hunter")
@Api(value="hunter", description="happy hunting")
public class HunterResource {

    @RequestMapping(value = "/", method= RequestMethod.GET)
    public String index() {
        return "Greetings from Spring Boot!";
    }




}