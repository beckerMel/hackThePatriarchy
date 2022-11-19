package view;

import controller.IFeatures;

public interface IView {

  String getInputString();

  void clearInputString();

  void addFeatures(IFeatures features);

  void resetFocus();

}
