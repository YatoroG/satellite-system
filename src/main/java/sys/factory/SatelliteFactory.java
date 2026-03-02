package sys.factory;

import sys.domains.Satellite;
import sys.domains.SatelliteParam;
import sys.utils.SatelliteType;
import sys.utils.SpaceOperationException;

public interface SatelliteFactory {
    Satellite createSatelliteWithParameter(SatelliteParam param) throws SpaceOperationException;
    boolean isSatelliteTypeSupported(SatelliteType type);
}
