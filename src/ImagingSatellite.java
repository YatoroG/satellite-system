public class ImagingSatellite extends Satellite {
    private final double resolution;
    private int photosTaken = 0;

    public ImagingSatellite(String name, double batteryLevel, double resolution) {
        super(name, batteryLevel);
        this.resolution = resolution;
    }

    public double getResolution() {
        return resolution;
    }

    public int getPhotosTaken() {
        return photosTaken;
    }

    @Override
    public void performMission() {
        if (super.isActive) {
            System.out.println(name + ": Съемка территории с разрешением " + resolution + " м/пиксель");
            takePhoto();
            super.consumeBattery(0.08);
        } else {
            System.out.println("\uD83D\uDD34 " + name + ": Не может выполнить съемку - не активен");
        }
    }

    private void takePhoto() {
        ++photosTaken;
        System.out.println(name + ": Снимок " + photosTaken + " сделан");
    }

    @Override
    public String toString() {
        return "ImagingSatellite{resolution=" + resolution +
                ", photosTaken=" + photosTaken + ", name='" + name + "', "
                + "isActive=" + super.isActive + ", batteryLevel=" + super.batteryLevel + "}";
    }
}