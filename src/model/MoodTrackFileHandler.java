package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class MoodTrackFileHandler implements FileHandler {

  protected boolean isCsv(String filename) {
    int dot = filename.lastIndexOf(".");
    if (dot == -1) {
      return false;
    }
    return (filename.substring(dot + 1).equals("csv"));
  }
  @Override
  public void readFile(MoodTracker moodTracker, String filename) {
    if (!isCsv(filename)) {
      throw new IllegalArgumentException("Invalid filepath/name provided");
    }
    String line = "";
    String splitBy = ",";
    Entry temp;
    ArrayList<Entry> stocks = new ArrayList<Entry>();
    int numStocks = moodTracker.getNumOfEntries();

    /* Set the directory that the portfolio is being stored at. */
    String directory = filename.replaceAll("\\\\", "/");
    int directoryEnd = directory.lastIndexOf('/');
    directory = directory.substring(0, directoryEnd + 1);
    moodTracker.setDirectory(directory);
    moodTracker.setTrackerName(directory.substring(directoryEnd ));

    try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
      while ((line = br.readLine()) != null) {
        String[] allStockInfo = line.split(splitBy);
        temp = new Entry(allStockInfo[0], Double.parseDouble(allStockInfo[1]),
                allStockInfo[2], allStockInfo[3], Double.parseDouble(allStockInfo[4]));
        stocks.add(temp);
        numStocks++;
      }
    } catch (IOException ex) {
      throw new IllegalArgumentException("Incorrectly formatted file provided");
    }

    moodTracker.setNumOfEntries(numStocks);
    moodTracker.setEntries(stocks);
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
                + thisLine.getEnergy() + "," + thisLine.getWater() + "\r");
        ii++;
      }
      writer.close();

    } catch (IOException e) {
      e.printStackTrace();

    }
  }
}
