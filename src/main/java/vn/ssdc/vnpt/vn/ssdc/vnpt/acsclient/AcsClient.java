package vn.ssdc.vnpt.vn.ssdc.vnpt.acsclient;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.inject.Singleton;

/**
 * Created by vietnq on 10/21/16.
 */
@Singleton
@Component
public class AcsClient {

    //TODO Move to application.yml
    public static final String ACS_NBI_URL = "http://localhost:7557";

    public String test() {
        return new RestTemplate().getForObject(ACS_NBI_URL + "/devices",String.class);
    }
}
