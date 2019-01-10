package interview_problem;

import static interview_problem.TravelTimeAdvisorUtil.getTravelTimeAdvisor;
import static interview_problem.TestData.TIMETABLE;

import java.util.Scanner;

public class TravelTimeAdvisorMain {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    System.out.println("Enter a departure place:");

    String departure = sc.nextLine();

    System.out.println("Enter a destination:");

    String destination = sc.nextLine();

    System.out.println("Enter the time you will reach at the station:");
    String atStationTime = sc.nextLine();

    TravelTimeAdvisor advisor = getTravelTimeAdvisor(TIMETABLE, 
        departure, destination, atStationTime);
    System.out.print(advisor.toString());
  }
}
