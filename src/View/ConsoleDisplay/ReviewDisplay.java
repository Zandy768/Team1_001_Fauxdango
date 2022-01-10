package View.ConsoleDisplay;

import Model.Review;
import java.time.format.DateTimeFormatter;

public class ReviewDisplay
{
  //private static final DateTimeFormatter dateWrittenFormat = DateTimeFormatter.ofPattern("MMM dd, yyyy (h:m:s a)");
  //MOVED TO REVIEW CLASS

  // TODO - Write implement the "display" method
  public static void display(Review review) {
    System.out.println("=======================");
    System.out.println("User: " + review.getReviewUser());
    System.out.println("Date: " + review.getTimeWritten());
    System.out.println("Review: " + review.getReviewText());
    System.out.println("=======================");

  }
}
