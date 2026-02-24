package sys.factory.impl;

import org.springframework.stereotype.Component;
import sys.domains.ImagingSatellite;
import sys.domains.Satellite;
import sys.factory.SatelliteFactory;

import static sys.constants.SatelliteConstants.DEFAULT_RESOLUTION;

@Component
public class ImagingSatelliteFactory implements SatelliteFactory {

    @Override
    public Satellite createSatellite(String name, double batteryLevel) {
        return new ImagingSatellite(name, batteryLevel, DEFAULT_RESOLUTION);
    }

    @Override
    public Satellite createSatelliteWithParameter(String name, double batteryLevel, double parameter) {
        return new ImagingSatellite(name, batteryLevel, parameter);
    }
}
