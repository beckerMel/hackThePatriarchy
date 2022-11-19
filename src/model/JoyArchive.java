package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/*

  List<String> affirmations

  static int nextEntryId

  List<Date, String> highlights;

  Tag
    - String name
    - List<int> // entry ids

  void get
 */

/* holds all the entries */
/*
  HashMap<int, entry>


  inner class: entries
      - static int nextId
      - int id
      - String content
      - boolean isFile


 */
public class JoyArchive implements IJoyArchive {
  private List<String> affirmations;

  private int nextEntryId;

  private Map<Calendar, String> highlights;

  private class Tag {
    String name;
    List<String> entryIds;

    private Tag(String name) {
      this.name = name;
      entryIds = new LinkedList<String>();
    }

    private Tag(String tagName, String entryName) {
      this.name = name;
      entryIds = new LinkedList<String>();
      entryIds.add(entryName);
    }

    private void addEntry(String entryName) {
      if (!entryIds.contains(entryName)) {
        entryIds.add(entryName);
      }
    }

    private void removeEntry(String entryName) {
      entryIds.remove(entryName);
    }

    private int getNumEntries() {
      return entryIds.size();
    }

    private String getEntry(int index) {
      return entryIds.get(index);
    }

    private void removeAll() {
      entryIds = new LinkedList<>();
    }
  }

  private Map<String, Tag> tags;

  private Map<String, Entry> entries;

  private class Entry {
    private String content;

    private String name;
    private boolean isFile;

    private List<String> tags;

    private Entry(String name, String content) {
      this.name = name;
      this.tags = new LinkedList<>();
      this.content = content;
      File file = new File(content);
      isFile = file.isFile();
    }

    private String getName() {
      return this.name;
    }

    private void addTag(String name) {
      if (!tags.contains(name)) {
        tags.add(name);
      }
    }



    private void removeTag(String name) {
      tags.remove(name);
    }

    private int getNumTags() {
      return tags.size();
    }

    private String getTag(int i) {
      return tags.get(i);
    }

    private void removeAll() {
      tags = new LinkedList<>();
    }
  }

  public JoyArchive() {
    affirmations = new LinkedList<>();
    initializeAffirmations();
    tags = new HashMap<>();
    entries = new HashMap<>();
    nextEntryId = 0;
    highlights = new HashMap<>();
  }

  protected void initializeAffirmations() {
    Scanner scan;
    try {
      scan = new Scanner(new File("res/premade-affirmationsS"));
    } catch (IOException e) {
      throw new RuntimeException("Could not open premade-affirmations.txt");
    }
    while (scan.hasNextLine()) {
      affirmations.add(scan.nextLine());
    }
  }

  protected int randomNumber(int minVal, int maxVal) {
    int range = maxVal - minVal + 1;
    return (int) Math.floor((Math.random() * range) + minVal);
  }

  protected boolean tagExists(String tag) {
    return tags.get(tag) != null;
  }

  @Override
  public void addJAEntry(String entryName, String entryText, String... entryTags)
          throws IllegalArgumentException {
    if (entries.get(entryName) != null) {
      throw new IllegalArgumentException("Entry under the given name already exists.");
    }
    Entry newEntry = new Entry(entryName, entryText);
    nextEntryId++;
    /* Add tags if applicable */
    if (entryTags != null) {
      for (String tag : entryTags) {
        Tag thisTag = tags.get(tag);
        if (thisTag == null) {
          thisTag = new Tag(tag, newEntry.getName());
        } else {
          thisTag.addEntry(newEntry.getName());
        }
        newEntry.addTag(tag);
      }
    }
    entries.put(entryName, newEntry);
  }

  @Override
  public String getSampleAffirmations() {
    return null;
  }

  /**
   * Remove the given entry from the list of entries and remove all the tags associated with it.
   *
   * @param entryName
   * @throws IllegalArgumentException
   */
  @Override
  public void removeJAEntry(String entryName) throws IllegalArgumentException {
    Entry thisEntry = entries.get(entryName);
    if (thisEntry == null) {
      throw new IllegalArgumentException("No entry found under the given name.");
    }
    int numTags = thisEntry.getNumTags();

    /* Remove the entry from all of its tags */
    for (int i = 0; i < numTags; i++) {
      String tagName = thisEntry.getTag(i);
      Tag thisTag = tags.get(tagName);
      thisTag.removeEntry(entryName);
    }
    entries.remove(entryName);
  }

