package model;

public interface IMoodTracker {
  IMoodTracker createFromFile(FileHandler f, String filepath) throws IllegalArgumentException;

  void addEntry(String date, int happiness, int stress, int sleep, int energy)
          throws RuntimeException;

  void removeEntry(String date) throws IllegalArgumentException;

  public boolean checkValidDateFormat(String name);
}
