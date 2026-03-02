package sys.service;

import sys.domains.Satellite;
import sys.domains.SatelliteParam;
import sys.utils.SpaceOperationException;

public interface SatelliteService {
    Satellite createSatellite(SatelliteParam param) throws SpaceOperationException;
}
