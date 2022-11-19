package model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public interface IModel {

  public void addJAEntry(String entryName, String entryText, String... entryTags)
          throws IllegalArgumentException;


  public String getSampleAffirmations();


  public void removeJAEntry(String entryName) throws IllegalArgumentException;


  public void addTag(String entryName, String tag) throws IllegalArgumentException;


  public String getJAEntry(String entryName);


  public void removeTag(String entryName, String tag) throws IllegalArgumentException;


  public void removeTags(String entryName) throws IllegalArgumentException;

  /* Delete every entry under a certain tag */

  public void deleteAllCertainTag(String tag);


  public List<String> getHighlights(String startDate, String endDate);


  public String getEntryTags(String entryName);

  public void addHighlight(String date, String text) throws IllegalArgumentException;


  public void removeHighlight(String date) throws IllegalArgumentException;


  public List<String> getAllCertainTag(String tag);


  public String generateEntry();


  public String generateAffirmation();


  public int getNumJoyArchiveEntries();


  public String toGraph(String startDate, String endDate,
                      DataSource api, String feature) throws IllegalArgumentException;


  public void setDirectory(String directory);


  public void setNumMoodTrackerEntries(int numOfEntries);


  public void setTrackerName(String trackerName);


  public String getTrackerName();


  public int getNumMoodTrackerEntries();


  public void setMoodTrackerEntries(ArrayList<Entry> entries);


  public ArrayList<Entry> getMoodTrackerEntries();

  public IMoodTracker createFromFile(String filepath) throws IllegalArgumentException;
  public void addMoodTrackerEntry(String date, int happiness, int stress, int sleep, int energy,
                                  int water) throws RuntimeException;


  public void removeMoodTrackerEntry(String date) throws IllegalArgumentException;


  public boolean checkValidDateFormat(String name);


  public void readFile(String filename);

  public void saveToFile(String workingDirectory);
}
