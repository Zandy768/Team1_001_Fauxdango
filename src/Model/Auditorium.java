
/*
 * Class: IST 261-001
 * Team 1
 * Assignment: TD04
 */

package Model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Auditorium extends DataStoreObj
{
  private final static Logger logger = LogManager.getRootLogger();

  int number;
  private List<Showing> showings = new ArrayList<>();
  private List<SeatRow> seats = new ArrayList<>();

  public Auditorium(int number) {
    this(null, number);
  }

  public Auditorium(Long id, int number) {
    super(id);
    this.number = number;
  }

  public List<Showing> getShowings() {
    return showings;
  }

  public void addShowing(long id) {
    Showing foundShowing = Datastore.getShowingById(id);
    showings.add(foundShowing);
  }

  public void addSeatRow(SeatRow row) {
    seats.add(row);
  }

  public List<SeatRow> getSeatingRows() {
    return seats;
  }

  @Override
  public String toString() {
    return String.valueOf(number);
  }

  public Seat seatCodeToSeat(String seatCode) {
    char rowLetter = Character.toUpperCase(seatCode.charAt(0));
    int seatNum = Integer.parseInt("" + seatCode.charAt(1));

    int rowNum = rowLetter - 'A';
    SeatRow row = getSeatingRows().get(rowNum);
    Seat seat = row.getSeats().get(seatNum);
    return seat;
  }

  public boolean isSeatReserved(String seatCode) {
    Seat seat = seatCodeToSeat(seatCode);

    return seat.isReserved();
  }

  public void reserveSeat(User user, String seatCode) {
    Seat seat = seatCodeToSeat(seatCode);
    seat.reserveSeat(user);
    logger.info(String.format("%s reserved seat %s in auditorium %s", user, seatCode, this.number));
  }

  public void unreserveSeat(User user, String seatCode) {
    Seat seat = seatCodeToSeat(seatCode);
    seat.unreserveSeat(user);
    logger.info(String.format("%s unreserved seat %s in auditorium %s", user, seatCode, this.number));
  }
}
