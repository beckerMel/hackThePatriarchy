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

    display = new JLabel("Get Highlights");
    this.add(display);

    input = new JTextField(20);
    this.add(input);

    enterButton = new JButton("Enter");
    this.add(enterButton);

    pack();
    setVisible(true);
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
