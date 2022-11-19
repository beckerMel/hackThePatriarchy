package model;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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

  private Map<Date, String> highlights;

  private class Tag {
    String name;
    List<Integer> entryIds;

    private Tag(String name) {
      this.name = name;
      entryIds = new LinkedList<Integer>();
    }

    private Tag(String name, int id) {
      this.name = name;
      entryIds = new LinkedList<Integer>();
      entryIds.add(id);
    }

    private void addId(int id) {
      entryIds.add(id);
    }

    private void removeId(int id) {
      entryIds.remove(id);
    }
  }

  private Map<String, Tag> tags;

  private List<Entry> entries;

  private class Entry {
    Integer id;
    String content;
    boolean isFile;

    private Entry(int id, String content) {
      this.id = id;
      this.content = content;
      File file = new File(content);
      isFile = file.isFile();
    }

      private int getId() {
        return this.id;
      }
  }

  public JoyArchive() {
    affirmations = new LinkedList<String>();
    tags = new HashMap<String, Tag>();
    entries = new LinkedList<Entry>();
    nextEntryId = 0;
    highlights = new HashMap<Date, String>();
  }


  @Override
  public void addEntry(String entry, String... tags) {
    Entry newEntry = new Entry(nextEntryId, entry);
    nextEntryId++;
    for (String tag : tags) {
      Tag newTag = new Tag(tag, newEntry.getId());
    }
  }

  @Override
  public void removeEntry() {

  }

  @Override
  public void addTag(String tag) {

  }

  @Override
  public void removeTag(String tag) {

  }

  @Override
  public void deleteAllCertainTag(String tag) {

  }

  @Override
  public List<String> getHighlights(String startDate, String endDate) {
    return null;
  }

  @Override
  public List<String> getAllCertainTag(String tag) {
    return null;
  }

  @Override
  public String generateEntry() {
    return null;
  }
}
