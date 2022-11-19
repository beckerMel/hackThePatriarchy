package view;

import java.awt.*;

import controller.IFeatures;

import javax.swing.*;

public class RemoveFrame extends JFrame implements IView {
    private JLabel display;
    private JTextField dateRemove;
    private JButton removeButton, mainPageButton;

    /**
     * Automatically Constructs the visual of the remove page. Basically will be: Are you sure you want to remove entry?
     * y/n
     */
    public RemoveFrame() {
        setSize(500, 300);
        setLocation(200, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setLayout(new FlowLayout());

        dateRemove = new JTextField("Energy Input", 10);
        this.add(dateRemove);

        removeButton = new JButton("Remove Entry");
        removeButton.setActionCommand("Remove Entry");

        mainPageButton = new JButton("Go Back to Home");
        mainPageButton.setActionCommand("Go to Main");

        pack();
        setVisible(true);
    }

    @Override
    public void addFeatures(IFeatures features) {
        removeButton.addActionListener(evt -> features.removeEntry(dateRemove.getText())
                );

        mainPageButton.addActionListener(evt -> features.switchToMainPage());
    }

    @Override
    public void resetFocus() {
        this.setFocusable(true);
        this.requestFocus();
    }
}
