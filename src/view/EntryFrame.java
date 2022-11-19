package view;

import controller.Controller;
import controller.IFeatures;
import model.Entry;
import model.IModel;

import javax.swing.*;
import java.awt.*;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class EntryFrame extends JFrame implements IView{

    private JLabel display;
    private JButton addButton, mainPageButton, addHighlightButton;
    private JTextField dateFld, happinessFld, stressFld, sleepFld, energyFld, waterFld;
    private JTextField content, tag;


    /**
     * This is reflect the image of what the Entry Page
     */
    public EntryFrame() {
        setSize(500, 300);
        setLocation(200, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setLayout(new FlowLayout());

        display = new JLabel("Hello! Welcome to the Entry Page");
        this.add(display);

        //the text-field
        dateFld = new JTextField("Entry Date", 10);
        this.add(dateFld);

        happinessFld = new JTextField("Happiness Input", 10);
        this.add(happinessFld);

        stressFld = new JTextField("Stress Input", 10);
        this.add(stressFld);

        sleepFld = new JTextField("Sleep Input", 10);
        this.add(sleepFld);

        energyFld = new JTextField("Energy Input", 10);
        this.add(energyFld);

        waterFld = new JTextField("Water Input", 10);
        this.add(waterFld);

        content = new JTextField("Highlight", 50);
        this.add(content);

        tag = new JTextField("Highlight Tag", 50);
        this.add(tag);

        addButton = new JButton("Add Entry Mood Tracking");
        addButton.setActionCommand("Add Entry");

        addHighlightButton = new JButton("Add Entry Highlight");
        addHighlightButton.setActionCommand("Add Entry");
        

        mainPageButton = new JButton("Go Back to Home");
        mainPageButton.setActionCommand("Go to Main");

        pack();
        setVisible(true);
    }


    /**This is where we have the buttons and inputs that could be added and changed
     * @param features (adding the information necessary
     */
    @Override
    public void addFeatures(IFeatures features) {
        addButton.addActionListener(evt -> features.
                addMoodTrackerEntry(dateFld.getText(), happinessFld.getText(), sleepFld.getText(), stressFld.getText(),
                        energyFld.getText(), waterFld.getText()));

        mainPageButton.addActionListener(evt -> features.switchToMainPage());
        
        addHighlightButton.addActionListener(evt -> features.addHighlight(dateFld.getText(), content.getText(), tag.getText()));
    }

    /**
     * Focuses back due to JUnit format
     */
    @Override
    public void resetFocus() {
        this.setFocusable(true);
        this.requestFocus();
    }

    //putting this here so i can push
}
