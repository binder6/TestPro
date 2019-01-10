package interview_problem;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TravelTimeAdvisorTest {

  private TravelTimeAdvisor advisor;
  
  @Before
  public void install() {
    advisor = new TravelTimeAdvisor();
  }
  
  @Test
  public void testValidateTime() {
    advisor.setAtStationTime("1123");
    assertFalse(advisor.validateTime("1120", "1200"));
    assertTrue(advisor.validateTime("1130", "1210"));
  }
  
  @After
  public void uninstall() {
    advisor = null;
  }
}
