package ua.avaj.simulator.vehicles;

import ua.avaj.simulator.WeatherTower;

public interface Flyable {
    public void updateConditions();
    public void registerTower(WeatherTower weatherTower);
}
