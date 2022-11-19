package model;

public interface IMoodTracker {
  IMoodTracker createFromFile(FileHandler f, String filepath) throws IllegalArgumentException;
}
