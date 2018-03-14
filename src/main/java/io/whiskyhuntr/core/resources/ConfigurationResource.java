package io.whiskyhuntr.core.resources;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/configuration")
public interface ConfigurationResource {

    @RequestMapping(value = "/config/key", method= RequestMethod.GET)
    @ApiOperation(value = "Retrieve config value", response = String.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved value"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })

    String getConfigValue(
            @RequestParam(value="key") String key
    );


    @RequestMapping(value = "/config/key", method= RequestMethod.PUT)
    @ApiOperation(value = "Update config value", response = String.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully updated value"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    String updateConfig(
            @RequestParam(value="key") String key,
            @RequestParam(value="value") String value

    );




}