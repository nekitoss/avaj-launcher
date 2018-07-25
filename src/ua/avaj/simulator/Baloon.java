package ua.avaj.simulator;

public class Baloon extends Aircraft implements Flyable{
  private WeatherTower weatherTower;

  Baloon(String name, Coordinates coordinates){
    super(name, coordinates);
  }
  public void updateConditions(){
    String currentWeather = weatherTower.getWeather(coordinates);
    String message = "";
    switch (currentWeather){
      case "SUN":
        this.changeLongitude(2);
        message = "There is no shadow here..." + this.changeHeight(4);
        break;
      case "RAIN":
        message = "Anyone asked for shower?" + this.changeHeight(-5);
        break;
      case "FOG":
        message = "Who is smoking?" + this.changeHeight(-3);
        break;
      case "SNOW":
        message = "Big snowball!" + this.changeHeight(-15);
        break;
    }
    FileLogger.getLogger().logln("Baloon#" + this.getName() + "(" + this.getId() + "): " + message);
  }
  public void registerTower(WeatherTower weatherTower){
    weatherTower.register(this);
    this.weatherTower = weatherTower;
    FileLogger.getLogger().logln("Tower says: Baloon#" + this.getName() + "(" + this.getId() + ") registered to weather tower.");
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
      message = "\nBaloon#" + this.getName() + "(" + this.getId() + ") landing."
              + "\nTower says: Baloon#" + this.getName() + "(" + this.getId() + ") unregistered to weather tower.";
    }
    coordinates.setHeight(height);
    return message;
  }

}
