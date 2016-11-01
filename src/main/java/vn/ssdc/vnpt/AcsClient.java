package vn.ssdc.vnpt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import vn.vnpt.ssdc.utils.ObjectUtils;
import vn.vnpt.ssdc.utils.StringUtils;

import java.util.Map;


/**
 * Created by vietnq on 10/21/16.
 */
@Component
public class AcsClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(AcsClient.class);

    private RestTemplate restTemplate;
    private String acsEndpoint;

    @Autowired
    public AcsClient(@Value("${acsEndpoint}") String acsEndpoint) {
        this.acsEndpoint = acsEndpoint;
        this.restTemplate = new RestTemplate();
    }

    public ResponseEntity<String> search(String collectionName, Map<String,String> queryParams) {
        String url = this.acsEndpoint + "/" + collectionName;
        String queryString = StringUtils.queryStringFromMap(queryParams);
        if(!ObjectUtils.empty(queryString)) {
            url += "?" + queryString;
        }
        return this.restTemplate.getForEntity(url,String.class,queryParams);
    }
}