  @Override
  public void addTag(String entryName, String tag) throws IllegalArgumentException {
    Entry thisEntry = entries.get(entryName);
    if (thisEntry == null) {
      throw new IllegalArgumentException("No entry found under supplied name");
    }
    thisEntry.addTag(tag);
  }

  @Override
  public String getJAEntry(String entryName) {
    Entry thisEntry = entries.get(entryName);
    return thisEntry.content;
  }

  @Override
  public void removeTag(String entryName, String tag) throws IllegalArgumentException {
    Entry thisEntry = entries.get(entryName);
    if (thisEntry == null) {
      throw new IllegalArgumentException("No entry found under supplied name");
    }
    thisEntry.removeTag(tag);
  }

  @Override
  public void removeTags(String entryName) throws IllegalArgumentException {
    Entry thisEntry = entries.get(entryName);
    if (thisEntry == null) {
      throw new IllegalArgumentException("No entry found under supplied name");
    }
    int numTags = thisEntry.getNumTags();
    for (int i = 0; i < numTags; i++) {
      String tagName = thisEntry.getTag(i);
      Tag thisTag = tags.get(tagName);
      thisTag.removeEntry(entryName);
    }
    thisEntry.removeAll();
  }

  /* Delete every entry under a certain tag */
  @Override
  public void deleteAllCertainTag(String tag) {
    Tag thisTag = tags.get(tag);
    int numEntries = thisTag.getNumEntries();
    for (int i = 0; i < numEntries; i++) {
      /* Get each entry and remove it from every tag's list, then remove it */
      String entryName = thisTag.getEntry(i);
      removeTags(entryName);
      entries.remove(entryName);
    }
    tags.remove(tag);
  }

  protected Date stringToDate(String date) throws IllegalArgumentException {
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    Date date1 = null;
    try {
      date1 = formatter.parse(date);
    } catch (ParseException e) {
      throw new IllegalArgumentException("Invalid date format - use yyyy-mm-dd");
    }
    return date1;
  }

  @Override
  public List<String> getHighlights(String startDate, String endDate)
          throws IllegalArgumentException {
    Calendar start = stringToCalendar(startDate);
    Calendar end = stringToCalendar(endDate);

    List<String> returnList = new LinkedList<>();

    if (end.before(start)) {
      throw new IllegalArgumentException("Start date is after end date");
    }
    Calendar currDay = start;
    while(!start.after(end)) {
      String thisHighlight = highlights.get(currDay);
      if (highlights == null) {
        continue;
      }
      returnList.add(thisHighlight);
    }
    return returnList;
  }

  @Override
  public String getEntryTags(String entryName) {
    Entry thisEntry = entries.get(entryName);
    int length = thisEntry.tags.size();
    StringBuilder entryTags = new StringBuilder("");
    for (int i = 0; i < length; i++) {
      entryTags.append(thisEntry.tags.get(i));
      if (i != length - 1) {
        entryTags.append(" ");
      } else {
        entryTags.append("\n");
      }
    }

    return entryTags.toString();
  }

  @Override
  public void addHighlight(String date, String text) throws IllegalArgumentException {
    Calendar entryDate = stringToCalendar(text);
    highlights.put(entryDate, text);
  }

  protected Calendar stringToCalendar(String dateString) {
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    Date date = null;
    try {
      date = formatter.parse(dateString);
    } catch (ParseException e) {
      throw new IllegalArgumentException("Invalid date format - use yyyy-mm-dd");
    }
    Calendar cal = Calendar.getInstance();
    cal.setTime(date);
    return cal;
  }

  @Override
  public void removeHighlight(String date) throws IllegalArgumentException {
    Calendar entryDate = stringToCalendar(date);
    highlights.remove(entryDate);
  }

  @Override
  public List<String> getAllCertainTag(String tag) {
    Tag thisTag = tags.get(tag);
    return thisTag.entryIds;
  }

  @Override
  public String generateEntry() {
    Entry [] entryArray = (Entry[])entries.values().toArray();
    int index = randomNumber(0, entryArray.length - 1);
    Entry thisEntry = entryArray[index];
    return thisEntry.content;
  }

  @Override
  public String generateAffirmation() {
    int index = randomNumber(0, affirmations.size() - 1);
    return affirmations.get(index);
  }

  @Override
  public int getNumEntries() {
    return entries.size();
  }
}
