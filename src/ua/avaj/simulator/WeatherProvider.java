package ua.avaj.simulator;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class WeatherProvider {
  private static WeatherProvider weatherProvider;
  private static String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};
  private static List weatherList = Arrays.asList(weather);
  public static int numberOfWeather = weather.length;
  private WeatherProvider(){

  }

  public static WeatherProvider getProvider(){
    return weatherProvider;
  }

  public String getCurrentWeather(Coordinates coordinates){
    Random randNumber = new Random();
    int iNumber = randNumber.nextInt(numberOfWeather);
    return weather[iNumber];
  }
}
