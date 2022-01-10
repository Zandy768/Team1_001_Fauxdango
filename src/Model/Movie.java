
/*
 * Class: IST 261-001
 * Team 1
 * Assignment: TD04
 */

package Model;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


// TODO - Modify the movie class so that Java knows how to compare two Movies for sorting by title
public class Movie extends DataStoreObj implements Comparable<Movie>
{
  private String title;
  private String description;
  private LocalDate releaseDate;
  private Duration runningTime;
  private Rating rating;
  private List<Genre> genres = new ArrayList<>();
  private List<Actor> actors = new ArrayList<>();
  // TODO: Add list of reviews
  private static List<Review> reviews = new ArrayList<>();

  public Movie(String title, String description, Rating rating, String releaseDate, int runningTimeMinutes) {
    this(null, title, description, rating, releaseDate, runningTimeMinutes);
  }

  public Movie(Long id, String title, String description, Rating rating, String releaseDate, int runningTimeMinutes) {
    super(id);
    this.title = title;
    this.description = description;
    this.rating = rating;
    this.releaseDate = LocalDate.parse(releaseDate);
    // https://stackoverflow.com/a/41800301/673393
    this.runningTime = Duration.ofMinutes(runningTimeMinutes);
  }

  public Duration getRunningTime() {
    return runningTime;
  }

  public String getTitle() {
    return this.title;
  }

  public void addGenre(Genre genre) {
    genres.add(genre);
  }

  public void addActor(long actorId) {
    Actor foundActor = Datastore.getActorById(actorId);
    actors.add(foundActor);
  }

  public List<Actor> getActors() {
    return actors;
  }

  public void addReview(Review review) {
    // TODO: Write code to add the review to the list

    reviews.add(review);
  }
  @Override
  public String toString() {
    int runningTimeMinutes = (int) this.getRunningTime().getSeconds() / 60;

    return String.format("%s (%s, %s) %s {%s min}", this.title, this.rating, this.releaseDate.getYear(), genres, runningTimeMinutes);
  }

  // TODO - You'll need a new method here to tell Java how to compare two movies by title

  public static List<Review> getReviews() {
    return reviews;
  }


  @Override
  public int compareTo(Movie otherMovie) {
    int result = this.title.compareTo(otherMovie.title);

    return result;

  }
}
