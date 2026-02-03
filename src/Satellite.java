public abstract class Satellite {
    protected String name;
    protected boolean isActive;
    protected double batteryLevel;

    public Satellite(String name, double batteryLevel) {
        this.name = name;
        this.batteryLevel = Math.max(0.0, Math.min(1.0, batteryLevel));
        this.isActive = false;
        notifyAboutSatelliteCreation();
    }

    public String getName() {
        return name;
    }

    public boolean isActive() {
        return isActive;
    }

    public double getBatteryLevel() {
        return batteryLevel;
    }

    public boolean activate() {
        if (batteryLevel > 0.2 && !isActive) {
            isActive = true;
        }
        notifyAboutActivation(isActive);
        return isActive;
    }

    public void deactivate() {
        if (isActive) {
            isActive = false;
            System.out.println("Деактивирован спутник: " + name);
        }
    }

    public void consumeBattery(double batteryAmount) {
        if (batteryAmount > 0) {
            batteryLevel = Math.max(0.0, batteryLevel - batteryAmount);
            if (batteryLevel < 0.2 && isActive) {
                System.out.println("\uD83D\uDD34 Низкий заряд: " + name + " деактивируется");
                deactivate();
            }
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