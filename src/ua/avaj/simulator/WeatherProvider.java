package ua.avaj.simulator;

import java.util.Random;

import static java.lang.Math.abs;

public class WeatherProvider {
  private static WeatherProvider weatherProvider;
  private static String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};
  public static int numberOfWeather = weather.length;


  private WeatherProvider(){

  }

  public static WeatherProvider getProvider(){
    if (weatherProvider == null) {
      weatherProvider = new WeatherProvider();
    }
    return weatherProvider;
  }

  public String getCurrentWeather(Coordinates coordinates){
    Random rnd = new Random();
    return weather[abs(coordinates.getHeight() + coordinates.getLatitude() + coordinates.getLongitude() + rnd.nextInt(13)) % numberOfWeather];
  }
}
