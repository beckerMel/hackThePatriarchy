package model;

import java.io.File;
import java.util.ArrayList;

public class MoodTracker implements IMoodTracker {

  String trackerName;
  String directory;
  int numOfEntries;
  ArrayList<Entry> entries;

  public MoodTracker() {
    trackerName = "";
    directory = "";
    numOfEntries = 0;
    entries = new ArrayList<>();
  }
  public MoodTracker(FileHandler ff, String filename) {
    trackerName = "";
    directory = "";
    numOfEntries = 0;
    entries = new ArrayList<>();
    File f = new File(filename);
    if (!(f.exists())) {
      throw new IllegalArgumentException("Invalid filepath/name provided");
    }
    entries = new ArrayList<Entry>();
    numOfEntries = 0;
    String fixedName = filename.replaceAll("\\\\", "/");
    try {
      int length = fixedName.length();
      int firstIndex = fixedName.lastIndexOf("/") + 1;
      int lastIndex = fixedName.lastIndexOf(".");
      /* Get only the name of the file, outside the path and file type, and make it the name of
       * this portfolio */
      trackerName = fixedName.substring(firstIndex, lastIndex);
    } catch (StringIndexOutOfBoundsException e) {
      throw new IllegalArgumentException("Could not extract filename");
    }

    if (f.length() == 0) {
      throw new IllegalArgumentException("File is empty");
    }
    ff.readFile(this, filename);
  }

  @Override
  public IMoodTracker createFromFile(FileHandler f, String filepath) throws IllegalArgumentException {
    return new MoodTracker(f, filepath);
  }

}
