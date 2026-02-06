public class EnergySystem {
    protected double batteryLevel;
    private static final double LOW_BATTERY_THRESHOLD = 0.2;
    private static final double MAX_BATTERY = 1.0;
    private static final double MIN_BATTERY = 0.0;

    public EnergySystem(double batteryLevel) {
        this.batteryLevel = Math.max(MIN_BATTERY, Math.min(MAX_BATTERY, batteryLevel));
    }

    public double getBatteryLevel() {
        return batteryLevel;
    }

    public boolean consume(double batteryAmount) {
        if (batteryAmount <= 0 || batteryLevel <= MIN_BATTERY) {
            return false;
        }
        batteryLevel = Math.max(MIN_BATTERY, batteryLevel - batteryAmount);
        return true;
    }

    public boolean hasSufficientPower() {
        return batteryLevel > LOW_BATTERY_THRESHOLD;
    }

    @Override
    public String toString() {
        return "EnergySystem{" +
                "batteryLevel=" + batteryLevel + '}';
    }
}
