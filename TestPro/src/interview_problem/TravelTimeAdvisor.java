package interview_problem;

import static interview_problem.TravelTimeAdvisorUtil.validateTimeStr;
import static interview_problem.TravelTimeAdvisorUtil.calculateTime;

import java.util.ArrayList;
import java.util.List;

public class TravelTimeAdvisor {
  
  private String departure;
  
  private String destination;
  
  private String atStationTime;
  
  private String startTime;
  
  private String endTime;
  
  private List<String> errors;
  
  /**
   * @return the departure
   */
  public String getDeparture() {
    return departure;
  }

  /**
   * @param departure the departure to set
   */
  public void setDeparture(String departure) {
    this.departure = departure;
  }

  /**
   * @return the destination
   */
  public String getDestination() {
    return destination;
  }

  /**
   * @param destination the destination to set
   */
  public void setDestination(String destination) {
    this.destination = destination;
  }

  /**
   * @return the atStationTime
   */
  public String getAtStationTime() {
    return atStationTime;
  }

  /**
   * @param atStationTime the atStationTime to set
   */
  public void setAtStationTime(String atStationTime) {
    this.atStationTime = atStationTime;
  }

  /**
   * @return the startTime
   */
  public String getStartTime() {
    return startTime;
  }

  /**
   * @param startTime the startTime to set
   */
  public void setStartTime(String startTime) {
    this.startTime = startTime;
  }

  /**
   * @return the endTime
   */
  public String getEndTime() {
    return endTime;
  }

  /**
   * @param endTime the endTime to set
   */
  public void setEndTime(String endTime) {
    this.endTime = endTime;
  }

  /**
   * @return the errors
   */
  public List<String> getErrors() {
    return errors;
  }

  /**
   * @param errors the errors to set
   */
  public void setErrors(List<String> errors) {
    this.errors = errors;
  }

  public void addError(String error) {
    if (null == errors) {
      errors = new ArrayList<String>();
    }
    errors.add(error);
  }
  
  public boolean validateTime(String startTime, String endTime) {
    boolean isValidated =  validateTimeStr(atStationTime) 
                          && validateTimeStr(startTime) 
                          && validateTimeStr(endTime)
                          && calculateTime(atStationTime, startTime) >= 0
                          && calculateTime(startTime, endTime) > 0;
                         
    return isValidated;
  }

  public int calculateTotalTravelTime() {
    return calculateTime(atStationTime, endTime);
  }
  
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    if (null != errors && !errors.isEmpty()) {
      builder.append("This advisor has errors: \n");
      errors.forEach(error -> builder.append(error).append("\n"));
      return builder.toString();
    } 
    int travelTime = calculateTotalTravelTime();
    if (travelTime < 0) {
      builder.append("Time setting is invalid!");
    } else {
      builder.append("When arriving at the station at ")
             .append(atStationTime)
             .append(", \nyou can take the train from ")
             .append(departure)
             .append(" (")
             .append(startTime)
             .append(") ")
             .append(" to ")
             .append(destination)
             .append(" (")
             .append(endTime)
             .append("), \nit will take you ")
             .append(travelTime)
             .append(" minutes.");
    }
    
    return builder.toString();
  }
}
