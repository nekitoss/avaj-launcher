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
        this.changeHeight(4);
        message = "There is no shadow here...";
        break;
      case "RAIN":
        this.changeHeight(-5);
        message = "Anyone asked for shower?";
        break;
      case "FOG":
        this.changeHeight(-3);
        message = "Who is smoking?";
        break;
      case "SNOW":
        this.changeHeight(-15);
        message = "Big snowball!";
        break;
    }
    System.out.println("Baloon#" + this.getName() + "(" + this.getId() + "):" + message);
  }
  public void registerTower(WeatherTower weatherTower){
    weatherTower.register(this);
    this.weatherTower = weatherTower;
    System.out.println("Tower says: Baloon#" + this.getName() + "(" + this.getId() + ") registered to weather tower.");
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
      System.out.println("Tower says: Baloon#" + this.getName() + "(" + this.getId() + ") unregistered to weather tower.");
      weatherTower.unregister(this);
    }
    coordinates.setHeight(height);
  }

}
