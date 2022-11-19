package model;

public class FileHandler<T> implements IFileHandler<T>{
  @Override
  public void readFile(T returnObject, String filename) {

  }

  @Override
  public void saveToFile(T storeObject, String workingDirectory) {

  }

  @Override
  public boolean isCsv(String filename) {
    return false;
  }
}
