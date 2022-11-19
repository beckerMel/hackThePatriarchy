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

  @Override
  public void setDirectory(String directory) {
    this.directory = directory;
  }

  @Override
  public void setNumOfEntries(int numOfEntries) {
    this.numOfEntries = numOfEntries;
  }

  @Override
  public void setTrackerName(String trackerName) {
    this.trackerName = trackerName;
  }

  @Override
  public String getTrackerName() {
    return trackerName;
  }

  @Override
  public int getNumOfEntries() {
    return numOfEntries;
  }

  @Override
  public void setEntries(ArrayList<Entry> entries) {
    this.entries = entries;
  }

  @Override
  public ArrayList<Entry> getEntries() {
    return entries;
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

  @Override
  public void addEntry(String date, int happiness, int stress, int sleep, int energy, int water) throws IllegalArgumentException
  {
    boolean flag=false;
    if ( checkValidDateFormat(date)) {
      for(int i=0; i<numOfEntries; i++) {
        Entry tem = entries.get(i);
        if(tem.getDate().equals(date)) {
          flag=true;
        }
      }
    }
    else {
      throw new IllegalArgumentException();
    }

    if (!flag) {
      Entry temp = new Entry(date, happiness, stress, sleep, energy, water);
      entries.add(temp);
    }
  }

  @Override
  public void removeEntry(String date) throws IllegalArgumentException
  {
    boolean flag=false;
    if ( checkValidDateFormat(date)) {
      for(int i=0; i<numOfEntries; i++) {
        Entry tem = entries.get(i);
        if(tem.getDate().equals(date)) {
          flag=true;
          entries.remove(i);
        }
      }
    }
    else {
      throw new IllegalArgumentException();
    }

    if (!flag) {
      throw new IllegalThreadStateException();
      //the date wasnt found
    }
  }

  @Override
  public boolean checkValidDateFormat(String name) {
    if (name.equals("")) {
      return false;
    }
    int length = name.length();
    if (length != 10) {
      return false;
    }
    if ((name.charAt(4) != '-') || (name.charAt(7) != '-')) {
      return false;
    }
    String year = name.substring(0, 4);
    String mm = name.substring(5, 7);
    String dd = name.substring(8);
    try {
      int y = (int) (Integer.parseInt(year));
      int m = (int) Integer.parseInt(mm);
      int d = (int) Integer.parseInt(dd);
      int[] a = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
      if (!(y > 1000 && y <= 2022) || !(m >= 1 && m <= 12)) {
        return false;
      }
      if (!(a[m - 1] >= d && d > 0)) {
        return false;
      }
    } catch (NumberFormatException ex) {
      return false;
    }
    return true;
  }

}
