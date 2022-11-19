//package view;
//
//import controller.Controller;
//import controller.IFeatures;
//import model.Entry;
//import model.IModel;
//
//import javax.swing.*;
//import java.awt.*;
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.Date;
//
//public class EntryFrame extends JFrame implements IView{
//
//    private JLabel display;
//    private JButton addEntryButton, removeEntryButton, getHappinessButton, chartButton;
//    private JFrame GetHappinessFrame = new GetHappiness();
//
//
//    /**
//     * This is reflect the image of what the Entry Page
//     */
//    public EntryFrame() {
//        super("Home Page");
//        setSize(500, 300);
//        setLocation(200, 200);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        this.setLayout(new FlowLayout());
//    }
//
//
//    /**This is where we have the buttons and inputs that could be added and changed
//     * @param features (adding the information necessary
//     */
//    @Override
//    public void addFeatures(IFeatures features) {
//        LocalDateTime today = LocalDateTime.now();
//        String dateToString = today.toString();
//        IModel model = (IModel) new Entry(dateToString);
//        Controller controller = new Controller(model);
//        IView view = new MainPageFrame();
//        controller.setView(view);
//    }
//}
