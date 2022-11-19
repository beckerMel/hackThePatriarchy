package view;

import controller.IFeatures;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Highlights extends JFrame implements IView {

  private JLabel display;
  private JButton enterButton, homeButton;
  private JTextField input;

  public Highlights() {

  }

  @Override
  public void addFeatures(IFeatures features) {
    //enterButton.addActionListener(evt -> features.showHighlights());
    //homeButton.addActionListener(evt -> feature.goHome());
  }

  @Override
  public void resetFocus() {

  }
}
