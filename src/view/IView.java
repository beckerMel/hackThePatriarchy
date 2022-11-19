package view;

import controller.Features;

public interface IView {

  String getInputString();

  void clearInputString();

  void addFeatures(Features features);

  void resetFocus();

}
