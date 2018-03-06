package io.whiskyhuntr.core;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.federecio.dropwizard.swagger.SwaggerBundle;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;
import io.whiskyhuntr.core.health.TemplateHealthCheck;
import io.whiskyhuntr.core.resources.HuntrResource;

public class WhiskyHuntrApplication extends Application<WhiskyHuntrConfiguration> {

    public static void main(final String[] args) throws Exception {
        new WhiskyHuntrApplication().run(args);
    }


    @Override
    public String getName() {
        return "WhiskyHuntr";
    }

    @Override
    public void initialize(final Bootstrap<WhiskyHuntrConfiguration> bootstrap) {
            bootstrap.addBundle(new SwaggerBundle<WhiskyHuntrConfiguration>() {
                @Override
                protected SwaggerBundleConfiguration getSwaggerBundleConfiguration(WhiskyHuntrConfiguration configuration) {
                    return configuration.swaggerBundleConfiguration;
                }
            });

    }

    @Override
    public void run(final WhiskyHuntrConfiguration configuration,
                    final Environment environment) {
        final HuntrResource resource = new HuntrResource(configuration);
        environment.jersey().register(resource);

        final TemplateHealthCheck healthCheck =
                new TemplateHealthCheck(configuration.getTemplate());
        environment.healthChecks().register("template", healthCheck);
        environment.jersey().register(resource);

    }

}
