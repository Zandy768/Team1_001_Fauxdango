package Model;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class TheaterTest
{

  @Test
  public void getAuditoriums__Pass_nothing__Returns_correct_auditoriums() {
    long[][] expecteds = {
         {1, 2}
        ,{3, 4}
    };

    for (int i=0; i<expecteds.length; i++) {
      Theater theater = Datastore.getTheaterById(i+1);
      List<Auditorium> auditoriums = theater.getAuditoriums();

      for (int j=0; j<expecteds[i].length; j++) {
        long auditoriumId = expecteds[i][j];
        Auditorium expectedAuditorium = Datastore.getAuditoriumById(auditoriumId);
        String msg = String.format("Expected auditorium '%s' in theater '%s'", expectedAuditorium, theater);
        assertTrue(msg, auditoriums.contains(expectedAuditorium));
      }

    }

  }
}
