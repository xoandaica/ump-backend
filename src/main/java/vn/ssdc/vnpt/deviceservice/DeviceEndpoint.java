package vn.ssdc.vnpt.deviceservice;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vn.ssdc.vnpt.vn.ssdc.vnpt.acsclient.AcsClient;
import vn.vnpt.ssdc.core.VnptCrudEndpoint;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

/**
 * Created by vietnq on 10/21/16.
 */
@Component
@Path("/devices")
@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
public class DeviceEndpoint extends VnptCrudEndpoint<Long,Device> {

    @Autowired
    public DeviceEndpoint(DeviceService deviceService) {
        this.service = deviceService;
    }
}
