package view;
package view;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

import controller.IFeatures;

public class GraphFrame extends JFrame implements IView {
  private JButton getGraphButton;
  private JTextField startDate, endDate, attribute;

  public GraphFrame() {
    super("Tracking Page");

    setSize(500, 300);
    setLocation(200, 200);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    this.setLayout(new FlowLayout());

    getGraphButton = new JButton("Get Graph");
    getGraphButton.setActionCommand("Get Graph Button");
    this.add(getGraphButton);

    //the text-field
    startDate = new JTextField("Start Date", 10);
    this.add(startDate);

    endDate = new JTextField("End Date", 10);
    this.add(endDate);

    attribute = new JTextField("Attribute to graph", 10);
    this.add(attribute);

    pack();
    setVisible(true);
  }

  @Override
  public void addFeatures(IFeatures features) {
    getGraphButton.addActionListener(evt -> features.
            generateGraph(startDate.getText(), endDate.getText(), attribute.getText()));

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
