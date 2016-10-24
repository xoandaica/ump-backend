package vn.ssdc.vnpt;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;
import vn.ssdc.vnpt.deviceservice.DeviceEndpoint;

/**
 * Created by vietnq on 10/21/16.
 */
@Component
public class UmpResourceConfig extends ResourceConfig {
    public UmpResourceConfig() {
        registerEndpoints();
    }

    private void registerEndpoints() {
        register(DeviceEndpoint.class);
    }
}
