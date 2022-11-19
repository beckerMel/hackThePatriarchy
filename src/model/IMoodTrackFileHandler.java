package model;

public interface IMoodTrackFileHandler {

  void readFile(MoodTracker returnObject, String filename);

  void saveToFile(MoodTracker storeObject, String workingDirectory);

  boolean isCsv(String filename);
}
