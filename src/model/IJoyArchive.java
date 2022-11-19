package model;

import java.util.List;

public interface IJoyArchive {
  void addEntry(String entry, String... tags);

  void addAffirmation(String text);

  void removeAffirmation(String text);

  /* Return the affirmations that users haven't pre-selected yet */
  String getSampleAffirmations();

  void removeEntry(String text);

  void addTag(String tag);

  String getEntry();

  void removeTag(String tag);

  void deleteAllCertainTag(String tag);

  List<String> getAllCertainTag(String tag);

  /* Will just give the file to controller if it's media */
  String getRandomEntry();

  String getRandomAffirmation();

  List<String> getHighlights(String startDate, String endDate);
}