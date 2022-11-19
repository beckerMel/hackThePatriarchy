package controller;

import javax.naming.directory.SearchResult;
import model.IModel;
import view.EntryFrame;
import view.GetHappiness;
import view.GraphFrame;
import view.Highlights;
import view.IView;
import view.RemoveFrame;
import view.Search;

/**
 * This class implements the Controller interface.
 */
public class Controller implements IFeatures {

  private IModel model;
  private IView view;


  public Controller(IModel m) {
    model = m;
  }

  public void setView(IView v) {
    view = v;
    //provide view with all the callbacks
    view.addFeatures(this);
  }

  @Override
  public void switchToMainPage() {
    // TODO
  }

  @Override
  public void switchToAddEntryPage() {
    IView entryFrame = new EntryFrame();
    view = entryFrame;
  }

  @Override
  public void switchToRemoveEntryPage() {
    IView removeFrame = new RemoveFrame();
    view = removeFrame;
  }

  @Override
  public void switchToGetHappinessPage() {
    IView getHappinessFrame = new GetHappiness();
    view = getHappinessFrame;
  }

  @Override
  public void switchToChartPage() {
    IView graphFrame = new GraphFrame();
    view = graphFrame;
  }

  @Override
  public void switchToSearchPage() {
    IView searchPage = new Search();
    this.view = searchPage;
  }

  @Override
  public void switchToHighlightsPage()  {
    IView highlightsPage = new Highlights();
    this.view = highlightsPage;
  }

  @Override
  public void showSearchResult()  {
    // TODO
  }

  @Override
  public void showHighlightsResult()  {
    // TODO
  }

  @Override
  public void generateGraph(String startDate, String endDate, String attribute) {
    //TODO after get graph
  }

  @Override
  public void addEntry(String date, String happiness, String stress, String sleep, String energy, String water) {
    model.addMoodTrackerEntry(date, Integer.parseInt(happiness), Integer.parseInt(stress), Integer.parseInt(sleep),
            Integer.parseInt(energy), Integer.parseInt(water));
  }

  @Override
  public void removeEntry(String date) {
    model.removeMoodTrackerEntry(date);
  }

  @Override
  public void exitProgram() {
    System.exit(0);
  }
}
