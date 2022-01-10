
/*
 * Class: IST 261-001
 * Team 1
 * Assignment: TD04
 */

package Model;

import Util.PersistenceData;

import java.util.ArrayList;
import java.util.List;

public class Datastore
{
  private static List<Advertisement> advertisements;
  private static List<Theater> theaters;
  private static List<Movie> movies;
  private static List<Actor> actors;
  private static List<Auditorium> auditoriums;
  private static List<Showing> showings;

  public static void clearData() {
    System.out.println("Clearing 'database'");
    advertisements = new ArrayList<>();
    theaters = new ArrayList<>();
    movies = new ArrayList<>();
    actors = new ArrayList<>();
    auditoriums = new ArrayList<>();
    showings = new ArrayList<>();
  }

  public static void populateData() {
    System.out.println("Populating 'database'");
    initAdvertisements();
    initActors();
    initMovies();
    initShowings();
    initAuditoriums();
    initTheaters();
  }

  // TODO - Modify the code so that the theaters and advertisements are also copied in
  public static void importPersistenceData(PersistenceData persistenceData) {
    Datastore.clearData();
    movies = new ArrayList<>(persistenceData.getMovies());
    theaters = new ArrayList<>(persistenceData.getTheaters());
    advertisements = new ArrayList<>(persistenceData.getAds());


  }

  public static void resetData() {
    clearData();
    populateData();
  }

  static {
    resetData();
  }

  private static void initTheaters() {
    System.out.println("Initializing theaters");
    Theater theater;

    theater = new Theater(1L, "AMC Neshaminy 24", "660 Neshaminy Mall", "Bensalem", "PA", "19020", "(215) 396-8050", "https://www.amctheatres.com/movie-theatres/philadelphia/amc-neshaminy-24");
    theater.addAuditorium(1L);
    theater.addAuditorium(2L);
    theaters.add(theater);

    theater = new Theater(2L, "Regal UA Oxford Valley", "403 Middletown Blvd", "Langhorne", "PA", "19047", "(844) 462-7342", "https://www.regmovies.com › theatres › regal-ua-oxford-valley");
    theater.addAuditorium(3L);
    theater.addAuditorium(4L);
    theaters.add(theater);
  }

  private static void initAdvertisements() {
    System.out.println("Initializing advertisements");
    advertisements.add(new Advertisement("Drink Pepsi"));
    advertisements.add(new Advertisement("Buy Candy"));
    advertisements.add(new Advertisement("Shop at Target"));
    advertisements.add(new Advertisement("Watch NCIS"));
  }

  private static void initAuditoriums() {
    System.out.println("Initializing auditoriums");

    Auditorium auditorium;

    auditorium = new Auditorium(1L, 1);
    auditorium.addShowing(1L);
    auditorium.addShowing(2L);
    for (int row = 0; row < 4; row++) {
      auditorium.addSeatRow(new SeatRow(row, 5));
    }
    auditoriums.add(auditorium);



    auditorium = new Auditorium(2L, 2);
    auditorium.addShowing(3L);
    auditorium.addShowing(4L);
    for (int row = 0; row < 6; row++) {
      auditorium.addSeatRow(new SeatRow(row, 3));
    }
    auditoriums.add(auditorium);

    auditorium = new Auditorium(3L, 1);
    auditorium.addShowing(5L);
    auditorium.addShowing(6L);
    for (int row = 0; row < 3; row++) {
      auditorium.addSeatRow(new SeatRow(row, 3));
    }
    auditoriums.add(auditorium);


    auditorium = new Auditorium(4L, 2);
    auditorium.addShowing(7L);
    auditorium.addShowing(8L);

    for (int row = 0; row < 1; row++) {
      auditorium.addSeatRow(new SeatRow(row, 1));
    }

    auditoriums.add(auditorium);
  }

  private static void initActors() {
    System.out.println("Initializing actors");

    actors.add(new Actor(1L, "Tom", "Cruise", "1963-07-03"));
    actors.add(new Actor(2L, "Kelly", "McGillis", "1957-07-09"));
    actors.add(new Actor(3L, "Michael", "McKean", "1947-10-17"));
    actors.add(new Actor(4L, "Christopher", "Guest", "1948-02-05"));
    actors.add(new Actor(5L, "Jaimie Lee", "Curtis", "1958-11-22"));
    actors.add(new Actor(6L, "Donald", "Pleasence", "1919-10-05"));
    actors.add(new Actor(7L, "Kurt", "Russell", "1951-03-17"));
    actors.add(new Actor(8L, "John", "Doe", "1970-01-02"));
    actors.add(new Actor(9L, "John", "Doe", "1960-01-02"));
  }

