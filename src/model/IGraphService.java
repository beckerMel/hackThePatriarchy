package model;

import java.util.LinkedHashMap;

public interface IGraphService {
  LinkedHashMap<String, Integer> toGraph(String startDate, String endDate, IMoodTracker p, DataSource api, String feature)
          throws IllegalArgumentException;
}
