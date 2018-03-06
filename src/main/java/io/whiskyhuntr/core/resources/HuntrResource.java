package io.whiskyhuntr.core.resources;

import com.codahale.metrics.annotation.Timed;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.whiskyhuntr.core.WhiskyHuntrConfiguration;
import io.whiskyhuntr.core.api.ConfigurationEntity;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/hello-world")
@Produces(MediaType.APPLICATION_JSON)
@Api(value = "/pet", description = "Operations about pets")
public class HuntrResource {
    private WhiskyHuntrConfiguration configuration;

    public HuntrResource(WhiskyHuntrConfiguration configuration) {
        this.configuration = configuration;
    }

    @GET
    @Timed
    @Path("/configuration/{configurationName}")
    @ApiOperation(
            value = "Get configuration value",
            notes = "Returns a pet when 0 < ID <= 10. ID > 10 or nonintegers will simulate API error conditions",
            response = ConfigurationEntity.class)
    @ApiResponses(value = { @ApiResponse(code = 400, message = "Invalid name supplied"),
            @ApiResponse(code = 404, message = "Configuration not found") })
    public ConfigurationEntity getConfiguration(@QueryParam("name") String name) {
        try{
                switch (name){
                    case "active":
                        return new ConfigurationEntity("Active", configuration.getActive().toString());
                }
        } catch(Exception e){
        }
        return new ConfigurationEntity();
    }


    @PUT
    @Path("/configuration/{configurationName}/{configurationValue}")
    @ApiOperation(
            value = "Set configuration value",
            response = ConfigurationEntity.class)
    @ApiResponses(value = { @ApiResponse(code = 400, message = "Invalid name supplied"),
            @ApiResponse(code = 404, message = "Configuration not found") })
    public ConfigurationEntity setConfiguration(
            @PathParam("configurationName") String name,
            @PathParam("configurationValue") String value) {

        switch (name){
            case "active":
                configuration.setActive(Boolean.getBoolean(value));
        }
        return new ConfigurationEntity("Active", configuration.getActive().toString());
    }




}