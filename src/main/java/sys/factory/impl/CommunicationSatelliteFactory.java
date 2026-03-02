package sys.factory.impl;

import org.springframework.stereotype.Component;
import sys.domains.*;
import sys.factory.SatelliteFactory;
import sys.utils.SatelliteType;
import sys.utils.SpaceOperationException;

@Component
public class CommunicationSatelliteFactory implements SatelliteFactory {

    @Override
    public Satellite createSatelliteWithParameter(SatelliteParam param) throws SpaceOperationException {
        if (!(param instanceof CommunicationSatelliteParam communicationSatelliteParam)) {
            throw new SpaceOperationException("Ошибка в параметре для спутника связи");
        }

        return new CommunicationSatellite(
                communicationSatelliteParam.getName(),
                communicationSatelliteParam.getBatteryLevel(),
                communicationSatelliteParam.getBandwidth()
        );
    }

    @Override
    public boolean isSatelliteTypeSupported(SatelliteType type) {
        return type == SatelliteType.COMMUNICATION;
    }
}
