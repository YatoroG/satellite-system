package sys.factory;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import sys.domains.CommunicationSatellite;
import sys.domains.ImagingSatellite;
import sys.factory.impl.CommunicationSatelliteFactory;
import sys.factory.impl.ImagingSatelliteFactory;


import static org.junit.jupiter.api.Assertions.*;
import static sys.constants.SatelliteConstants.DEFAULT_BANDWIDTH;
import static sys.constants.SatelliteConstants.DEFAULT_RESOLUTION;

@DisplayName("Юнит-тесты функциональности фабрики создания спутников")
public class SatelliteFactoryTest {
    private static final String CONSTELLATION_NAME = "testConstellation";
    private static final double BATTERY_LEVEL = 0.8;
    private static final double BANDWIDTH = 300.0;
    private static final double RESOLUTION = 15.0;

    private static SatelliteFactory communicationSatelliteFactory;
    private static SatelliteFactory imagingSatelliteFactory;

    @BeforeAll
    static void setUp() {
        communicationSatelliteFactory = new CommunicationSatelliteFactory();
        imagingSatelliteFactory = new ImagingSatelliteFactory();
    }

    @Test
    @DisplayName("Создание спутника связи с дефолтными параметром")
    void commFactoryWithDefaultParams() {
        CommunicationSatellite satellite = (CommunicationSatellite) communicationSatelliteFactory
                .createSatellite(CONSTELLATION_NAME, BATTERY_LEVEL);

        assertNotNull(satellite);
        assertInstanceOf(CommunicationSatellite.class, satellite);
        assertEquals(CONSTELLATION_NAME, satellite.getName());
        assertEquals(BATTERY_LEVEL, satellite.getEnergy().getBatteryLevel());
        assertEquals(DEFAULT_BANDWIDTH, satellite.getBandwidth());
    }

    @Test
    @DisplayName("Создание спутника изображений с дефолтными параметром")
    void imgFactoryWithDefaultParams() {
        ImagingSatellite satellite = (ImagingSatellite) imagingSatelliteFactory
                .createSatellite(CONSTELLATION_NAME, BATTERY_LEVEL);

        assertNotNull(satellite);
        assertInstanceOf(ImagingSatellite.class, satellite);
        assertEquals(CONSTELLATION_NAME, satellite.getName());
        assertEquals(BATTERY_LEVEL, satellite.getEnergy().getBatteryLevel());
        assertEquals(DEFAULT_RESOLUTION, satellite.getResolution());
    }

    @Test
    @DisplayName("Создание спутника связи с параметром")
    void commFactoryWithParams() {
        CommunicationSatellite satellite = (CommunicationSatellite) communicationSatelliteFactory
                .createSatelliteWithParameter(CONSTELLATION_NAME, BATTERY_LEVEL, BANDWIDTH);

        assertNotNull(satellite);
        assertInstanceOf(CommunicationSatellite.class, satellite);
        assertEquals(CONSTELLATION_NAME, satellite.getName());
        assertEquals(BATTERY_LEVEL, satellite.getEnergy().getBatteryLevel());
        assertEquals(BANDWIDTH, satellite.getBandwidth());
    }

    @Test
    @DisplayName("Создание спутника изображений с параметром")
    void imgFactoryWithParams() {
        ImagingSatellite satellite = (ImagingSatellite) imagingSatelliteFactory
                .createSatelliteWithParameter(CONSTELLATION_NAME, BATTERY_LEVEL, RESOLUTION);

        assertNotNull(satellite);
        assertInstanceOf(ImagingSatellite.class, satellite);
        assertEquals(CONSTELLATION_NAME, satellite.getName());
        assertEquals(BATTERY_LEVEL, satellite.getEnergy().getBatteryLevel());
        assertEquals(RESOLUTION, satellite.getResolution());
    }
}
