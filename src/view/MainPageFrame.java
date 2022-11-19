package view;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

import controller.Features;
import controller.IFeatures;

public class MainPageFrame extends JFrame implements IView {
  private JLabel display;
  private JButton addEntryButton, removeEntryButton, getHappinessButton, chartButton;
  private JFrame GetHappinessFrame = new GetHappiness();

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
    //addEntryButton.addActionListener(evt -> );
    //removeEntryButton.addActionListener(evt -> features.switchToRemoveEntryPage());
    getHappinessButton.addActionListener(evt -> this.setVisible(false));
    // chartButton.addActionListener(evt -> features.switchToChartPage());
  }



}
