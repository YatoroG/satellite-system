import java.util.List;

public class Main {
    public static void printSatellites(List<Satellite> satellites) {
        System.out.print('[');
        boolean isFirst = true;
        for (Satellite satellite : satellites) {
            if (!isFirst) {
                System.out.print(",\n");
            }
            System.out.print(satellite.toString());
            isFirst = false;
        }
        System.out.print(']');
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("ЗАПУСК СИСТЕМЫ УПРАВЛЕНИЯ СПУТНИКОВОЙ ГРУППИРОВКОЙ");
        System.out.println("============================================================");

        System.out.println("СОЗДАНИЕ СПЕЦИАЛИЗИРОВАННЫХ СПУТНИКОВ:");
        System.out.println("---------------------------------------------");
        CommunicationSatellite comm1 = new CommunicationSatellite("Связь-1", 0.85, 500.0);
        CommunicationSatellite comm2 = new CommunicationSatellite("Связь-2", 0.75, 1000.0);
        ImagingSatellite img1 = new ImagingSatellite("ДЗЗ-1", 0.92, 2.5);
        ImagingSatellite img2 = new ImagingSatellite("ДЗЗ-2", 0.45, 2.5);
        ImagingSatellite img3 = new ImagingSatellite("ДЗЗ-3", 0.15, 1.0);
        System.out.println("---------------------------------------------");
        SatelliteConstellation satelliteConstellation = new SatelliteConstellation("RU Basic");
        System.out.println("---------------------------------------------");

        System.out.println("ФОРМИРОВАНИЕ ГРУППИРОВКИ:");
        System.out.println("---------------------------------------------");
        satelliteConstellation.addSatellite(comm1);
        satelliteConstellation.addSatellite(comm2);
        satelliteConstellation.addSatellite(img1);
        satelliteConstellation.addSatellite(img2);
        satelliteConstellation.addSatellite(img3);
        System.out.println("---------------------------------------------");
        printSatellites(satelliteConstellation.getSatellites());
        System.out.println("---------------------------------------------");

        System.out.println("АКТИВАЦИЯ СПУТНИКОВ:");
        System.out.println("---------------------------------------------");
        comm1.notifyAboutActivation(comm1.activate());
        comm2.notifyAboutActivation(comm2.activate());
        img1.notifyAboutActivation(img1.activate());
        img2.notifyAboutActivation(img2.activate());
        img3.notifyAboutActivation(img3.activate());
        System.out.println("---------------------------------------------");

        System.out.println("ВЫПОЛНЕНИЕ МИССИЙ ГРУППИРОВКИ " + satelliteConstellation.getConstellationName());
        System.out.println("============================================================");
        satelliteConstellation.executeAllMissions();
        System.out.println("---------------------------------------------");
        printSatellites(satelliteConstellation.getSatellites());
        System.out.println("---------------------------------------------");
        satelliteConstellation.executeAllMissions();
        System.out.println("---------------------------------------------");
        printSatellites(satelliteConstellation.getSatellites());
        System.out.println("---------------------------------------------");
    }
}