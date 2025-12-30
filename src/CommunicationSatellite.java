public class CommunicationSatellite extends Satellite {
    private final double bandwidth;

    public CommunicationSatellite(String name, double batteryLevel, double bandwidth) {
        super(name, batteryLevel);
        this.bandwidth = bandwidth;
    }

    public double getBandwidth() {
        return bandwidth;
    }

    @Override
    public void performMission() {
        if (super.isActive) {
            System.out.println(name + ": Передача данных со скоростью " + bandwidth + " Мбит/с");
            sendData(bandwidth);
            super.consumeBattery(0.05);
        } else {
            System.out.println("\uD83D\uDD34 " + name + ": Не может выполнить передачу данных - не активен");
        }
    }

    private void sendData(double data) {
        System.out.println(name + ": Отправил " + bandwidth + " Мбит данных!");
    }

    @Override
    public String toString() {
        return "CommunicationSatellite{bandwidth=" + bandwidth + ", name='" + name + "', "
                + "isActive=" + super.isActive + ", batteryLevel=" + super.batteryLevel +"}";
    }
}