  private static void initMovies() {
    System.out.println("Initializing movies");

    Movie movie;

    movie = new Movie(1L, "Top Gun", "Fighter pilot Maverick (Tom Cruise) flies a jet.  Goose dies.", Rating.PG, "1986-05-16", (1 * 60 + 50));
    movie.addGenre(Genre.ACTION);
    movie.addGenre(Genre.DRAMA);
    movie.addActor(1L);
    movie.addActor(2L);
    movies.add(movie);

    movie = new Movie(2L, "This Is Spinal Tap", "Spinal Tap, is chronicled by film director Marty DiBergi", Rating.R, "1984-03-02", 84);
    movie.addGenre(Genre.COMEDY);
    movie.addGenre(Genre.DOCUMENTARY);
    movie.addActor(3L);
    movie.addActor(4L);
    movies.add(movie);

    movie = new Movie(3L, "Halloween", "Michael Meyers kills people", Rating.R, "1978-10-05", 91);
    movie.addGenre(Genre.HORROR);
    movie.addActor(5L);
    movie.addActor(6L);
    movies.add(movie);

    movie = new Movie(4L, "Escape from New York", "Snake Plissken rescues the president", Rating.R, "1981-07-10", 99);
    movie.addGenre(Genre.ACTION);
    movie.addActor(6L);
    movie.addActor(7L);
    movies.add(movie);

  }

  private static void initShowings() {
    System.out.println("Initializing showings");

    Showing showing;

    showing = new Showing(1L, getMovieById(1L), "13:00");
    showings.add(showing);

    showing = new Showing(2L, getMovieById(4L), "16:00");
    showings.add(showing);

    showing = new Showing(3L, getMovieById(3L), "18:00");
    showings.add(showing);

    showing = new Showing(4L, getMovieById(1L), "17:30");
    showings.add(showing);

    showing = new Showing(5L, getMovieById(4L), "19:15");
    showings.add(showing);

    showing = new Showing(6L, getMovieById(2L), "10:00");
    showings.add(showing);

    showing = new Showing(7L, getMovieById(2L), "12:45");
    showings.add(showing);

    showing = new Showing(8L, getMovieById(3L), "23:00");
    showings.add(showing);

  }

  public static List<Advertisement> getAllAdvertisements() {
    return advertisements;
  }

  public static List<Movie> getMovies() {
    return movies;
  }

  public static List<Actor> getActors() {
    return actors;
  }

  public static List<Showing> getShowings() {
    return showings;
  }

  public static List<Theater> getTheaters() {
    return theaters;
  }

  public static List<Auditorium> getAuditoriums() {
    return auditoriums;
  }

  public static Movie getMovieById(long id) {
    for (Movie movie : movies) {
      if (movie.getPrimaryKey() == id) {
        return movie;
      }
    }
    return null;
  }

  public static Actor getActorById(long id) {
    for (Actor actor : actors) {
      if (actor.getPrimaryKey() == id) {
        return actor;
      }
    }
    return null;
  }

  public static Auditorium getAuditoriumById(long id) {
    for (Auditorium auditorium : auditoriums) {
      if (auditorium.getPrimaryKey() == id) {
        return auditorium;
      }
    }
    return null;
  }

  public static Theater getTheaterById(long id) {
    for (Theater theater : theaters) {
      if (theater.getPrimaryKey() == id) {
        return theater;
      }
    }
    return null;
  }

  public static Showing getShowingById(long id) {
    for (Showing showing : showings) {
      if (showing.getPrimaryKey() == id) {
        return showing;
      }
    }
    return null;
  }

  public static List<Actor> searchActorsByName(String searchText) {
    String searchTextUpper = searchText.toUpperCase();
    List <Actor> foundActors = new ArrayList<>();
    for (Actor actor : actors) {
      String fullUpper = (actor.getFirstName() + " " + actor.getLastName()).toUpperCase();
      if (fullUpper.contains(searchTextUpper)) {
        foundActors.add(actor);
      }
    }

    return foundActors;
  }

  public static List<Movie> searchMoviesByTitle(String searchText) {
    String searchTextUpper = searchText.toUpperCase();
    List <Movie> foundMovies = new ArrayList<>();
    for (Movie movie : movies) {
      if (movie.getTitle().toUpperCase().contains(searchTextUpper)) {
        foundMovies.add(movie);
      }
    }

    return foundMovies;
  }

  public static List<Theater> searchTheatersByName(String searchText) {
    String searchTextUpper = searchText.toUpperCase();
    List <Theater> foundTheaters = new ArrayList<>();
    for (Theater theater : theaters) {
      if (theater.getName().toUpperCase().contains(searchTextUpper)) {
        foundTheaters.add(theater);
      }
    }

    return foundTheaters;
  }

  public static List<Theater> searchTheatersByZipcode(String searchText) {
    List <Theater> foundTheaters = new ArrayList<>();
    for (Theater theater : theaters) {
      if (theater.getZipcode().equals(searchText)) {
        foundTheaters.add(theater);
      }
    }

    return foundTheaters;
  }

  public static void setAdvertisements(List<Advertisement> advertisements) {
    Datastore.advertisements = advertisements;
  }

  public static void setTheaters(List<Theater> theaters) {
    Datastore.theaters = theaters;
  }

}
