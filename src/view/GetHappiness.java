package view;

import controller.IFeatures;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GetHappiness extends JFrame implements IView {

  private JLabel display;
  private JButton searchButton, highlightsButton, homeButton;

  public GetHappiness() {

    setSize(500, 300);
    setLocation(200, 200);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


  }

  @Override
  public void addFeatures(IFeatures features) {
    searchButton.addActionListener(evt -> features.switchToSearchPage());
    highlightsButton.addActionListener(evt -> features.switchToHighlightsPage());
    homeButton.addActionListener(evt -> features.switchToMainPage());
  }

  @Override
  public void resetFocus() {

  }
}
