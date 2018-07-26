package ua.avaj.simulator;

public class Helicopter extends Aircraft implements Flyable{
  private WeatherTower weatherTower;

  Helicopter(String name, Coordinates coordinates){
    super(name, coordinates);
  }
  public void updateConditions(){
    String currentWeather = weatherTower.getWeather(coordinates);
    String message = "";
    switch (currentWeather){
      case "SUN":
        this.changeLongitude(10);
        message = "I'm biggest cooler you ever seen!." + this.changeHeight(2);
        break;
      case "RAIN":
        this.changeLongitude(5);
        message = "Rotating umbrella!";
        break;
      case "FOG":
        this.changeLongitude(1);
        message = "Can't see rotor!";
        break;
      case "SNOW":
          message = "I see icicle round and round!" + this.changeHeight(-12);
        break;
    }
    FileLogger.getLogger().logln("Helicopter#" + this.getName() + "(" + this.getId() + "): " + message);
  }
  public void registerTower(WeatherTower weatherTower){
    weatherTower.register(this);
    this.weatherTower = weatherTower;
    FileLogger.getLogger().logln("Tower says: Helicopter#" + this.getName() + "(" + this.getId() + ") registered to weather tower.");
  }

  public void changeLongitude(int longitude) {
    coordinates.setLongitude(coordinates.getLongitude() + longitude);
  }

  public void changeLatitude(int latitude) {
    coordinates.setLatitude(coordinates.getLatitude() + latitude);
  }

  public String changeHeight(int height) {
    String message = "";
    height += coordinates.getHeight();
    if (height > 100)
      height = 100;
    if (height < 0)
    {
      height = 0;
      weatherTower.unregister(this);
      message = "\nHelicopter#" + this.getName() + "(" + this.getId() + ") landing."
              + "\nTower says: Helicopter#" + this.getName() + "(" + this.getId() + ") unregistered from weather tower.";
    }
    coordinates.setHeight(height);
    return message;
  }

}
