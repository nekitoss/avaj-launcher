package ua.avaj.simulator;

public class Helicopter extends Aircraft implements Flyable{
  private WeatherTower weatherTower;

  Helicopter(String name, Coordinates coordinates){
    super(name, coordinates);
  }
  public void updateConditions(){
//    weatherTower.getWeather(coordinates);
    System.out.println("weather conditions for " + name + "changed!");
  }
  public void registerTower(WeatherTower weatherTower){
    weatherTower.register(this);
    this.weatherTower = weatherTower;
    System.out.println("Tower says: Helicopter#" + this.getName() + "(" + this.getId() + ") registered to weather tower.");
  }
}
