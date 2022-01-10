package View.ConsoleDisplay;

import Model.User;
import Util.IOHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UserDisplay
{
  private final static Logger logger = LogManager.getRootLogger();

  public static User registerUser() {
    User user = new User();

    user.setFirstName(IOHelper.readNonBlankStringFromKeyboard("Enter first name"));
    user.setLastName(IOHelper.readNonBlankStringFromKeyboard("Enter last name"));
    user.setEmailAddress(IOHelper.readNonBlankStringFromKeyboard("Enter email address"));

    logger.info("New user: " + user.toString());

    return user;
  }
}
