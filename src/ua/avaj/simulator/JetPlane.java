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
        this.changeHeight(2);
        message = "I have two suns behind!";
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
        this.changeHeight(-7);
        message = "Get water from me and ice!";
        break;
    }
    System.out.println("JetPlane#" + this.getName() + "(" + this.getId() + "):" + message);
  }
  public void registerTower(WeatherTower weatherTower){
    weatherTower.register(this);
    this.weatherTower = weatherTower;
    System.out.println("Tower says: JetPlane#" + this.getName() + "(" + this.getId() + ") registered to weather tower.");
  }

  public void changeLongitude(int longitude) {
    coordinates.setLongitude(coordinates.getLongitude() + longitude);
  }

  public void changeLatitude(int latitude) {
    coordinates.setLatitude(coordinates.getLatitude() + latitude);
  }

  public void changeHeight(int height) {
    height += coordinates.getHeight();
    if (height > 100)
      height = 100;
    if (height < 0)
    {
      height = 0;
      System.out.println("Tower says: JetPlane#" + this.getName() + "(" + this.getId() + ") unregistered to weather tower.");
      weatherTower.unregister(this);
    }
    coordinates.setHeight(height);
  }

}
