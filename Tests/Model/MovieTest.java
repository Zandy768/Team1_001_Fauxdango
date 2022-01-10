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

public class MovieTest
{

  @BeforeClass
  public static void setUp() {
    // Datastore.resetData();
  }

  @Test
  public void toString__Pass_nothing__Returns_correct_string() {
    String[] expecteds = {
       "Top Gun (PG, 1986) [ACTION, DRAMA] {110 min}"
      ,"This Is Spinal Tap (R, 1984) [COMEDY, DOCUMENTARY] {84 min}"
      ,"Halloween (R, 1978) [HORROR] {91 min}"
      ,"Escape from New York (R, 1981) [ACTION] {99 min}"
    };

    for (int i=0; i<expecteds.length; i++) {
      Movie movie = Datastore.getMovieById(i+1);
      String expected = expecteds[i];
      String actual = movie.toString();
      assertEquals(expected, actual);
    }

  }

  @Test
  public void getActors__Pass_nothing__Returns_correct_actors() {
    long[][] expecteds = {
       {1, 2}
      ,{3, 4}
      ,{5, 6}
      ,{6, 7}
    };

    for (int i=0; i<expecteds.length; i++) {
      Movie movie = Datastore.getMovieById(i+1);
      List<Actor> actors = movie.getActors();

      for (int j=0; j<expecteds[i].length; j++) {
        long actorId = expecteds[i][j];
        Actor expectedActor = Datastore.getActorById(actorId);
        String msg = String.format("Expected '%s' in '%s'", expectedActor, movie);
        assertTrue(msg, actors.contains(expectedActor));
      }

    }

  }
}
