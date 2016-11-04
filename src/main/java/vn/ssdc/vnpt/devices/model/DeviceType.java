package vn.ssdc.vnpt.devices.model;

import vn.vnpt.ssdc.jdbc.SsdcEntity;

import java.util.Map;

/**
 * Created by vietnq on 11/2/16.
 */
public class DeviceType extends SsdcEntity<Long> {
    public String name;
    public String manufacturer;
    public String oui;
    public String productClass;
    public String firmwareVersion;
    public Map<String,Parameter> parameters;
}