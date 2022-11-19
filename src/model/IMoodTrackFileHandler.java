package model;

public interface IMoodTrackFileHandler {

  void readFile(IMoodTracker returnObject, String filename);

  void saveToFile(IMoodTracker storeObject, String workingDirectory);

  boolean isCsv(String filename);
}
