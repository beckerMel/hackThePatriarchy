package view;

import controller.Features;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class GetHappiness extends JFrame implements IView {

  private JLabel display;
  private JButton searchButton, highlightsButton, homeButton;
  private JTextField input;

  @Override
  public String getInputString() {
    return null;
  }

  @Override
  public void clearInputString() {

  }

  @Override
  public void addFeatures(Features features) {

  }

  @Override
  public void resetFocus() {

  }
}
