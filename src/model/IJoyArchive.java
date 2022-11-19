package model;

import java.util.List;

public interface IJoyArchive {
  void addJAEntry(String entryName, String entryBody, String... tags);

  /* Return the affirmations that users haven't pre-selected yet */
  String getSampleAffirmations();

  void removeJAEntry(String text);

  void addTag(String entryName, String tag);

  String getJAEntry(String entryName);

  void removeTag(String entryName, String tag);

  void deleteAllCertainTag(String tag);

  void removeTags(String entryName);

  List<String> getAllCertainTag(String tag);

  String generateEntry();

  String generateAffirmation();

  List<String> getHighlights(String startDate, String endDate);

  List<String> getEntryTags(String entryName);

  void addHighlight(String date, String text);

  void removeHighlight(String date);
}