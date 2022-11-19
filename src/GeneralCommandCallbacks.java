import controller.Controller;
import model.IModel;
import model.Model;
import view.IView;
import view.MainPageFrame;

public class GeneralCommandCallbacks {
  public static void main(String []args)  {
    IModel model = new Model();
    Controller controller = new Controller(model);
    IView view = new MainPageFrame();
    controller.setView(view);
  }
}
