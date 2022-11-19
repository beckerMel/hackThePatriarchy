package view;

import controller.IFeatures;

import javax.swing.*;

public class RemoveFrame extends JFrame implements IView {

    /**
     * Automatically Constructs the visual of the remove page. Basically will be: Are you sure you want to remove entry?
     * y/n
     */
    public RemoveFrame() {
        enterButton.addActionListener(evt -> features.showHighlightsResult());
        homeButton.addActionListener(evt -> features.switchToMainPage());
    }

    @Override
    public void addFeatures(IFeatures features) {

    }

    @Override
    public void resetFocus() {
        this.setFocusable(true);
        this.requestFocus();
    }
    //putting this here so i can push
    //\
}
