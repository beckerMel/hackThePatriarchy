package controller;

import javax.naming.directory.SearchResult;
import model.IModel;
import view.EntryFrame;
import view.GetHappiness;
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
  // TO BE ADDED
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
  public void exitProgram() {
    System.exit(0);
  }
}
