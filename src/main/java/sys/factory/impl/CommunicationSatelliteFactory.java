package sys.factory.impl;

import org.springframework.stereotype.Component;
import sys.domains.CommunicationSatellite;
import sys.domains.Satellite;
import sys.factory.SatelliteFactory;

import static sys.constants.SatelliteConstants.DEFAULT_BANDWIDTH;

@Component
public class CommunicationSatelliteFactory implements SatelliteFactory {

    @Override
    public Satellite createSatellite(String name, double batteryLevel) {
        return new CommunicationSatellite(name, batteryLevel, DEFAULT_BANDWIDTH);
    }

    @Override
    public Satellite createSatelliteWithParameter(String name, double batteryLevel, double parameter) {
        return new CommunicationSatellite(name, batteryLevel, parameter);
    }
}
