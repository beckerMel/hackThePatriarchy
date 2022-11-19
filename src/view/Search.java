package view;

import controller.IFeatures;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Search extends JFrame implements IView {

  private JLabel display;
  private JButton searchButton, homeButton;
  private JTextField input;

  @Override
  public String getInputString() {
    return null;
  }

  @Override
  public void clearInputString() {

  }

  @Override
  public void addFeatures(IFeatures features) {

  }

  @Override
  public void resetFocus() {

  }
}
