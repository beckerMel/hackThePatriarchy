package view;

import controller.IFeatures;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GetHappiness extends JFrame implements IView {

  private JLabel display;
  private JButton searchButton, highlightsButton, homeButton;

  @Override
  public String getInputString() {
    return null;
  }

  @Override
  public void clearInputString() {

  }

  @Override
  public void addFeatures(IFeatures features) {

    //searchButton.addActionListener(evt -> features.searchInput(input.));

  }

  @Override
  public void resetFocus() {

  }
}
