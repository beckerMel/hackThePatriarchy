package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class DataSource {
  int happiness;
  int stress;
  int sleep;
  int energy;
  int water;

  public void getValuesFromFile(String date) throws IllegalArgumentException {
    String splitBy = ",";
    String line = "";
    try (BufferedReader br = new BufferedReader(new
            FileReader("../res/trackingData.csv"))) {
      while ((line = br.readLine()) != null) {
        String[] allEntryInfo = line.split(splitBy);
        if (allEntryInfo[0].equals(date)) {
          happiness = Integer.parseInt(allEntryInfo[1]);
          stress = Integer.parseInt(allEntryInfo[2]);
          sleep = Integer.parseInt(allEntryInfo[3]);
          energy = Integer.parseInt(allEntryInfo[4]);
          water = Integer.parseInt(allEntryInfo[5]);
        }
      }
    } catch (IOException ex) {
      throw new IllegalArgumentException("Incorrectly formatted file provided");
    }
  }

  public int getHappiness(String date)
          throws IllegalArgumentException {
    if(isDateInDB( date)) {
      getValuesFromFile(date);
      return happiness;
    }
    else {
      return 0;
    }
  }

  public int getStress(String date)
          throws IllegalArgumentException {
    if(isDateInDB( date)) {
      getValuesFromFile(date);
      return stress;
    }
    else {
      return 0;
    }
  }

  public int getSleep(String date)
          throws IllegalArgumentException {
    if(isDateInDB( date)) {
      getValuesFromFile(date);
      return sleep;
    }
    else {
      return 0;
    }
  }

  public int getEnergy(String date)
          throws IllegalArgumentException {
    if(isDateInDB( date)) {
      getValuesFromFile(date);
      return energy;
    }
    else {
      return 0;
    }
  }

  public int getWater(String date)
          throws IllegalArgumentException {
    if(isDateInDB( date)) {
      getValuesFromFile(date);
      return water;
    }
    else {
      return 0;
    }
  }


  public boolean isDateInDB(String date) throws IllegalArgumentException {
    String splitBy = ",";
    String line = "";
    try (BufferedReader br = new BufferedReader(new
            FileReader("../res/trackingData.csv"))) {
      while ((line = br.readLine()) != null) {
        String[] allEntryInfo = line.split(splitBy);
        if (allEntryInfo[0].equals(date)) {
          return true;
        }

      }
    } catch (IOException e) {
      throw new IllegalArgumentException(e);
    }
    return false;
  }
}