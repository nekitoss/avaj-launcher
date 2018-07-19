package ua.avaj.simulator;

import java.util.Random;

public class WeatherTower extends Tower{

  public String getWeather(Coordinates coordinates){
    Random randNumber = new Random(coordinates.getLongitude() + coordinates.getHeight() + coordinates.getLatitude());
    int iNumber = randNumber.nextInt(WeatherProvider.numberOfWeather);
    return "UNKNOWN"+iNumber;
//    return WeatherProvider.getCurrentWeather()
  }
  void changeWeather(){
    super.conditionsChanged();
  }
}
