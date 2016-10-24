package vn.ssdc.vnpt.deviceservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vn.ssdc.vnpt.vn.ssdc.vnpt.acsclient.AcsClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * Created by vietnq on 10/21/16.
 */
@Component
@Path("/devices")
public class DeviceEndpoint {

    @Autowired
    private AcsClient acsClient;

    @GET
    public String test() {
        return acsClient.test();
    }
}
