package vn.ssdc.vnpt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


/**
 * Created by vietnq on 10/21/16.
 */
@Component
public class AcsClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(AcsClient.class);

    private RestTemplate restTemplate;
    private String acsEnpoint;

    @Autowired
    public AcsClient(@Value("${acsEndpoint}") String acsEnpoint) {
        this.acsEnpoint = acsEnpoint;
        this.restTemplate = new RestTemplate();
    }
}
