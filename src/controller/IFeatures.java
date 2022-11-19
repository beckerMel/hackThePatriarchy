package controller;


public interface IFeatures {
  void switchToMainPage();
  void switchToAddEntryPage();
  void switchToRemoveEntryPage();
  void switchToGetHappinessPage();
  void switchToChartPage();
  void switchToSearchPage();
  void showSearchResult();
  void switchToHighlightsPage();
  void showHighlightsResult();
  void generateGraph(String startDate, String endDate, String attribute);
  void addEntry(String date, String happiness, String stress, String sleep, String energy, String water);
  void removeEntry(String date);
  void exitProgram();



}
