package sys.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import sys.domains.Satellite;
import sys.domains.SatelliteParam;
import sys.factory.SatelliteFactory;
import sys.service.SatelliteService;
import sys.utils.SpaceOperationException;

@Service
public class SatelliteServiceImpl implements SatelliteService {
    private final List<SatelliteFactory> factories;

    public SatelliteServiceImpl(List<SatelliteFactory> factories) {
        this.factories = factories;
    }

    @Override
    public Satellite createSatellite(SatelliteParam param) throws SpaceOperationException {
        SatelliteFactory factory = null;
        for (SatelliteFactory f : factories) {
            if (f.isSatelliteTypeSupported(param.getType())) {
                factory = f;
                break;
            }
        }

        if (factory == null) {
            throw new SpaceOperationException("Ошибка в типе спутника");
        }

        return factory.createSatelliteWithParameter(param);
    }
}
