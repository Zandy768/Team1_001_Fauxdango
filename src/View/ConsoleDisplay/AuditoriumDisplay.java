package View.ConsoleDisplay;

import Model.Auditorium;
import Model.Seat;
import Model.SeatRow;

public class AuditoriumDisplay
{
  public static void display(Auditorium auditorium) {
    System.out.println();
    System.out.println("Auditorium " + auditorium + ": ");
    System.out.println();
    for (SeatRow row : auditorium.getSeatingRows()) {

      for (Seat seat : row.getSeats()) {
        char reserved = seat.isReserved() ? 'R' : ' ';
        System.out.print(String.format("  %s%s(%s)", seat.getRowLetter(), seat.getSeatNum(), reserved));
      }

      System.out.println();
    }

    System.out.println();

  }
}
