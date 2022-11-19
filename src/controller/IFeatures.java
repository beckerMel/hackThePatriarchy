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
  void exitProgram();


}
