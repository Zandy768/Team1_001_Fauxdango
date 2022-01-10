package View.ConsoleDisplay;

import Model.Genre;
import Model.Movie;
import Model.Rating;
import Util.IOHelper;
import edu.psu.consolemenu.Menu;
import edu.psu.consolemenu.MenuChoice;
import edu.psu.consolemenu.MenuDisplay;

import java.util.List;

public class MovieDisplay
{
  public static Movie chooseMovie (String prompt, List<Movie> movies) {
    Menu movieMenu = new Menu("Choose a movie");
    for (Movie movie : movies) {
      MenuChoice mc = new MenuChoice(movie.getTitle());
      mc.setObject(movie);
      movieMenu.addMenuChoice(mc);
    }



    MenuDisplay menuDisplay = new MenuDisplay(movieMenu);
    MenuChoice choice = menuDisplay.displayAndChoose();

    return (Movie) choice.getObject();
  }

  public static Rating ratingConverter(String input){
    switch(input.toUpperCase()) {
      case "G":
        return Rating.G;
      case "PG":
        return Rating.PG;
      case "PG13":
        return Rating.PG13;
      case "R":
        return Rating.R;
      default:
        return Rating.G;
    }
  }

  public static Genre genreConverter(String input){
    switch(input.toUpperCase()) {
      case "ACTION":
        return Genre.ACTION;
      case "COMEDY":
        return Genre.COMEDY;
      case "DOCUMENTARY":
        return Genre.DOCUMENTARY;
      case "DRAMA":
        return Genre.DRAMA;
      case "HORROR":
        return Genre.HORROR;
      default:
        return Genre.DOCUMENTARY;
    }
  }

  public static Movie inputNewMovie() {
    // TODO - write code to allow the user to enter the info for the new movie
    // TODO - This will simply return a new Movie instance.  It's up to the caller to add it to the list of movies
    String title = IOHelper.readNonBlankStringFromKeyboard("Enter title: ");
    String description = IOHelper.readNonBlankStringFromKeyboard("Enter description: ");
    String rating = IOHelper.readNonBlankStringFromKeyboard("Enter rating: ");
    String realeaseDate = IOHelper.readNonBlankStringFromKeyboard("Enter release date (YYYY-MM-DD): ");
    String genre = IOHelper.readNonBlankStringFromKeyboard("Enter ONE genre[ACTION, COMEDY, DOCUMENTARY, DRAMA, HORROR]: ");
    int runningTime = Integer.parseInt(IOHelper.readNonBlankStringFromKeyboard("Enter running time (minutes): "));

    Movie movie;

    movie = new Movie(5L, title, description, ratingConverter(rating), realeaseDate, runningTime);
    movie.addGenre(genreConverter(genre));
    return movie;
  }
}
