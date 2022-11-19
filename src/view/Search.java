package view;

import controller.IFeatures;
import java.awt.FlowLayout;
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

    this.setLayout(new FlowLayout());

    display = new JLabel("Search for an Entry");
    this.add(display);

    input = new JTextField(20);
    this.add(input);

    searchButton = new JButton("Search");
    this.add(searchButton);

    pack();
    setVisible(true);
  }

  @Override
  public void addFeatures(IFeatures features) {
    searchButton.addActionListener(evt -> features.showSearchResult());
    homeButton.addActionListener(evt -> features.switchToMainPage());
  }

  @Override
  public void resetFocus() {

  }
}
