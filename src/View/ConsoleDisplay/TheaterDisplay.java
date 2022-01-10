package View.ConsoleDisplay;

import Model.Auditorium;
import Model.Theater;

public class TheaterDisplay
{
  public static void display(Theater theater)  {
    System.out.println(theater.toString());
    System.out.println();
    for (Auditorium auditorium : theater.getAuditoriums()) {
      AuditoriumDisplay.display(auditorium);
    }

  }
}
