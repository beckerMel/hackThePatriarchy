import controller.Controller;
import model.GraphService;
import model.IGraphService;
import model.IJoyArchive;
import model.IModel;
import model.IMoodTrackFileHandler;
import model.IMoodTracker;
import model.JoyArchive;
import model.Model;
import model.MoodTrackFileHandler;
import model.MoodTracker;
import view.IView;
import view.MainPageFrame;

public class GeneralCommandCallbacks {
  public static void main(String []args)  {
    IJoyArchive ja = new JoyArchive();
    IMoodTracker mt = new MoodTracker();
    IGraphService gs = new GraphService();
    IMoodTrackFileHandler fh = new MoodTrackFileHandler();


    IModel model = new Model(ja, mt, gs, fh);
    Controller controller = new Controller(model);
    IView view = new MainPageFrame();
    controller.setView(view);
  }
}
