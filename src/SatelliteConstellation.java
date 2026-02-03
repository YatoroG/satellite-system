import java.util.ArrayList;
import java.util.List;

public class SatelliteConstellation {
    private final String constellationName;
    private final List<Satellite> satellites = new ArrayList<>();

    public SatelliteConstellation(String constellationName) {
        this.constellationName = constellationName;
        notifyAboutConstellationCreation();
    }

    public void addSatellite(Satellite satellite) {
        if (satellite != null && !satellites.contains(satellite)) {
            satellites.add(satellite);
            notifyAboutSatelliteAdding(satellite);
        }
    }

    public void executeAllMissions() {
        for (Satellite satellite : satellites) {
            satellite.performMission();
        }
    }

    public String getConstellationName() {
        return constellationName;
    }

    public List<Satellite> getSatellites() {
        return new ArrayList<>(satellites);
    }

    public void notifyAboutConstellationCreation() {
        System.out.println("Создана спутниковая группировка: " + constellationName);
    }

    public void notifyAboutSatelliteAdding(Satellite satellite) {
        System.out.println(satellite.name + " добавлен в группировку " + constellationName);
    }
}