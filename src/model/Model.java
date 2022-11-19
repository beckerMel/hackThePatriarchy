package model;

public class Model implements IModel {
  private IJoyArchive ja;
  private IMoodTracker mt;

  public Model(IJoyArchive ja, IMoodTracker mt) {
    this.ja = ja;
    this.mt = mt;
  }

  public void addEntry(String date, int happiness, int stress, int sleep, int energy, int water) {
    mt.addEntry(date, happiness, stress, sleep, energy, water);
  }

  public void removeEntry(String date) {
    mt.removeEntry(date);
  }


}
