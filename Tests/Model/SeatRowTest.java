package Model;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SeatRowTest
{

  @Test
  public void getSeats__Create_Row__Row_Count_Matches() {
    SeatRow sr = new SeatRow(3, 5);
    List<Seat> seats = sr.getSeats();

    assertEquals(5, seats.size());


  }
}