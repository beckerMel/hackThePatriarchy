package model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;


public class GraphService implements IGraphService {

  @Override
  public LinkedHashMap<String, Integer> toGraph(String startDate, String endDate,
                                                IMoodTracker p, DataSource api, String feature)
          throws IllegalArgumentException {
    String start = "Mood chart " + p.getTrackerName() + " from " + startDate
            + " to " + endDate + "\n";
    Date d1 = null;
    Date d2 = null;
    try {
      d1 = stringToDate(startDate);
      d2 = stringToDate(endDate);
    } catch (RuntimeException ex) {
      throw new IllegalArgumentException();
    }
    if (d1.after(d2) ) {
      //return "Start date is after end date!";
      throw new IllegalArgumentException();
    }

    int m = numMonths(d1, d2);
    int y = numYears(d1, d2);
    int d = numDays(d1, d2);
    if (m == 1 && d < 30) {
      m = 0;
    }
    if (y == 1 && m < 12) {
      y = 0;
    }
    if (d < 5 && m == 0 && y == 0) {
      throw new IllegalArgumentException();
      //interval too short
    }
    LinkedHashMap<String, Integer> dict = new LinkedHashMap<>();

    Calendar cal1 = Calendar.getInstance();
    cal1.setTime(d1);
    Calendar cal2 = Calendar.getInstance();
    cal2.setTime(d2);
    int adder = 0;
    int ctr = 0;
    boolean flag = false;

    if (d <= 30 && m == 0 && y == 0) {
      dict = loopDays(d1, d2, 1, p, api, feature);
      flag = true;
    } else if (d > 30 && m >= 5 && m <= 30 && y < 5) {
      dict = loopMonths(d1, d2, 1, p, api, feature);
      flag = true;
    } else if (d > 30 && m > 30 && y >= 5 && y <= 30) {
      dict = loopYears(d1, d2, 1, p, api, feature);
      flag = true;
    }

    while (!flag) {
      ctr = 0;
      adder++;
      if (d > 30 && m < 5 && y == 0) {
        if (d / 30 > adder) {
          adder = d / 30;
        }
        ctr = countIntervalsDays(d1, d2, adder, p, api);
        if (ctr >= 5 && ctr <= 30) {
          dict = loopDays(d1, d2, adder, p, api, feature);
          flag = true;
        }
      } else if (m > 30 && y < 5) {
        if (m > 30) {
          adder++;
        }
        ctr = countIntervalsMonths(d1, d2, adder, p, api);
        if (ctr >= 5 && ctr <= 30) {
          dict = loopMonths(d1, d2, adder, p, api, feature );
          flag = true;
        }
      } else if (y > 30) {
        ctr = countIntervalsYears(d1, d2, adder, p, api);
        if (ctr >= 5 && ctr <= 30) {
          dict = loopYears(d1, d2, adder, p, api, feature);
          flag = true;
        }
      }
    }
    return dict;
  }


  protected Date stringToDate(String date) {
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    Date date1 = null;
    try {
      date1 = formatter.parse(date);
    } catch (ParseException e) {
      throw new RuntimeException(e);
    }
    return date1;
  }

  protected int numMonths(Date d1, Date d2) {
    Calendar c1 = dateToCalendar(d1);
    Calendar c2 = dateToCalendar(d2);
    int y = c2.get(Calendar.YEAR) - c1.get(Calendar.YEAR);
    int m = c2.get(Calendar.MONTH) - c1.get(Calendar.MONTH);
    m = y * 12 + m;
    return m;
  }

  protected int numYears(Date d1, Date d2) {
    Calendar c1 = dateToCalendar(d1);
    Calendar c2 = dateToCalendar(d2);
    int y = c2.get(Calendar.YEAR) - c1.get(Calendar.YEAR);
    return y;
  }

