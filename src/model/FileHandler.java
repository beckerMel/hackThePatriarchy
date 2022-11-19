package model;

public interface FileHandler {
  void readFile(MoodTracker moodTracker, String filename);

  void saveToFile(MoodTracker moodTracker, String workingDirectory);
}
