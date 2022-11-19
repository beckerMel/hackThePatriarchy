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

    display = new JLabel("Get Happiness");
    this.add(display);

    searchButton = new JButton("Search for an Entry");
    this.add(searchButton);

    highlightsButton = new JButton("Get Highlights");
    this.add(highlightsButton);

    homeButton = new JButton("Go to Home");
    this.add(homeButton);

    pack();
    setVisible(true);
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
