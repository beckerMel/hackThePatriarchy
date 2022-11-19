package model;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Model implements IModel {
  private IJoyArchive ja;
  private IMoodTracker mt;

  private IGraphService gs;

  private IMoodTrackFileHandler fh;

  public Model(IJoyArchive ja, IMoodTracker mt, IGraphService gs, IMoodTrackFileHandler fh) {
    this.ja = ja;
    this.mt = mt;
    this.gs = gs;
    this.fh = fh;
  }

  @Override
  public void addJAEntry(String entryName, String entryText, String... entryTags)
          throws IllegalArgumentException {
    ja.addJAEntry(entryName, entryText, entryTags);
  }

  @Override
  public String getSampleAffirmations() {
    return null;
  }

  @Override
  public void removeJAEntry(String entryName) throws IllegalArgumentException {
    ja.removeJAEntry(entryName);
  }

  @Override
  public void addTag(String entryName, String tag) throws IllegalArgumentException {
    ja.addTag(entryName, tag);
  }

  @Override
  public String getJAEntry(String entryName) {
    return ja.getJAEntry(entryName);
  }

  @Override
  public void removeTag(String entryName, String tag) throws IllegalArgumentException {
    ja.removeTag(entryName, tag);
  }

  @Override
  public void removeTags(String entryName) throws IllegalArgumentException {
    ja.removeTags(entryName);
  }

  /* Delete every entry under a certain tag */
  @Override
  public void deleteAllCertainTag(String tag) {
    ja.deleteAllCertainTag(tag);
  }

  @Override
  public List<String> getHighlights(String startDate, String endDate) {
    return ja.getHighlights(startDate, endDate);
  }

  @Override
  public String getEntryTags(String entryName) {
    return ja.getEntryTags(entryName);
  }

  @Override
  public void addHighlight(String date, String text) throws IllegalArgumentException {
    ja.addHighlight(date, text);
  }

  @Override
  public void removeHighlight(String date) throws IllegalArgumentException {
    ja.removeHighlight(date);
  }

  @Override
  public List<String> getAllCertainTag(String tag) {
    return ja.getAllCertainTag(tag);
  }

  @Override
  public String generateEntry() {
    return ja.generateEntry();
  }

  @Override
  public String generateAffirmation() {
    return ja.generateAffirmation();
  }

  @Override
  public int getNumJoyArchiveEntries() {
    return ja.getNumEntries();
  }

  @Override
  public LinkedHashMap<String, Integer> toGraph(String startDate, String endDate,
                                                DataSource api, String feature) throws IllegalArgumentException {
    return gs.toGraph(startDate, endDate, mt, api, feature);
  }

  @Override
  public void setDirectory(String directory) {
    mt.setDirectory(directory);
  }

  @Override
  public void setNumMoodTrackerEntries(int numOfEntries) {
    mt.setNumOfEntries(numOfEntries);
  }

  @Override
  public void setTrackerName(String trackerName) {
    mt.setTrackerName(trackerName);
  }

  @Override
  public String getTrackerName() {
    return mt.getTrackerName();
  }

  @Override
  public int getNumMoodTrackerEntries() {
    return mt.getNumOfEntries();
  }

  @Override
  public void setMoodTrackerEntries(ArrayList<Entry> entries) {
    mt.setEntries(entries);
  }

  @Override
  public ArrayList<Entry> getMoodTrackerEntries() {
    return mt.getEntries();
  }

  @Override
  public IMoodTracker createFromFile(String filepath)
          throws IllegalArgumentException {
    return mt.createFromFile(fh, filepath);
  }

  @Override
  public void addMoodTrackerEntry(String date, int happiness, int stress, int sleep, int energy, int water)
          throws RuntimeException {
    mt.addEntry(date, happiness, stress, sleep, energy, water);
  }

  @Override
  public void removeMoodTrackerEntry(String date) throws IllegalArgumentException {
    mt.removeEntry(date);
  }

  @Override
  public boolean checkValidDateFormat(String name) {
    return mt.checkValidDateFormat(name);
  }

  @Override
  public void readFile(String filename) {
    fh.readFile(mt, filename);
  }

  @Override
  public void saveToFile(String workingDirectory) {
    fh.saveToFile(mt, workingDirectory);
  }

  public void addEntry(String date, int happiness, int stress, int sleep, int energy, int water) {
    mt.addEntry(date, happiness, stress, sleep, energy, water);
  }

  public void removeEntry(String date) {
    mt.removeEntry(date);
  }


}
