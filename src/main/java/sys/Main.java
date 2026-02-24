package sys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import sys.domains.Satellite;
import sys.factory.SatelliteFactory;
import sys.factory.impl.CommunicationSatelliteFactory;
import sys.factory.impl.ImagingSatelliteFactory;
import sys.repository.ConstellationRepository;
import sys.service.SpaceOperationCenterService;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        System.out.println("ЗАПУСК СИСТЕМЫ УПРАВЛЕНИЯ СПУТНИКОВОЙ ГРУППИРОВКОЙ");
        System.out.println("============================================================");

        ConfigurableApplicationContext ctx = SpringApplication.run(Main.class, args);

        ConstellationRepository repository = ctx.getBean(ConstellationRepository.class);
        SpaceOperationCenterService operationCenterService = ctx.getBean(SpaceOperationCenterService.class);

        System.out.println("СОЗДАНИЕ СПЕЦИАЛИЗИРОВАННЫХ СПУТНИКОВ:");
        System.out.println("============================================================");
        SatelliteFactory commFactory = ctx.getBean(CommunicationSatelliteFactory.class);
        SatelliteFactory imgFactory = ctx.getBean(ImagingSatelliteFactory.class);

        Satellite comm1 = commFactory.createSatelliteWithParameter("Связь-1", 0.85, 500.0);
        Satellite comm2 = commFactory.createSatelliteWithParameter("Связь-2", 0.75, 1000.0);
        Satellite img1 = imgFactory.createSatelliteWithParameter("ДЗЗ-1", 0.92, 2.5);
        Satellite img2 = imgFactory.createSatelliteWithParameter("ДЗЗ-2", 0.45, 2.5);
        Satellite img3 = imgFactory.createSatelliteWithParameter("ДЗЗ-3", 0.15, 1.0);

        System.out.println("---------------------------------------------");

        System.out.println("СОЗДАНИЕ ГРУППИРОВОК:");
        System.out.println("============================================================");
        String groupName1 = "Группа-1";
        String groupName2 = "Группа-2";
        operationCenterService.createAndSaveConstellation(groupName1);
        operationCenterService.createAndSaveConstellation(groupName2);
        System.out.println("---------------------------------------------");

        System.out.println("ФОРМИРОВАНИЕ ГРУППИРОВОК:");
        System.out.println("============================================================");
        operationCenterService.addSatelliteToConstellation(groupName1, comm1);
        operationCenterService.addSatelliteToConstellation(groupName1, comm2);
        operationCenterService.addSatelliteToConstellation(groupName2, img1);
        operationCenterService.addSatelliteToConstellation(groupName2, img2);
        operationCenterService.addSatelliteToConstellation(groupName2, img3);
        System.out.println("---------------------------------------------");

        operationCenterService.showConstellationStatus(groupName1);
        System.out.println("---------------------------------------------");
        operationCenterService.showConstellationStatus(groupName2);
        System.out.println("---------------------------------------------");

        operationCenterService.activateAllSatellites(groupName1);
        System.out.println("---------------------------------------------");
        operationCenterService.activateAllSatellites(groupName2);
        System.out.println("---------------------------------------------");

        operationCenterService.executeConstellationMission(groupName1);
        System.out.println("---------------------------------------------");
        operationCenterService.showConstellationStatus(groupName1);
        System.out.println("---------------------------------------------");

        operationCenterService.executeConstellationMission(groupName2);
        System.out.println("---------------------------------------------");
        operationCenterService.showConstellationStatus(groupName2);
        System.out.println("---------------------------------------------");
    }
}