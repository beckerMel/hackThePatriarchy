package view;

import controller.Features;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class JFrameView extends JFrame implements IView {

  private JLabel display;
  private JButton chartButton, entryButton, removeEntry, happinessButton, exitButton;
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
