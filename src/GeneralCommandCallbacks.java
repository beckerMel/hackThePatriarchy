import controller.Controller;
import model.IJoyArchive;
import model.IModel;
import model.IMoodTracker;
import model.JoyArchive;
import model.Model;
import model.MoodTracker;
import view.IView;
import view.MainPageFrame;

public class GeneralCommandCallbacks {
  public static void main(String []args)  {
    IJoyArchive ja = new JoyArchive();
    IMoodTracker mt = new MoodTracker();

    IModel model = new Model(ja, mt);
    Controller controller = new Controller(model);
    IView view = new MainPageFrame();
    controller.setView(view);
  }
}
