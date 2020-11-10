package jerseyconfig;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;
import controller.ProductController;

public class userconfig extends ResourceConfig {
public userconfig(){
    registerApplicationProperties();
    registerApplicationApis();
}

    private void registerApplicationApis() {
        register(ProductController.class);
    }

    private void registerApplicationProperties() {
        property(ServerProperties.BV_SEND_ERROR_IN_RESPONSE, true);
        property(ServerProperties.BV_DISABLE_VALIDATE_ON_EXECUTABLE_OVERRIDE_CHECK, true);
    }
}

