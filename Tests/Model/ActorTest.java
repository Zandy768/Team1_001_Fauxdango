package Model;

import org.junit.Test;

import static org.junit.Assert.*;

public class ActorTest
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

{

  @Test
  public void toString__Pass_nothing__Returns_correct_string() {
    String[] expecteds = {
        "Tom Cruise (1963-07-03)"
      , "Kelly McGillis (1957-07-09)"
      , "Michael McKean (1947-10-17)"
      , "Christopher Guest (1948-02-05)"
      , "Jaimie Lee Curtis (1958-11-22)"
      , "Donald Pleasence (1919-10-05)"
      , "Kurt Russell (1951-03-17)"
    };

    for (int i=0; i<expecteds.length; i++) {
      Actor actor = Datastore.getActorById(i+1);
      String expected = expecteds[i];
      String actual = actor.toString();
      assertEquals(expected, actual);
    }

  }
}
