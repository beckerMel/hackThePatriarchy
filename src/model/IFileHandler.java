package model;

public interface IFileHandler<T> {
  void readFile(T returnObject, String filename);

  void saveToFile(T storeObject, String workingDirectory);

  boolean isCsv(String filename);
}
