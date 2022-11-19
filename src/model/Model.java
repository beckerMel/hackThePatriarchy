package model;

public class Model implements IModel {
  private IJoyArchive ja;
  private IMoodTracker mt;

  public Model(IJoyArchive ja, IMoodTracker mt) {
    this.ja = ja;
    this.mt = mt;
  }
}
