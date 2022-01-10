package View.ConsoleDisplay;

import Model.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class AuditoriumDisplayTest
{
  private User user = new User();

  @BeforeClass
  public static void setUp() {
    Datastore.resetData();
  }

  @AfterClass
  public static void TearDown() {
    Datastore.resetData();
  }

  @Test
  public void display__Display_Auditorium__Manually_Check() {
    for (Auditorium a : Datastore.getAuditoriums()) {
      System.out.println("VVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV");
      AuditoriumDisplay.display(a);

      List<SeatRow> seatRows = a.getSeatingRows();

      SeatRow frontRow = seatRows.get(0);
      List<Seat> frontRowSeats = frontRow.getSeats();
      frontRowSeats.get(0).reserveSeat(user);

      SeatRow lastRow = seatRows.get(seatRows.size() - 1);
      List<Seat> lastRowSeats = lastRow.getSeats();
      lastRowSeats.get(lastRowSeats.size() - 1).reserveSeat(user);

      AuditoriumDisplay.display(a);

      System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
    }

  }
}
