package model;

import java.util.LinkedHashMap;

public interface IGraphService {
  String toGraph(String startDate, String endDate, IMoodTracker p, DataSource api, String feature)
          throws IllegalArgumentException;
}