  protected int numDays(Date d1, Date d2) {
    return (int) ((d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
  }

  protected Calendar dateToCalendar(Date d1) {
    Calendar c1 = null;
    c1 = Calendar.getInstance();
    c1.setTime(d1);
    return c1;
  }

  protected String dateToString(Date d1) {
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    return dateFormat.format(d1);
  }

  protected int getMonth(Date d) {
    Calendar cal = Calendar.getInstance();
    cal.setTime(d);
    int month = cal.get(Calendar.MONTH);
    return month;
  }

  protected Date getLastDayOfMonth(Date d) {
    Calendar cal = Calendar.getInstance();
    cal.setTime(d);
    //cal.set(cal.DATE, cal.getActualMaximum(cal.DAY_OF_MONTH));
    cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
    Date monthLastDay = cal.getTime();
    return monthLastDay;
  }

  protected Date getLastDayOfYear(Date d) {
    Calendar cal = Calendar.getInstance();
    cal.setTime(d);
    //cal.set(cal.DATE, cal.getActualMaximum(cal.DAY_OF_MONTH));
    cal.set(Calendar.DAY_OF_YEAR, cal.getActualMaximum(Calendar.DAY_OF_YEAR));
    Date yearLastDay = cal.getTime();
    return yearLastDay;
  }

  protected Date prevDay(Date d) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(d);
    calendar.add(Calendar.DAY_OF_YEAR, -1);
    Date prev = calendar.getTime();
    return prev;
  }

  private int countIntervalsDays(Date d1, Date d2, int adder, IMoodTracker p, DataSource api) {
    Calendar cal1 = Calendar.getInstance();
    cal1.setTime(d1);
    Calendar cal2 = Calendar.getInstance();
    cal2.setTime(d2);
    Date temp;
    String tem = "";
    int ctr = 0;
    while (cal1.before(cal2)) {
      temp = cal1.getTime();
      tem = dateToString(temp);
      //check next date
      while (!api.isDateInDB(tem)) {
        cal1.add(Calendar.DAY_OF_YEAR, 1);
        temp = cal1.getTime();
        tem = dateToString(temp);
      }
      //if (dateValidForTickers(tem, p, api)) {
      //date valid
      ctr++;
      //}
      cal1.add(Calendar.DAY_OF_YEAR, adder);
    }
    return ctr;
  }

  private int countIntervalsMonths(Date d1, Date d2, int adder, IMoodTracker p, DataSource api) {
    Calendar cal1 = Calendar.getInstance();
    cal1.setTime(d1);
    Calendar cal2 = Calendar.getInstance();
    cal2.setTime(d2);
    Date temp = d1;
    Date te;
    String tem = "";
    int ctr = 0;
    while (cal1.before(cal2)) {
      temp = getLastDayOfMonth(cal1.getTime());
      tem = dateToString(temp);
      ctr++;
      cal1.add(Calendar.MONTH, adder);
    }
    return ctr;
  }

  private int countIntervalsYears(Date d1, Date d2, int adder, IMoodTracker p, DataSource api) {
    Calendar cal1 = Calendar.getInstance();
    cal1.setTime(d1);
    Calendar cal2 = Calendar.getInstance();
    cal2.setTime(d2);
    Date temp;
    Date te;
    String tem = "";
    int ctr = 0;
    while (cal1.before(cal2)) {
      temp = getLastDayOfYear(cal1.getTime());
      tem = dateToString(temp);
      ctr++;
      cal1.add(Calendar.YEAR, adder);
    }
    return ctr;
  }


  //FUNCTIONS FOR interval division
  //equal or unequally by days
  protected LinkedHashMap<String, Integer> loopDays(Date d1, Date d2, int adder,
                                                   IMoodTracker p, DataSource api, String feature) {
    LinkedHashMap<String, Integer> dict = new LinkedHashMap<String, Integer>();
    Date temp = d1;
    Calendar cal1 = Calendar.getInstance();
    cal1.setTime(d1);
    Calendar cal2 = Calendar.getInstance();
    cal2.setTime(d2);
    String tem = "";
    while (cal1.before(cal2)) {
      //cal1.add(Calendar.DAY_OF_YEAR, adder);
      temp = cal1.getTime();
      tem = dateToString(temp);
      //check next date
      while (!api.isDateInDB(tem)) {
        cal1.add(Calendar.DAY_OF_YEAR, 1);
        temp = cal1.getTime();
        tem = dateToString(temp);
      }
      //if (dateValidForTickers(tem, p, api)) {
      //date invalid
      Calendar calendar = dateToCalendar(temp);
      String tt = "" + calendar.get(Calendar.DAY_OF_MONTH);
      if (tt.length() == 1) {
        tt = "0" + tt;
      }
      String s = "" + tt + " " + new SimpleDateFormat("MMM").format(temp) + " "
              + calendar.get(Calendar.YEAR);
      int val = getFeatureValue(tem, feature, api);

      dict.put(s, val);

      cal1.add(Calendar.DAY_OF_YEAR, adder);
    }
    return dict;
  }

  //FUNCTIONS FOR interval division
  //equal or unequally by days
  protected LinkedHashMap<String, Integer> loopMonths(Date d1, Date d2, int adder,
                                                     IMoodTracker p, DataSource api, String feature) {
    LinkedHashMap<String, Integer> dict = new LinkedHashMap<String, Integer>();
    Date temp = d1;
    Calendar cal1 = Calendar.getInstance();
    cal1.setTime(d1);
    Calendar cal2 = Calendar.getInstance();
    cal2.setTime(d2);
    String tem = "";
    while (cal1.before(cal2)) {

      //temp = cal1.getTime();
      temp = getLastDayOfMonth(cal1.getTime());
      cal1 = dateToCalendar(temp);
      //tem = dateToString(temp);
      //getting correct month
      tem = dateToString(temp);
      //get last day of month
      // go back prev till its valid
      //return the correct day of that month
      //check next date
      while (!api.isDateInDB(tem)) {
        cal1.add(Calendar.DAY_OF_YEAR, -1);
        //conv to date
        temp = cal1.getTime();
        tem = dateToString(temp);
      }
      Calendar calendar = dateToCalendar(temp);
      String s = "" + new SimpleDateFormat("MMM").format(temp) + " "
              + calendar.get(Calendar.YEAR);
      int total =getFeatureValue(tem, feature, api);
      dict.put(s, total);
      //}
      cal1.add(Calendar.MONTH, adder);
    }
    return dict;
  }

  //FUNCTIONS FOR interval division
  //equal or unequally by days
  protected LinkedHashMap<String, Integer> loopYears(Date d1, Date d2, int adder,
                                                    IMoodTracker p, DataSource api, String feature) {
    LinkedHashMap<String, Integer> dict = new LinkedHashMap<String, Integer>();
    Calendar cal1 = Calendar.getInstance();
    cal1.setTime(d1);
    Calendar cal2 = Calendar.getInstance();
    cal2.setTime(d2);
    Date temp = d1;
    String tem = "";
    String a = (cal1.getTime()).toString();
    String b = (cal2.getTime()).toString();
    while (cal1.before(cal2)) {

      temp = getLastDayOfYear(cal1.getTime());
      cal1 = dateToCalendar(temp);
      tem = dateToString(temp);
      while (!api.isDateInDB(tem)) {
        cal1.add(Calendar.DAY_OF_YEAR, -1);
        temp = cal1.getTime();
        tem = dateToString(temp);
      }
      Calendar calendar = dateToCalendar(temp);
      String s = "" + calendar.get(Calendar.YEAR);

      int val =0;
      val=getFeatureValue(tem, feature, api);

      dict.put(s, val);
      cal1.add(Calendar.YEAR, adder);
    }
    return dict;
  }

  int getFeatureValue(String tem, String feature, DataSource api) {
    int val=0;
    switch(feature) {
      case "happiness" : val = api.getHappiness(tem);
        break;
      case "stress" : val = api.getStress(tem);
        break;
      case "sleep" : val = api.getSleep(tem);
        break;
      case "water" : val = api.getWater(tem);
        break;
      case "energy" : val = api.getEnergy(tem);
        break;
    }
    return val;
  }

}
