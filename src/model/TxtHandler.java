package model;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TxtHandler<StringBuilder> implements FileHandler<StringBuilder> {
  @Override
  public void readFile(StringBuilder returnObject, String filename) throws
          IllegalArgumentException {
    File file = new File(filename);
    if (!file.isFile()) {
      throw new IllegalArgumentException("This file is fake");
    }
    try {
      returnObject.setS
    } catch (IOException e) {

    }
  }

  @Override
  public void saveToFile(StringBuilder storeObject, String workingDirectory) throws
          IllegalArgumentException {
    File file = new File(workingDirectory);
    if (!file.isFile()) {
      throw new IllegalArgumentException("This file is fake");
    }

  }
}
