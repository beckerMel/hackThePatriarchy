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
    setSize(500, 300);
    setLocation(200, 200);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

  }

  @Override
  public void addFeatures(IFeatures features) {
    enterButton.addActionListener(evt -> features.showHighlightsResult());
    homeButton.addActionListener(evt -> features.switchToMainPage());
  }

  @Override
  public void resetFocus() {
    this.setFocusable(true);
    this.requestFocus();
  }
}
