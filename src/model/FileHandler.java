package model;

public interface FileHandler<T> {
  void readFile(T returnObject, String filename);

  void saveToFile(T storeObject, String workingDirectory);
}
