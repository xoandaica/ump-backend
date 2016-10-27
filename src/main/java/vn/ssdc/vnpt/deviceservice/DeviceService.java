package vn.ssdc.vnpt.deviceservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.vnpt.ssdc.core.VnptCrudService;
import vn.vnpt.ssdc.jdbc.factories.RepositoryFactory;

/**
 * Created by vietnq on 10/25/16.
 */
@Service
public class DeviceService extends VnptCrudService<Long,Device> {

    @Autowired
    public DeviceService(RepositoryFactory repositoryFactory) {
        this.repository = repositoryFactory.create(Device.class);
    }
}
