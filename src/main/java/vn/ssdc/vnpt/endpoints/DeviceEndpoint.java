package vn.ssdc.vnpt.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import vn.ssdc.vnpt.AcsClient;
import vn.ssdc.vnpt.dto.AcsResponse;
import vn.vnpt.ssdc.utils.ObjectUtils;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import java.util.HashMap;
import java.util.Map;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

/**
 * Created by vietnq on 10/31/16.
 */
@Component
@Path(("/api/devices"))
@Produces(APPLICATION_JSON)
public class DeviceEndpoint {
    @Autowired
    private AcsClient acsClient;


    @GET
    public AcsResponse searchDevices(@DefaultValue("{}") @QueryParam("query") String query,
                                     @DefaultValue("10") @QueryParam("limit") String limit,
                                     @DefaultValue("0") @QueryParam("offset") String offset,
                                     @QueryParam("parameters") String parameters,
                                     @QueryParam("sort") String sort) {

        AcsResponse response = new AcsResponse();
        Map<String, String> queryParams = new HashMap<String, String>();
        queryParams.put("query", query);
        queryParams.put("limit", limit);
        queryParams.put("skip", offset);
        if (!ObjectUtils.empty(parameters)) {
            queryParams.put("projection", parameters);
        }
        if (!ObjectUtils.empty(sort)) {
            queryParams.put("sort", sort);
        }
        ResponseEntity<String> responseEntity = this.acsClient.search("devices", queryParams);
        response.httpResponseCode = responseEntity.getStatusCodeValue();
        //total of search result is in http header [total]
        response.nbOfItems = Integer.parseInt(responseEntity.getHeaders().get("total").get(0));
        System.out.println("max  = " + response.nbOfItems);
        response.body = responseEntity.getBody();
        return response;
    }
}
