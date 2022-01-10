
/*
 * Class: IST 261-001
 * Team 1
 * Assignment: TD04
 */

package Model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// TODO - Implement the review class
public class Review implements Serializable
{

  private User reviewUser;
  private String reviewText;
  private String timeWritten;

  public Review (User user, String text) {

    this.reviewUser = user;
    this.reviewText = text;

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMM dd, yyyy (h:m:s a)");
    LocalDateTime dateTimeWritten = LocalDateTime.now();
    timeWritten = dtf.format(dateTimeWritten);

  }

  public User getReviewUser() { return reviewUser; }

  public String getReviewText() { return reviewText; }

  public String getTimeWritten() { return timeWritten; }

}
