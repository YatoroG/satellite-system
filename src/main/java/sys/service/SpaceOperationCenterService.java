package sys.service;

import org.springframework.stereotype.Service;
import sys.Satellite;
import sys.SatelliteConstellation;
import sys.repository.ConstellationRepository;

@Service
public class SpaceOperationCenterService {
    private final ConstellationRepository repository;

    public SpaceOperationCenterService(ConstellationRepository repository) {
        this.repository = repository;
    }

    public ConstellationRepository getRepository() {
        return repository;
    }

    public void createAndSaveConstellation(String name) {
        SatelliteConstellation constellation = new SatelliteConstellation(name);
        repository.addConstellation(constellation);
    }

    public void addSatelliteToConstellation(String constellationName, Satellite satellite) {
        SatelliteConstellation constellation = repository.getConstellation(constellationName);
        constellation.addSatellite(satellite);
        System.out.println("Добавлен спутник '" + satellite.getName() + "' в группировку '" + constellationName + "'");
    }

    public void executeConstellationMission(String constellationName) {
        SatelliteConstellation constellation = repository.getConstellation(constellationName);
        System.out.println("ВЫПОЛНЕНИЕ МИССИЙ ГРУППИРОВКИ '" + constellationName + "'");
        System.out.println("============================================================");
        constellation.executeAllMissions();
    }

    public void activateAllSatellites(String constellationName) {
        SatelliteConstellation constellation = repository.getConstellation(constellationName);
        System.out.println("АКТИВАЦИЯ СПУТНИКОВ В ГРУППИРОВКЕ '" + constellationName + "'");
        System.out.println("============================================================");
        for (Satellite satellite : constellation.getSatellites()) {
            satellite.activate();
        }
    }

    public void showConstellationStatus(String constellationName) {
        SatelliteConstellation constellation = repository.getConstellation(constellationName);
        System.out.println("СТАТУС ГРУППИРОВКИ '" + constellationName + "'");
        System.out.println("============================================================");
        System.out.println("Количество спутников в группировке: " + constellation.getSatellites().size());
        for (Satellite satellite : constellation.getSatellites()) {
            System.out.println(satellite.getState());
        }
    }
}
