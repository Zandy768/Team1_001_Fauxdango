
/*
 * Class: IST 261-001
 * Team 1
 * Assignment: TD04
 */

package Model;

import java.time.LocalDate;

// TODO - Modify the actor class so that Java knows how to compare two Actors by last,first,age
public class Actor extends DataStoreObj implements Comparable<Actor>
{
  private String firstName;
  private String lastName;
  private LocalDate birthday;
  // DO NOT CREATE AN "age" FIELD!!!  YOU DON'T NEED IT

  public Actor(String firstName, String lastName, String birthday) {
    this(null, firstName, lastName, birthday);
  }

  public Actor(Long id, String firstName, String lastName, String birthday) {
    super(id);
    this.firstName = firstName;
    this.lastName = lastName;
    this.birthday = LocalDate.parse(birthday);
  }

  public String getFirstName() {
    return this.firstName;
  }

  public String getLastName() {
    return this.lastName;
  }

  private String fullName() {
    return firstName + " " + lastName;
  }

  @Override
  public String toString() {
    return String.format("%s (%s)", fullName(), birthday);
  }


  // TODO - You'll need a new method here to tell Java how to compare two Actors by last,first,age

  @Override
  public int compareTo(Actor otherPerson) {
    int result = this.lastName.compareTo(otherPerson.lastName);

    if (result ==0){
      result = this.firstName.compareTo(otherPerson.firstName);
    }
    //if the first name and last name matches, then compare the age
    if(result == 0){
      result = this.birthday.compareTo(otherPerson.birthday);
    }
    return result;
  }

}
