package model;

public class Entry {
  String date;
  int happiness;
  int stress;
  int sleep;
  int energy;
  String highlight;
  public Entry(String date) {
    this.date=date;
    happiness=8;
    stress=0;
    sleep=8;
    energy=8;
    highlight="";
  }
  public Entry(String date, int happiness, int stress, int sleep, int energy, String highlight) {
    this.date=date;
    this.happiness=happiness;
    this.stress=stress;
    this.sleep=sleep;
    this.energy=energy;
    this.highlight= highlight;
  }

  public int getEnergy() {
    return energy;
  }

  public String getDate() {
    return date;
  }

  public int getHappiness() {
    return happiness;
  }

  public int getSleep() {
    return sleep;
  }

  public int getStress() {
    return stress;
  }

  public String getHighlight() {
    return highlight;
  }

  public void setHappiness(int happiness) {
    this.happiness = happiness;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public void setHighlight(String highlight) {
    this.highlight = highlight;
  }

  public void setEnergy(int energy) {
    this.energy = energy;
  }

  public void setStress(int stress) {
    this.stress = stress;
  }

  public void setSleep(int sleep) {
    this.sleep = sleep;
  }
}
