package Model;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/*
 *  ______ _____ _   _ _ _____     _____  _   _   ___   _   _ _____  _____
 *  |  _  \  _  | \ | ( )_   _|   /  __ \| | | | / _ \ | \ | |  __ \|  ___|
 *  | | | | | | |  \| |/  | |     | /  \/| |_| |/ /_\ \|  \| | |  \/| |__
 *  | | | | | | | . ` |   | |     | |    |  _  ||  _  || . ` | | __ |  __|
 *  | |/ /\ \_/ / |\  |   | |     | \__/\| | | || | | || |\  | |_\ \| |___
 *  |___/  \___/\_| \_/   \_/      \____/\_| |_/\_| |_/\_| \_/\____/\____/
 *
 *
 *   _____ _   _ _____ _____     ______ _____ _      _____
 *  |_   _| | | |_   _/  ___|    |  ___|_   _| |    |  ___|
 *    | | | |_| | | | \ `--.     | |_    | | | |    | |__
 *    | | |  _  | | |  `--. \    |  _|   | | | |    |  __|
 *    | | | | | |_| |_/\__/ /    | |    _| |_| |____| |___
 *    \_/ \_| |_/\___/\____/     \_|    \___/\_____/\____/
 */

public class AuditoriumTest
{
  private static User user;

  @BeforeClass
  public static void setUpClass() {
    Datastore.resetData();
    user = new User();
    user.setFirstName("Phil");
    user.setLastName("O'Connell");
    user.setEmailAddress("pxo4@psu.edu");
  }

  @Test
  public void getShowings__Pass_nothing__Returns_correct_showings() {
    long[][] expecteds = {
        {1, 2}
        , {3, 4}
    };

    for (int i = 0; i < expecteds.length; i++) {
      Auditorium auditorium = Datastore.getAuditoriumById(i + 1);
      List<Showing> showings = auditorium.getShowings();

      for (int j = 0; j < expecteds[i].length; j++) {
        long showingId = expecteds[i][j];
        Showing expectedShowing = Datastore.getShowingById(showingId);
        String msg = String.format("Expected showing '%s' in auditorium '%s'", expectedShowing, auditorium);
        assertTrue(msg, showings.contains(expectedShowing));
      }

    }
  }

  @Test
  public void isSeatReserved__Reserve_Seat__Returns_True() {
    for (Auditorium a : Datastore.getAuditoriums()) {
      char rowLetter = 'A';
      for (SeatRow row : a.getSeatingRows()) {
        int seatNum = 0;
        for (Seat seat : row.getSeats()) {
          String seatCode = String.format("%s%s", rowLetter, seatNum);
          // System.out.println(seatCode);
          String seatAuditoriumLabel = a.toString() + " " + seatCode;

          assertFalse(seatAuditoriumLabel + " should not be reserved [Auditorium.isSeatReserved(String)]", a.isSeatReserved(seatCode));
//        assertFalse(seatAuditoriumLabel + " should not be reserved [Seat.isReserved()]", seat.isReserved());

          a.reserveSeat(user, seatCode);

          assertTrue(seatAuditoriumLabel + " should be reserved [Auditorium.isSeatReserved(String)]", a.isSeatReserved(seatCode));
//        assertTrue(seatAuditoriumLabel + " should be reserved [Seat.isReserved()]", seat.isReserved());

          a.unreserveSeat(user, seatCode);

          assertFalse(seatAuditoriumLabel + " should not be reserved [Auditorium.isSeatReserved(String)]", a.isSeatReserved(seatCode));
//        assertFalse(seatAuditoriumLabel + " should not be reserved [Seat.isReserved()]", seat.isReserved());
          seatNum++;
        }
        rowLetter++;
      }
    }

  }

  @Test
  public void seatCodeToSeat__Pass_Seat_Code__Return_Seat_Object() {
    for (Auditorium a : Datastore.getAuditoriums()) {
      char rowLetter = 'A';
      for (SeatRow row : a.getSeatingRows()) {
        int seatNum = 0;
        for (Seat seat : row.getSeats()) {
          String seatCode = String.format("%s%s", rowLetter, seatNum);
          Seat foundSeat = a.seatCodeToSeat(seatCode);
          String foundSeatCode = String.format("%s%s", foundSeat.getRowLetter(), foundSeat.getSeatNum());

          String msg = String.format("Auditorium #%s seatCodeToSeat(\"%s\") returned seat \"%s\"", a, seatCode, foundSeatCode);
          assertSame(msg, seat, foundSeat);
          seatNum++;
        }
        rowLetter++;
      }
    }
  }
}
