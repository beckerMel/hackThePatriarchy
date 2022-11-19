package model;

public interface IModel {
  void addEntry(String date, int happiness, int stress, int sleep, int energy, int water);
  void removeEntry( String date);
}
