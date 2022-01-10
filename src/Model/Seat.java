
/*
 * Class: IST 261-001
 * Team 1
 * Assignment: TD04
 */

package Model;

public class Seat extends DataStoreObj
{
  private int rowNum;
  private int seatNum;
  private User reservedBy;

  public Seat(int rowNum, int seatNum) {
    this.rowNum = rowNum;
    this.seatNum = seatNum;
  }
  public char getRowLetter() {
    /*
     * The row is stored as an int
     * But for the sake of the user, we'll show them letters
     * e.g., if rowNum is 0, return 'A'; if 1, return 'B', etc..
     */
    return (char) ('A' + rowNum);
  }

  public int getSeatNum() {
    return seatNum;
  }

  public void reserveSeat(User user) {
    this.reservedBy = user;
  }

  public void unreserveSeat(User user) {
    this.reservedBy = null;
  }

  public boolean isReserved() {
    return (this.reservedBy != null);
  }

  public User getReservedByUser() { return reservedBy; }
}




