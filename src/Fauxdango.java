
/*
 * Class: IST 261-001
 * Team 1
 * Assignment: TD04
 */

import Model.*;
import Util.IOHelper;
import Util.Persistence;
import Util.PersistenceData;
import View.ConsoleDisplay.*;
import edu.psu.consolemenu.Menu;
import edu.psu.consolemenu.MenuChoice;
import edu.psu.consolemenu.MenuDisplay;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Arrays;
import java.util.function.BiPredicate;


public class Fauxdango
{
  private User user;

  public void demo() {
    /*
     * Initialize the menus
     */
    Menu mainMenu = new Menu("Fauxdango");
    initMainMenu(mainMenu);
    MenuChoice choiceMainExit = mainMenu.addMenuChoice("Exit");



    /*
     * Set up the advertisement bank
     */
    AdvertisementBank adBank = new AdvertisementBank();
    AdvertisementDisplay adDisplay = new AdvertisementDisplay(adBank);


    /*
     * Repeatedly display the menu until user chooses to exit
     */
    MenuDisplay menuDisplay = new MenuDisplay(mainMenu);
    MenuChoice chosen = null;
    while (chosen != choiceMainExit) {
      adDisplay.displayNextAd();
      System.out.println("User: " + ((user == null) ? "None" : user ));
      chosen = menuDisplay.displayAndChoose();
    }

  }


  /*****************************************************************************/

  private void initMainMenu(Menu menu) {
    MenuChoice choiceFile = menu.addMenuChoice("File");
    choiceFile.setSubMenu(initFileMenu());

    MenuChoice choiceMainRegister = menu.addMenuChoice("Register");
    choiceMainRegister.setMenuAction(() -> {
      user = UserDisplay.registerUser();
      System.out.println();
      System.out.println("Welcome, " + user.toString());
    });

    MenuChoice choiceReservations = menu.addMenuChoice("Reservations");
    choiceReservations.setSubMenu(initReservationsMenu());

    MenuChoice choiceListings = menu.addMenuChoice("Listings");
    choiceListings.setSubMenu(initListingsMenu());

    MenuChoice choiceSearches = menu.addMenuChoice("Searches");
    choiceSearches.setSubMenu(initSearchesMenu());

    MenuChoice choiceReviews = menu.addMenuChoice("Reviews");
    choiceReviews.setSubMenu(initReviewsMenu());

    MenuChoice choiceDataEntry = menu.addMenuChoice("Data Entry");
    choiceDataEntry.setSubMenu(initDataEntryMenu());
  }

  private Menu initReservationsMenu() {
    Menu reservationsMenu = new Menu("Reservations");

    MenuChoice choiceMainReserveSeat = reservationsMenu.addMenuChoice("Reserve Seat");
    choiceMainReserveSeat.setMenuAction(() -> {
      if (user == null) {
        System.out.println("YOU MUST REGISTER FIRST");
        return;
      }
      Auditorium auditorium = Datastore.getAuditoriumById(1);
      AuditoriumDisplay.display(auditorium);

      String seatCode = IOHelper.readNonBlankStringFromKeyboard("Enter seat (e.g., B3)");
      if (auditorium.isSeatReserved(seatCode)) {
        System.out.println(seatCode + " is already reserved");
      } else {
        auditorium.reserveSeat(user, seatCode);
        System.out.println(seatCode + " is now reserved");
      }
    });

    MenuChoice choiceMainUnreserveSeat = reservationsMenu.addMenuChoice("Unreserve Seat");
    choiceMainUnreserveSeat.setMenuAction(() -> {
      if (user == null) {
        System.out.println("YOU MUST REGISTER FIRST");
        return;
      }
      System.out.println("NOTE:  In that phase of the project, we're only demo'ing reserving seats for one auditorium");
      Auditorium auditorium = Datastore.getAuditoriumById(1);
      AuditoriumDisplay.display(auditorium);

      String seatCode = IOHelper.readNonBlankStringFromKeyboard("Enter seat (e.g., B3)");
      if (!auditorium.isSeatReserved(seatCode)) {
        System.out.println(seatCode + " is not reserved");
      } else {
        auditorium.unreserveSeat(user, seatCode);
        System.out.println(seatCode + " is now open");
      }
    });


    return reservationsMenu;
  }

  private Menu initFileMenu() {
    Menu fileMenu = new Menu("File");

    MenuChoice saveChoice = fileMenu.addMenuChoice("Save");
    saveChoice.setMenuAction(() -> {
      String filePath = IOHelper.readNonBlankStringFromKeyboard("Enter full path to file");
      PersistenceData persistenceData = new PersistenceData(user, Datastore.getMovies(), Datastore.getTheaters(), Datastore.getAllAdvertisements());
      Persistence.saveState(persistenceData, filePath);
      System.out.println("State has been saved to " + filePath);
    });

    MenuChoice loadChoice = fileMenu.addMenuChoice("Load");

    loadChoice.setMenuAction(() -> {
      // TODO - Write code similar to what "Save" does, but load the data
      String filePath = IOHelper.readNonBlankStringFromKeyboard("Enter full path to load");
      PersistenceData persistenceData = Persistence.loadState(filePath);
      Datastore.importPersistenceData(persistenceData);
      user = User.copyUser(persistenceData.getUser());
      System.out.println("Data has been loaded from " + filePath);

    });


    return fileMenu;
  }

  private Menu initDataEntryMenu() {
    Menu dataEntryMenu = new Menu("Data Entry");

    MenuChoice choiceAddMovies = dataEntryMenu.addMenuChoice("Add Movies");
    choiceAddMovies.setMenuAction(() -> {
        Movie newMovie = MovieDisplay.inputNewMovie();
        Datastore.getMovies().add(newMovie);
    });

    return dataEntryMenu;
  }

