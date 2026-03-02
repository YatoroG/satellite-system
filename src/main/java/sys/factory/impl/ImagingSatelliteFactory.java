package sys.factory.impl;

import org.springframework.stereotype.Component;
import sys.domains.*;
import sys.factory.SatelliteFactory;
import sys.utils.SatelliteType;
import sys.utils.SpaceOperationException;

@Component
public class ImagingSatelliteFactory implements SatelliteFactory {

    @Override
    public Satellite createSatelliteWithParameter(SatelliteParam param) throws SpaceOperationException {
        if (!(param instanceof ImagingSatelliteParam imagingSatelliteParam)) {
            throw new SpaceOperationException("Ошибка в параметре для спутника изображений");
        }

        return new ImagingSatellite(
                imagingSatelliteParam.getName(),
                imagingSatelliteParam.getBatteryLevel(),
                imagingSatelliteParam.getResolution()
        );
    }

    @Override
    public boolean isSatelliteTypeSupported(SatelliteType type) {
        return type == SatelliteType.IMAGE;
    }
}
