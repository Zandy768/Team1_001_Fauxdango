
/*
 * Class: IST 261-001
 * Team 1
 * Assignment: TD04
 */

package Model;

public class Advertisement extends DataStoreObj
{
  private String text;

  public Advertisement(String text) {
    this.text = text;
  }

  public String getText() {
    return text;
  }
}
