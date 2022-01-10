
/*
 * Class: IST 261-001
 * Team 1
 * Assignment: TD04
 */

package Util;

import Model.Advertisement;
import Model.Movie;
import Model.Theater;
import Model.User;

import java.util.List;

public class PersistenceData
{
  private User user;
  private List<Movie> movies;
  private List<Theater> theaters;
  private List<Advertisement> ads;

  public PersistenceData(User user, List<Movie> movies, List<Theater> theaters, List<Advertisement> ads) {
    this.user = user;
    this.movies = movies;
    this.theaters = theaters;
    this.ads = ads;
  }

  public User getUser() {
    return user;
  }

  public List<Movie> getMovies() {
    return movies;
  }

  public List<Theater> getTheaters() {
    return theaters;
  }

  public List<Advertisement> getAds() {
    return ads;
  }

}
