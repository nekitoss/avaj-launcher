package ua.avaj.simulator;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
      WeatherTower mainTower = new WeatherTower();
        int numberOfSimulations = 0;
        int lineNumber = 1;
        Pattern simulationsPattern = Pattern.compile("[-+]?\\d+");
        Pattern aircraftPattern = Pattern.compile("(Baloon|Helicopter|JetPlane) (\\w+) ([-+]?\\d+) ([-+]?\\d+) ([-+]?\\d+)");
        boolean firstLine = true;
        try (BufferedReader br = new BufferedReader(new FileReader(args[0]))) {
            for (String line; (line = br.readLine()) != null; ++lineNumber) {
                if (firstLine) {
                    Matcher matcher = simulationsPattern.matcher(line);
                    if (!matcher.matches()
                            || (numberOfSimulations = Integer.parseInt(line)) <= 0) {
                        System.out.println("Error: Wrong line for number of simulations: " + line);
                        System.exit(1);
                    }
                    firstLine = false;
                } else {
                    Matcher matcher = aircraftPattern.matcher(line);
                    if (matcher.matches()) {
                        Flyable newAircraft = AircraftFactory.newAircraft(matcher.group(1), matcher.group(2), Integer.parseInt(matcher.group(3)), Integer.parseInt(matcher.group(4)), Integer.parseInt(matcher.group(5)));
                        newAircraft.registerTower(mainTower);
                    } else {
                        System.out.println("Error in line#" + lineNumber + ": " + line);
                        System.exit(1);
                    }
                }
            }

            if (firstLine) {
                System.out.println("Error: Empty file!");
                System.exit(1);
            } else if (mainTower.getObserversSize() == 0) {
                System.out.println("Error: Aircraft is not specified!");
                System.exit(1);
            }
            for (int i = 0; i < numberOfSimulations; i++) {
                mainTower.changeWeather();
            }


        } catch (FileNotFoundException e) {
            System.out.println("Error: Can't find file: " + args[0]);
        } catch (IOException e) {
            System.out.println("Error when reading file: " + args[0]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Specify simulation file!");
        } catch (NumberFormatException e) {
            System.out.println("Error: too big number!");
        } catch (NullPointerException e) {
            System.out.println("Error: tower wasn't created!");
        } finally {
            FileLogger.getLogger().killLogger();
        }
    }
}
