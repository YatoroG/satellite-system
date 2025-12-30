public abstract class Satellite {
    protected String name;
    protected boolean isActive = false;
    protected double batteryLevel;

    public Satellite(String name, double batteryLevel) {
        this.name = name;
        this.batteryLevel = batteryLevel;
        notifyAboutSatelliteCreation();
    }

    public boolean activate() {
        if (batteryLevel > 0.2) {
            isActive = true;
        }
        return isActive;
    }

    public void deactivate() {
        if (isActive) {
            isActive = false;
        }
    }

    public void consumeBattery(double batteryAmount) {
        batteryLevel -= batteryAmount;
        if (batteryLevel < 0.2) {
            deactivate();
        }
    }

    public void notifyAboutSatelliteCreation() {
        System.out.println("Создан спутник: " + name + " (заряд: " + (int) (batteryLevel * 100) + "%)");
    }

    public void notifyAboutActivation(boolean isActive) {
        if (isActive) {
            System.out.println("\uD83D\uDFE2 " + name + ": Активация успешна");
        } else {
            System.out.println("\uD83D\uDD34 " + name + ": Ошибка активации (заряд " + (int) (batteryLevel * 100) + "%)");
        }
    }

    protected abstract void performMission();
}