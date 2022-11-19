package model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CsvHandler implements FileHandler {

  @Override
  public void readFile(MoodTracker moodTracker, String filename) {

  }

  @Override
  public void saveToFile(MoodTracker moodTracker, String workingDirectory) {
    int i = 0;
    workingDirectory = workingDirectory.replaceAll("\\\\", "/");
    if (workingDirectory.charAt(workingDirectory.length() - 1) != '/') {
      workingDirectory += '/';
    }
    moodTracker.setDirectory(workingDirectory);


    /* If the filename already exists in the directory, we add a (n) to the end of it to give
     * it a new name - e.g. portfolio.csv and portfolio(1).csv */
    String loc = workingDirectory + moodTracker.getTrackerName();
    String tempName = "" + moodTracker.getTrackerName();//original
    String tempLoc = loc;//original
    File temp = new File(loc + ".csv");
    int ctr = 1;
    while (temp.isFile()) {
      loc = tempLoc + "(" + ctr + ")";
      temp = new File(loc + ".csv");
      moodTracker.setTrackerName(tempName + "(" + ctr + ")");
      ctr++;
    }
    try {
      temp.createNewFile();
    } catch (IOException e) {
      throw new IllegalArgumentException("Could not create new file");
    }
    int ii = 0;

    FileWriter writer = null;
    ArrayList<Entry> ent = moodTracker.getEntries();
    try {
      writer = new FileWriter(loc + ".csv");
      while (ii < moodTracker.getNumOfEntries()) {
        Entry thisLine = ent.get(ii);
        writer.write(thisLine.getDate() + "," + thisLine.getHappiness() + ","
                + thisLine.getStress() + ","
                + thisLine.getSleep() + ","
                + thisLine.getEnergy() + "\r");
        ii++;
      }
      writer.close();

    } catch (IOException e) {
      e.printStackTrace();

  }
}
