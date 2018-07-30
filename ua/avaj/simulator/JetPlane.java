package ua.avaj.simulator;

public class JetPlane extends Aircraft implements Flyable{
  private WeatherTower weatherTower;

  JetPlane(String name, Coordinates coordinates){
    super(name, coordinates);
  }
  public void updateConditions(){
    String currentWeather = weatherTower.getWeather(coordinates);
    String message = "";
    switch (currentWeather){
      case "SUN":
        this.changeLatitude(10);
          message = "I have two suns behind!" + this.changeHeight(2);
        break;
      case "RAIN":
        this.changeLatitude(5);
        message = "You can't hide from rain!";
        break;
      case "FOG":
        this.changeLatitude(1);
        message = "*Angel wings*";
        break;
      case "SNOW":
          message = "Get water from me and ice!" + this.changeHeight(-7);
        break;
    }
      FileLogger.getLogger().logln("JetPlane#" + this.getName() + "(" + this.getId() + "): " + message);
  }
  public void registerTower(WeatherTower weatherTower){
    weatherTower.register(this);
    this.weatherTower = weatherTower;
      FileLogger.getLogger().logln("Tower says: JetPlane#" + this.getName() + "(" + this.getId() + ") registered to weather tower.");
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
        message = "\nJetPlane#" + this.getName() + "(" + this.getId() + ") landing."
                + "\nTower says: JetPlane#" + this.getName() + "(" + this.getId() + ") unregistered from weather tower.";
    }
    coordinates.setHeight(height);
        return message;
  }

}
