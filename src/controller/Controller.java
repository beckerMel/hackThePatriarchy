package controller;

import model.IModel;
import view.IView;

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
  public void exitProgram() {
    System.exit(0);
  }
}
