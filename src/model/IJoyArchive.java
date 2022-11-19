package model;

import java.util.List;

public interface IJoyArchive {
  void addEntry(String entry, String... tags);

  void removeEntry();

  void addTag(String tag);

  void removeTag(String tag);

  void deleteAllCertainTag(String tag);

  List<String> getHighlights(String startDate, String endDate);

  List<String> getAllCertainTag(String tag);

  /* Will just give the file to controller if it's media */
  String generateEntry();
}

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