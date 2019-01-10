package interview_problem;

public class TravelTimeAdvisorUtil {
  
  public static final String TIME_REGEX = "^([01][0-9]|2[0-3])([0-5][0-9])$";
  
  public static boolean validateTimeStr(String str) {
    return (null != str && !str.isEmpty() && str.matches(TIME_REGEX));
  }
  
  public static int calculateTime(String start, String end) {
    if (!validateTimeStr(start) || !validateTimeStr(end))
      return -1;
    int startH = Integer.parseInt(start.substring(0, 2));
    int endH = Integer.parseInt(end.substring(0, 2));
    
    int startM = Integer.parseInt(start.substring(2));
    int endM = Integer.parseInt(end.substring(2));
    
    if (startH > endH)
      return -1;
    
    if (startH == endH && startM > endM)
      return -1;
    
    return (endH - startH) * 60 + (endM - startM);
  }
  
  public static TravelTimeAdvisor getTravelTimeAdvisor(String[][] timetable, 
      String departure, String destination, String atStationTime) {
    
    TravelTimeAdvisor advisor = new TravelTimeAdvisor();

    advisor.setDeparture(departure);
    advisor.setDestination(destination);
    advisor.setAtStationTime(atStationTime);
    
    if (!validateTimeStr(atStationTime)) {
      advisor.addError("The time's format should be hhmm, for example 0140.");
    }

    int depIndex = -1;
    int desIndex = -1;

    String[] places = timetable[0];

    int idx = 0;
    for (String place : places) {
      if (place.equals(departure)) {
        depIndex = idx;
      }

      if (place.equals(destination)) {
        desIndex = idx;
      }

      if (depIndex != -1 && desIndex != -1)
        break;

      idx++;
    }

    if (depIndex == -1) {
      advisor.addError("The train does not call at " + departure + ".");
    }

    if (desIndex == -1) {
      advisor.addError("The train does not call at " + destination + ".");
    }

    if (null != advisor.getErrors() && !advisor.getErrors().isEmpty()) {
      return advisor;
    }

    for (int i = 1; i < timetable.length; i++) {
      String[] times = timetable[i];
      
      if (advisor.validateTime(times[depIndex], times[desIndex])) {
        advisor.setStartTime(times[depIndex]);
        advisor.setEndTime(times[desIndex]);
        return advisor;
      } 
    }

    advisor.addError("There is no train after " + atStationTime + ".");
    return advisor;
  }
}
