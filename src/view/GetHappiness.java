package view;

import controller.IFeatures;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GetHappiness extends JFrame implements IView {

  private JLabel display;
  private JButton searchButton, highlightsButton, homeButton;

  public GetHappiness() {

  }

  @Override
  public void addFeatures(IFeatures features) {
    //searchButton.addActionListener(evt -> features.searchFeatureSelected());
    //highlightsButton.addActionListener(evt -> features.highlightsFeatureSelected());
    //homeButton.addActionListener(evt -> feature.goHome());
  }

  @Override
  public void resetFocus() {

  }
}
