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

  public Search() {

    setSize(500, 300);
    setLocation(200, 200);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

  }

  @Override
  public void addFeatures(IFeatures features) {
    //searchButton.addActionListener(evt -> features.search());
  }

  @Override
  public void resetFocus() {

  }
}
