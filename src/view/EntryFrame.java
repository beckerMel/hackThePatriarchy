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
    private JButton addEntryButton, removeEntryButton, goHomeButton, chartButton;
    private JFrame GetHappinessFrame = new GetHappiness();
    private InputStream input;


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
        input = System.in; //Takes in input of the entry

        /**
         * Button to hit out incase they didn't mean to hit the entry frame
         */
        goHomeButton = new JButton("Go Back to Home");
        goHomeButton.setActionCommand("Go to Main");

        pack();
        setVisible(true);
    }


    /**This is where we have the buttons and inputs that could be added and changed
     * @param features (adding the information necessary
     */
    @Override
    public void addFeatures(IFeatures features) {
        LocalDateTime today = LocalDateTime.now();
        String dateToString = today.toString();
        IModel model = (IModel) new Entry(dateToString);
        Controller controller = new Controller(model);
        IView view = new MainPageFrame();
        controller.setView(view);

        Scanner scan = new Scanner(input);

        /**
         * The way this is set up is so painful but is easiest quickest way to code due to time constraints
         * Assuming all 5 things will be inputted line by line
         */
        if (scan.hasNext()) {
            //Adds the string input
            //String date
            String date = scan.next();

            //happiness
            int happiness;
            int stress = 0;
            if (scan.hasNext()) {
                happiness = Integer.parseInt(scan.next());

                //stress
                if (scan.hasNext()) {
                    stress = Integer.parseInt(scan.next());

                    //sleep
                    if (scan.hasNext()) {
                        int sleep = Integer.parseInt(scan.next());

                        //energy
                        if (scan.hasNext()) {
                            int energy = Integer.parseInt(scan.next());

                            //water
                            if (scan.hasNext()) {
                                int water = Integer.parseInt(scan.next());
                                new Entry(date, happiness, stress, sleep, energy, water);
                            }
                        }
                    }
                }
            }
        }




            //Sends them home
            goHomeButton.addActionListener(evt -> features.switchToMainPage());
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
