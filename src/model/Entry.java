package model;

public class Entry {
  String date;
  int happiness;
  int stress;
  int sleep;
  int energy;
  public Entry(String date) {
    this.date=date;
    happiness=8;
    stress=0;
    sleep=8;
    energy=8;
  }
  public Entry(String date, int happiness, int stress, int sleep, int energy) {
    this.date=date;
    this.happiness=happiness;
    this.stress=stress;
    this.sleep=sleep;
    this.energy=energy;
  }

  String displayEntry(String date){
    String res=date+"\t"+happiness+"\t"+stress+"\t"+sleep+"\t"+energy;
    return res;
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

  public void setHappiness(int happiness) {
    this.happiness = happiness;
  }

  public void setDate(String date) {
    this.date = date;
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
