package model;

import java.util.List;

public interface IJoyArchive {
  void addEntry(String entryName, String entryBody, String... tags);

  void addAffirmation(String text);

  void removeAffirmation(String entryName);

  /* Return the affirmations that users haven't pre-selected yet */
  String getSampleAffirmations();

  void removeEntry(String text);

  void addTag(String entryName, String tag);

  String getEntry();

  void removeTag(String entryName, String tag);

  void deleteAllCertainTag(String tag);

  void removeTags(String entryName);

  List<String> getAllCertainTag(String tag);

  /* Will just give the file to controller if it's media */
  String getRandomEntry();

  String getRandomAffirmation();

  List<String> getHighlights(String startDate, String endDate);

  List<String> getEntryTags(String entryName);
}