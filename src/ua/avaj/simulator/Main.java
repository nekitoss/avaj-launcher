package ua.avaj.simulator;

//import ua.avaj.simulator.Aircraft;
//import ua.avaj.simulator.AircraftFactory;
//import ua.avaj.simulator.Flyable;
//import ua.avaj.simulator.WeatherTower;

public class Main {

    public static void main(String[] args) throws Exception{
      WeatherTower mainTower = new WeatherTower();

      Flyable theFirstOne = AircraftFactory.newAircraft("Helicopter", "theFirstOne", 15, 30, 77);
      Flyable theSecondButChoosen = AircraftFactory.newAircraft("Helicopter", "theSecondButChoosen", 11, 12, 13);
      theFirstOne.registerTower(mainTower);
      theSecondButChoosen.registerTower(mainTower);
      mainTower.changeWeather();

    }
}
