package view;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

import controller.IFeatures;

public class MainPageFrame extends JFrame implements IView {
  private JLabel display;
  private JButton addEntryButton, removeEntryButton, getHappinessButton, chartButton;

  public MainPageFrame() {
    super("Home Page");

    setSize(500, 300);
    setLocation(200, 200);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    this.setLayout(new FlowLayout());

    display = new JLabel("Hi!");
    this.add(display);

    addEntryButton = new JButton("Add Entry");
    addEntryButton.setActionCommand("Add Entry Button");
    this.add(addEntryButton);

    removeEntryButton = new JButton("Remove Entry");
    removeEntryButton.setActionCommand("Remove Entry Button");
    this.add(removeEntryButton);

    getHappinessButton = new JButton("Get Happiness");
    getHappinessButton.setActionCommand("Get to Happiness Page");
    this.add(getHappinessButton);

    chartButton = new JButton("Get chart");
    chartButton.setActionCommand("Get to Chart Page");
    this.add(chartButton);

    pack();
    setVisible(true);
  }


  @Override
  public void addFeatures(IFeatures features) {
    addEntryButton.addActionListener(evt -> features.switchToAddEntryPage());
    removeEntryButton.addActionListener(evt -> features.switchToRemoveEntryPage());
    getHappinessButton.addActionListener(evt -> features.switchToGetHappinessPage());
    chartButton.addActionListener(evt -> features.switchToChartPage());
  }

  /*
  In order to make this frame respond to keyboard events, it must be within strong focus.
  Since there could be multiple components on the screen that listen to keyboard events,
  we must set one as the "currently focussed" one so that all keyboard events are
  passed to that component. This component is said to have "strong focus".

  We do this by first making the component focusable and then requesting focus to it.
  Requesting focus makes the component have focus AND removes focus from whoever had it
  before.
*/
  @Override
  public void resetFocus() {
    this.setFocusable(true);
    this.requestFocus();
  }
}