  private Menu initReviewsMenu() {
    Menu reviewsMenu = new Menu("Reviews");

    MenuChoice choiceReadReviews = reviewsMenu.addMenuChoice("Read Reviews");
    choiceReadReviews.setMenuAction(() -> {

      // TODO - choose a movie

      Movie movie = MovieDisplay.chooseMovie("Choose a movie", Datastore.getMovies());

      // TODO - output all the reviews

      System.out.println("Reviews for '" + movie.getTitle() + "'");
      for (Review review : movie.getReviews()) {
        ReviewDisplay.display(review);
      }
    });

    MenuChoice choiceWriteReview = reviewsMenu.addMenuChoice("Write a Review");
    choiceWriteReview.setMenuAction(() -> {
      if (user == null) {
        System.out.println("YOU MUST REGISTER FIRST");
        return;
      }
      // TODO - Write the code allowing the user to write a one-line review for a movie
      // TODO - It MUST wind up in the chosen Movie's List<Review>
      // TODO - choose a movie

      Movie movie = MovieDisplay.chooseMovie("Choose a movie", Datastore.getMovies());

      // TODO - Prompt for and read the one-line review
      // TODO - Create the review

      Review review = new Review(user, IOHelper.readNonBlankStringFromKeyboard("Enter your one-line review for '" + movie + "'"));

      // TODO - Add the review to the movie's list of reviews

      movie.addReview(review);

    });

    return reviewsMenu;
  }

  private Menu initListingsMenu() {
    Menu listingsMenu = new Menu("Listings");

    MenuChoice choiceMainListAllMovies = listingsMenu.addMenuChoice("Movies");


    choiceMainListAllMovies.setMenuAction(() -> {
      //TODO - Modify code to sort by movie title (but sort a copy; not the original
      List<Movie> moviesToPrint = Datastore.getMovies();
      boolean userWantsSorted = IOHelper.boolUserInputYorN("Sort by title?");

      // TODO - If the user wants the list sorted, then sort a copy
      List<Movie> moviesToPrintCopy = new ArrayList(moviesToPrint);
	  
      if (userWantsSorted){
        Collections.sort(moviesToPrintCopy);
      }
  
      for (Movie movie : moviesToPrint) {
        System.out.println(movie);
      }
    });

    MenuChoice choiceMainListAllTheaters = listingsMenu.addMenuChoice("Theaters");
    choiceMainListAllTheaters.setMenuAction(() -> {
      for (Theater theater : Datastore.getTheaters()) {
        TheaterDisplay.display(theater);
      }
    });

    MenuChoice choiceMainListAllActors = listingsMenu.addMenuChoice("Actors");
    choiceMainListAllActors.setMenuAction(() -> {
      //TODO - Modify code to sort by actor last name, first name, and age
      List<Actor> actorsToPrint = Datastore.getActors();
      boolean userWantsSorted = IOHelper.boolUserInputYorN("Sort actors by last,first,age?");

      // TODO - If the user wants the list sorted, then sort a copy
      List<Actor> actorsToPrintCopy = new ArrayList(actorsToPrint);

      if (userWantsSorted){
        Collections.sort(actorsToPrintCopy);
      }

      for (Actor actor : actorsToPrintCopy) {
          System.out.println(actor);
        }
    });

    MenuChoice choiceMainListAllShowings = listingsMenu.addMenuChoice("Showings");
    choiceMainListAllShowings.setMenuAction(() -> {
      for (Showing showing : Datastore.getShowings()) {
        System.out.println(showing);
      }
    });

    MenuChoice choiceMainListAllAuditoriums = listingsMenu.addMenuChoice("Auditoriums");
    choiceMainListAllAuditoriums.setMenuAction(() -> {
      for (Auditorium auditorium : Datastore.getAuditoriums()) {
        AuditoriumDisplay.display(auditorium);
      }
    });

    return listingsMenu;

  }

  private Menu initSearchesMenu() {
    Menu searchesMenu = new Menu("Searches");

    MenuChoice choiceMainSearchActorsByName = searchesMenu.addMenuChoice("Search Actors By Name");
    choiceMainSearchActorsByName.setMenuAction(() -> {
      String searchText = IOHelper.readNonBlankStringFromKeyboard("Enter part of the actor name");
      for (Actor actor : Datastore.searchActorsByName(searchText)) {
        System.out.println(actor);
      }
    });

    MenuChoice choiceMainSearchTheatersByName = searchesMenu.addMenuChoice("Search Theaters By Name");
    choiceMainSearchTheatersByName.setMenuAction(() -> {
      String searchText = IOHelper.readNonBlankStringFromKeyboard("Enter part of the theater name");
      for (Theater theater : Datastore.searchTheatersByName(searchText)) {
        System.out.println(theater);
      }
    });

    MenuChoice choiceMainSearchTheatersByZipcode = searchesMenu.addMenuChoice("Search Theaters By Zipcode");
    choiceMainSearchTheatersByZipcode.setMenuAction(() -> {
      String searchText = IOHelper.readNonBlankStringFromKeyboard("Enter zipcode");
      for (Theater theater : Datastore.searchTheatersByZipcode(searchText)) {
        System.out.println(theater);
      }
    });

    MenuChoice choiceMainSearchMoviesByTitle = searchesMenu.addMenuChoice("Search Movies By Title");
    choiceMainSearchMoviesByTitle.setMenuAction(() -> {
      String searchText = IOHelper.readNonBlankStringFromKeyboard("Enter part of the title");
      for (Movie movie : Datastore.searchMoviesByTitle(searchText)) {
        System.out.println(movie);
      }
    });

    return searchesMenu;
  }
}
