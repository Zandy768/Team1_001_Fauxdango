package Model;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class SeatTest
{
  static Seat seatRow000Seat000 = null;
  static Seat seatRow025Seat100 = null;
  static User user1;
  static User user2;
  static List<User> users;

  @BeforeClass
  public static void setUpClass() {
  }

  @Before
  public void setUp() {
    users = new ArrayList<>();

    user1 = new User();
    users.add(user1);
    user2 = new User();
    users.add(user2);

    seatRow000Seat000 = new Seat(0, 0);
    seatRow025Seat100 = new Seat(25, 100);
  }

  @Test
  public void getRowLetter__Create_Seats__GetCorrectRowLetter() {
    assertEquals('A', seatRow000Seat000.getRowLetter());
    assertEquals('Z', seatRow025Seat100.getRowLetter());
  }

  @Test
  public void getSeatNum__Create_Seats__GetCorrectSeatNum() {
    assertEquals(0, seatRow000Seat000.getSeatNum());
    assertEquals(100, seatRow025Seat100.getSeatNum());
  }

  @Test
  public void reserveSeat__Reserve_Seat__Is_Reserved_By_User () {
    assertFalse(seatRow000Seat000.isReserved());
    assertNull(seatRow000Seat000.getReservedByUser());

    seatRow000Seat000.reserveSeat(user1);

    assertTrue(seatRow000Seat000.isReserved());
    assertSame(user1, seatRow000Seat000.getReservedByUser());



    assertFalse(seatRow025Seat100.isReserved());
    assertNull(seatRow025Seat100.getReservedByUser());

    seatRow025Seat100.reserveSeat(user2);

    assertTrue(seatRow025Seat100.isReserved());
    assertSame(user2, seatRow025Seat100.getReservedByUser());
  }

  @Test
  public void unreserveSeat__Reserve_Then_Unreserve__Seat_Is_Not_Reserved() {
    assertFalse(seatRow000Seat000.isReserved());
    assertNull(seatRow000Seat000.getReservedByUser());

    seatRow000Seat000.reserveSeat(user1);

    assertTrue(seatRow000Seat000.isReserved());
    assertSame(user1, seatRow000Seat000.getReservedByUser());

    seatRow000Seat000.unreserveSeat(user1);

    assertFalse(seatRow000Seat000.isReserved());
    assertNull(seatRow000Seat000.getReservedByUser());




    assertFalse(seatRow025Seat100.isReserved());
    assertNull(seatRow025Seat100.getReservedByUser());

    seatRow025Seat100.reserveSeat(user2);

    assertTrue(seatRow025Seat100.isReserved());
    assertSame(user2, seatRow025Seat100.getReservedByUser());

    seatRow025Seat100.unreserveSeat(user2);

    assertFalse(seatRow025Seat100.isReserved());
    assertNull(seatRow025Seat100.getReservedByUser());
  }

}
