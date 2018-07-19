package ua.avaj.simulator;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static java.lang.Math.abs;

public class WeatherProvider {
  private static WeatherProvider weatherProvider;
  private static String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};
//  private static List weatherList = Arrays.asList(weather);
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
    return weather[abs(coordinates.getHeight() + coordinates.getLatitude() + coordinates.getLongitude()) % numberOfWeather];
  }
}
