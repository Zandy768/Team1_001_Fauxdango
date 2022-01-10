package Model;

import org.junit.Test;

import static org.junit.Assert.*;

public class ShowingTest
{
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

  @Test
  public void toString__Pass_nothing__Returns_correct_string() {
    String[] expecteds = {
        "Top Gun (PG, 1986) [ACTION, DRAMA] {110 min} {13:00-14:50}"
      , "Escape from New York (R, 1981) [ACTION] {99 min} {16:00-17:39}"
      , "Halloween (R, 1978) [HORROR] {91 min} {18:00-19:31}"
      , "Top Gun (PG, 1986) [ACTION, DRAMA] {110 min} {17:30-19:20}"
      , "Escape from New York (R, 1981) [ACTION] {99 min} {19:15-20:54}"
      , "This Is Spinal Tap (R, 1984) [COMEDY, DOCUMENTARY] {84 min} {10:00-11:24}"
      , "This Is Spinal Tap (R, 1984) [COMEDY, DOCUMENTARY] {84 min} {12:45-14:09}"
      , "Halloween (R, 1978) [HORROR] {91 min} {23:00-00:31}"
    };

    for (int i=0; i<expecteds.length; i++) {
      Showing showing = Datastore.getShowingById(i+1);
      String expected = expecteds[i];
      String actual = showing.toString();
      assertEquals(expected, actual);
    }
  }
}
