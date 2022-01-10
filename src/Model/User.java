
/*
 * Class: IST 261-001
 * Team 1
 * Assignment: TD04
 */

package Model;

public class User extends DataStoreObj
{
  private String firstName;
  private String lastName;
  private String emailAddress;

  public User() {
    this(null);
  }

  public User(Long id) {
    super(id);
  }

  public static User copyUser(User user) {
    User newUser = new User();
    newUser.setFirstName(user.firstName);
    newUser.setLastName(user.lastName);
    newUser.setEmailAddress(user.emailAddress);
    return newUser;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public void setEmailAddress(String emailAddress) {
    this.emailAddress = emailAddress;
  }

  @Override
  public String toString() {
    return String.format("%s %s (%s)", this.firstName, this.lastName, this.emailAddress);
  }
}
