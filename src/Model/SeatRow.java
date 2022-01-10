
/*
 * Class: IST 261-001
 * Team 1
 * Assignment: TD04
 */

package Model;

import java.util.ArrayList;
import java.util.List;

public class SeatRow
{
  private int rowNum;
  private List<Seat> seats = new ArrayList<>();

  public SeatRow(int rowNum, int numSeats) {
    this.rowNum = rowNum;

    for (int i = 0; i < numSeats; i++) {
      seats.add(new Seat(rowNum, i));
    }
  }

  public List<Seat> getSeats() {
    return seats;
  }

}
