package model;

public interface FileHandler<T> {
  void readFile(T returnObject, String filename) throws IllegalArgumentException;

  void saveToFile(T storeObject, String workingDirectory) throws IllegalArgumentException;
}
