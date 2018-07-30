package ua.avaj.simulator;

public class Coordinates {
  private int longitude;
  private int latitude;
  private int height;

    Coordinates(int longitude, int latitude, int height) throws BadCoordinates {
        if (height > 100 || height <= 0)
            throw new BadCoordinates("Error: Wrong coordinates: " + height);
    this.longitude = longitude;
    this.latitude = latitude;
    this.height = height;
  }

  public int getLongitude() {
    return longitude;
  }

  public void setLongitude(int longitude) {
    this.longitude = longitude;
  }

  public int getLatitude() {
    return latitude;
  }

  public void setLatitude(int latitude) {
    this.latitude = latitude;
  }

  public int getHeight() {
    return height;
  }

  public void setHeight(int height) {
    this.height = height;
  }

    class BadCoordinates extends Exception {
        public BadCoordinates() {
        }
        public BadCoordinates(String message) {
            super(message);
        }
    }
}
