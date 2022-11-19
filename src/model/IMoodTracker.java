package model;

import java.util.ArrayList;

public interface IMoodTracker {
  void setDirectory(String directory);

  void setNumOfEntries(int numOfEntries);

  void setTrackerName(String trackerName);

  String getTrackerName();

  int getNumOfEntries();

  void setEntries(ArrayList<Entry> entries);

  ArrayList<Entry> getEntries();

  IMoodTracker createFromFile(IMoodTrackFileHandler f, String filepath) throws IllegalArgumentException;

  void addEntry(String date, int happiness, int stress, int sleep, int energy, int water)
          throws RuntimeException;

  void removeEntry(String date) throws IllegalArgumentException;

  public boolean checkValidDateFormat(String name);
}
