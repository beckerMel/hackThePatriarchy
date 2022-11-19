package model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MoodTrackerTest {

  IMoodTracker obj;
  IMoodTrackFileHandler fileHandler;
  IGraphService graph;
  DataSource ds;

  @Before
  public void setUp() throws Exception {
    obj= new MoodTracker();
    ds=new DataSource();
    graph=new GraphService();
  }

  @Test
  public void addEntries() {
    obj.addEntry("2022-05-12", 10,9,8,9,30);
    obj.addEntry("2022-05-13", 10,4,8,9,30);
    obj.addEntry("2022-05-14", 10,2,8,9,30);
    obj.addEntry("2022-05-15", 10,3,8,9,30);
    obj.addEntry("2022-05-16", 10,4,8,9,30);
    //System.out.println(obj.getEntries());
    //System.out.println(obj.getNumOfEntries());
    System.out.println(obj.viewEntries());
    //System.out.println(graph.toGraph("2022-05-12","2022-05-16", obj, ds, "stress" ));
  }

  @Test
  public void graphTest() {
    obj.addEntry("2022-05-12", 10,9,8,9,30);
    obj.addEntry("2020-01-02",8,5,9,8,76);
    obj.addEntry("2020-01-03",5,7,8,7,70);
    obj.addEntry("2020-01-04",6,4,7,6,67);
    obj.addEntry("2020-01-05",7,4,5,7,51);
    obj.addEntry("2020-01-06",8,4,7,8,50);
    obj.addEntry("2020-01-07",4,8,7,7,77);
    obj.addEntry("2020-01-08",2,9,6,8,60);
    obj.addEntry("2020-01-09",7,5,3,6,51);
    obj.addEntry("2020-01-10",7,5,3,8,72);
    obj.addEntry("2020-01-11",5,6,6,7,63);
    obj.addEntry("2020-01-12",6,5,8,7,62);
    //System.out.println(obj.getEntries());
    //System.out.println(obj.getNumOfEntries());
    System.out.println(obj.viewEntries());
    System.out.println(graph.toGraph("2020-01-02","2020-01-12", obj, ds, "stress" ));
    System.out.println(graph.toGraph("2020-01-02","2020-01-12", obj, ds, "sleep" ));
  }
}