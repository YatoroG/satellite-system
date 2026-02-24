package sys.factory;

import sys.domains.Satellite;

public interface SatelliteFactory {
    Satellite createSatellite(String name, double batteryLevel);
    Satellite createSatelliteWithParameter(String name, double batteryLevel, double parameter);
}
