package Util;

import Model.Datastore;
import Model.User;
import org.junit.BeforeClass;
import org.junit.Test;

public class PersistenceTest
{
  private static User user;

  @BeforeClass
  public static void setUp() {
    user = new User();
    user.setFirstName("Phil");
    user.setLastName("O'Connell");
    user.setEmailAddress("pxo4@psu.edu");
  }


  @Test
  public void saveState__Save_Persistence__Manually_Check() {
    PersistenceData pd = new PersistenceData(user, Datastore.getMovies(), Datastore.getTheaters(), Datastore.getAllAdvertisements());

    // String filePath = System.getProperty("user.dir") + "TD03_fauxdango.json";
    // System.out.println(filePath);
    // String pkg = Application.class.getPackage().getName();

    String filePath = "C:/temp/TD03_fauxdango.json";
    Persistence.saveState(pd, filePath);
    // fail("Check '" + filePath + "'");
  }
}