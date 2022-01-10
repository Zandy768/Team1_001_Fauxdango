
/*
 * Class: IST 261-001
 * Team 1
 * Assignment: TD04
 */

package Model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Showing extends DataStoreObj
{
  private Movie movie;
  private LocalTime startTime;

  public Showing(Movie movie, String startTime) {
    this(null, movie, startTime);
  }

  public Showing(Long id, Movie movie, String startTime) {
    super(id);
    this.movie = movie;
    this.startTime = LocalTime.parse(startTime);
  }

  private LocalTime getEndTime() {
    return this.startTime.plus(movie.getRunningTime());
  }

  @Override
  public String toString() {
    return String.format("%s {%s-%s}", this.movie, this.startTime, this.getEndTime());
  }

}
