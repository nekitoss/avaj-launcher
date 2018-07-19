package ua.avaj.simulator;

//import ua.avaj.simulator.Aircraft;
//import ua.avaj.simulator.AircraftFactory;
//import ua.avaj.simulator.Flyable;
//import ua.avaj.simulator.WeatherTower;

public class Main {

    public static void main(String[] args) throws Exception{
      WeatherTower mainTower = new WeatherTower();
      int numberOfSimulations = 5;

      //here must be reading from file with validation
      Flyable B1 = AircraftFactory.newAircraft("Baloon", "B1", 1, 1, 1);
      Flyable J1 = AircraftFactory.newAircraft("JetPlane", "J1", 2, 2, 2);
      Flyable H1 = AircraftFactory.newAircraft("Helicopter", "H1", 3, 3, 3);
      Flyable H4 = AircraftFactory.newAircraft("Helicopter", "H4", 4, 4, 4);

      B1.registerTower(mainTower);
      J1.registerTower(mainTower);
      H1.registerTower(mainTower);
      H4.registerTower(mainTower);

      for (int i = 0; i < numberOfSimulations; i++)
      {
        mainTower.changeWeather();
      }
    }
}
