package interview_problem;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import static interview_problem.TravelTimeAdvisorUtil.validateTimeStr;
import static interview_problem.TravelTimeAdvisorUtil.getTravelTimeAdvisor;
import static interview_problem.TestData.TIMETABLE;

import org.junit.Test;

public class TravelTimeAdvisorUtilTest {
  
  @Test
  public void testValidateTimeStr() {
    assertTrue(validateTimeStr("0045"));
    assertFalse(validateTimeStr("0060"));
    assertTrue(validateTimeStr("2300"));
    assertFalse(validateTimeStr("2400"));
    assertFalse(validateTimeStr(null));
    assertFalse(validateTimeStr(""));
    assertFalse(validateTimeStr("f900"));
  }
  
  @Test
  public void testGetTravelTimeAdvisor() {
    TravelTimeAdvisor advisor = getTravelTimeAdvisor(TIMETABLE, "Camborne", "Exeter St Davids", "0907");
    assertEquals(150, advisor.calculateTotalTravelTime());
    advisor = getTravelTimeAdvisor(TIMETABLE, "Camborne", "Exeter St Davids", "1023");
    assertEquals(159, advisor.calculateTotalTravelTime());
    advisor = getTravelTimeAdvisor(TIMETABLE, "St Austell", "Par", "1101");
    assertEquals(56, advisor.calculateTotalTravelTime());
    advisor = getTravelTimeAdvisor(TIMETABLE, "St Austell", "Par", "1201");
    assertFalse(advisor.getErrors().isEmpty());
  }
}
